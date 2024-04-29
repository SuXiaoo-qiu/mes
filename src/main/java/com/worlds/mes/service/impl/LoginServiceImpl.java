package com.worlds.mes.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.worlds.mes.entity.User;
import com.worlds.mes.mapper.LoginMapper;
import com.worlds.mes.service.LoginService;
import com.worlds.mes.utils.HashUtil;
import com.worlds.mes.utils.JwtTokenUtil;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.UserVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private static Log log = LogFactory.getLog(LoginServiceImpl.class);


    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public List<User> login(String username, String password) {
        UserVo userVo = new UserVo();
        List<User> res = new ArrayList<>();
        userVo.setLoginName(username);
        userVo.setPwd(password);
        String hashedPassword = HashUtil.hash(password);

        // 根据登录名查询数据库 是否有符合条件的数据
        User user = new LambdaQueryChainWrapper<>(loginMapper)
                .eq(User::getLoginName, userVo.getLoginName())
                .eq(User::getPwd,hashedPassword).one();
        if (!StringUtils.isEmpty(user)){
            // 验证密码
            boolean result = HashUtil.verify(password, user.getPwd());
            if (!result){
                return res;
            }
            // token存redis
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            String token = jwtTokenUtil.generateToken(username);
            redisTemplate.opsForValue().set(username,token);
            //有效期30分钟 1800秒
            redisTemplate.expire(username, MesEnumUtils.RedisTimeout, TimeUnit.SECONDS);
            res.add(user);
        }
        return res;
    }
}