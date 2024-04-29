package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.worlds.mes.entity.LoginLog;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.mapper.LoginLogMapper;
import com.worlds.mes.mapper.LoginMapper;
import com.worlds.mes.service.LoginService;
import com.worlds.mes.utils.HashUtil;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.SysUserVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private static Log log = LogFactory.getLog(LoginServiceImpl.class);


    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoginLogMapper loginLogMapper;


    @Override
    public List<SysUser> login(String username, String password, String ip, String token) {
        SysUserVo userVo = new SysUserVo();
        userVo.setLoginName(username);
        userVo.setPwd(password);
        String hashedPassword = HashUtil.hash(password);
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        // 根据登录名查询数据库 是否有符合条件的数据
        SysUser user = new LambdaQueryChainWrapper<>(loginMapper)
                .eq(SysUser::getLoginName, userVo.getLoginName())
                .eq(SysUser::getPwd,hashedPassword).one();
        if (!StringUtils.isEmpty(user)){
            // 验证密码
            boolean result = HashUtil.verify(password, user.getPwd());
            if (!result){
                return sysUsers;
            }
            // token存redis (放在controller(因为要返回前端))
            /*JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            String token = jwtTokenUtil.generateToken(username);*/
            redisTemplate.opsForValue().set(username,token);
            //有效期30分钟 1800秒
            redisTemplate.expire(username, MesEnumUtils.RedisTimeout, TimeUnit.SECONDS);
            sysUsers.add(user);
            LoginLog loginLog = new LoginLog();
            loginLog.setIp(ip);
            loginLog.setId(0);
            loginLog.setUserId(username);
            loginLog.setUserName(user.getNickName());
            loginLog.setLoginDate(new Date());
            loginLog.setMessage("登录成功");
            loginLogMapper.insert(loginLog);
            log.info("登录成功");
        }
        return sysUsers;
    }
}