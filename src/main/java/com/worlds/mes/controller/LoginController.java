package com.worlds.mes.controller;

import com.github.pagehelper.util.StringUtil;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.LoginDto;
import com.worlds.mes.dto.ResultNoPageDto;
import com.worlds.mes.dto.ResultTokenDto;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.service.LoginService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.JwtTokenUtil;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.LoginVo;
import com.worlds.mes.vo.UserRegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Api(value = "登录注册",tags = "登录注册")
@RestController
@RequestMapping("/sys")
public class LoginController  extends BaseController {

    private static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    private RedisTemplate<String,String>  redisTemplate;

    /**
     * 登录
     *
     * @param request
     * @return 登录信息
     */
    @RequestMapping(value = UrlMapping.LOGIN)
    @ApiOperation(value = "登录")
    public ResultTokenDto<List<LoginDto>> login(@RequestBody HashMap<String, String> request, HttpServletRequest requestIp) {
        String username = request.get("username");
        String password = request.get("password");
        String code = request.get("code");
        ResultTokenDto result = new ResultTokenDto();
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)|| StringUtil.isEmpty(code)) {
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("用户名或者密码或者验证码不能为空呦");
            return result;
        }
        String resCode= redisTemplate.opsForValue().get(code);
        if (!code.equals(resCode)){
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("验证码错误");
            return result;
        }
        //删除验证码
        redisTemplate.delete(resCode);
        String ip = "";
        if (requestIp != null) {
            ip = requestIp.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = requestIp.getRemoteAddr();
            }
        }
        //给前台返回token
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.generateToken(username);
        List<SysUser> login = loginService.login(username, password, ip,token);
        if (login.size()<=0) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("账号或者密码错误");
            return result;
        }

        result = getTokenDataByLogin(login, LoginDto.class);
        result.setAccessToken(token);
        //删除验证码
        redisTemplate.delete(code);
        return result;
    }


    /**
     * 退出登录
     *
     * @param vo ,requestIp
     * @return resultTokenDto
     */
    @RequestMapping(value = UrlMapping.LOGIN_OUT)
    @ApiOperation(value = "退出登录")
    public ResultTokenDto loginOut(@RequestBody LoginVo vo,HttpServletRequest requestIp) {
        ResultTokenDto resultTokenDto = new ResultTokenDto();
        if (null==vo || StringUtils.isEmpty(vo.getLoginName())||StringUtils.isEmpty(vo.getToken())||StringUtils.isEmpty(vo.getNickName()) ){
            resultTokenDto.setCode(MesEnumUtils.CODE_5000);
            resultTokenDto.setMessage("账号或者token或者昵称不能为空呦");
            resultTokenDto.setSuccess(false);
            return resultTokenDto;
        }
        String ip = "";
        if (requestIp != null) {
            ip = requestIp.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = requestIp.getRemoteAddr();
            }
        }
        boolean b = loginService.loginOut(vo,ip);
        resultTokenDto.setCode(MesEnumUtils.CODE_200);
        resultTokenDto.setSuccess(b);
        resultTokenDto.setMessage("退出登录成功");
        return resultTokenDto;
    }

    /**
     * 用户注册
     *
     * @param vo ,requestIp
     * @return resultTokenDto
     */
    @RequestMapping(value = UrlMapping.USER_REGISTER)
    @ApiOperation(value = "用户注册")
    public ResultNoPageDto userRegister(@RequestBody UserRegisterVo vo, HttpServletRequest requestIp) {
        ResultNoPageDto resultNoPageDto = new ResultNoPageDto();
        resultNoPageDto.setCode(MesEnumUtils.CODE_5001);
        resultNoPageDto.setSuccess(false);
        if (null==vo){
            resultNoPageDto.setMessage("参数不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getLoginName())){
            resultNoPageDto.setMessage("登录名不能为空");
            return resultNoPageDto;

        }
        if (StringUtils.isEmpty(vo.getPwd())){
            resultNoPageDto.setMessage("密码不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getNickName())){
            resultNoPageDto.setMessage("昵称不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getDeptId())){
            resultNoPageDto.setMessage("部门id不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getEnable())){
            resultNoPageDto.setMessage("是否启用不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getRoleId())){
            resultNoPageDto.setMessage("角色不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getAdmin())){
            resultNoPageDto.setMessage("是否为超级管理员不能为空");
            return resultNoPageDto;
        }
        if (StringUtils.isEmpty(vo.getPhoneNum())){
            resultNoPageDto.setMessage("手机号不能为空");
            return resultNoPageDto;
        }
        String ip = "";
        if (requestIp != null) {
            ip = requestIp.getHeader("X-FORWARDED-FOR");
            if (ip == null || "".equals(ip)) {
                ip = requestIp.getRemoteAddr();
            }
        }
        boolean b = loginService.userRegister(vo, ip);
        if (!b){
            resultNoPageDto.setMessage("注册失败,可能是用户已经存在");
            resultNoPageDto.setCode(MesEnumUtils.CODE_5002);
            return resultNoPageDto;
        }
        resultNoPageDto.setCode(MesEnumUtils.CODE_200);
        resultNoPageDto.setMessage("注册成功");
        resultNoPageDto.setSuccess(true);
        return new ResultNoPageDto();
    }
    /**
     * 测试
     *
     * @param request
     * @return 测试
     */
    @RequestMapping(value = UrlMapping.TEST)
    @ApiOperation(value = "测试ip")
    public String test(@RequestBody HashMap<String, String> request, HttpServletRequest requestIp) {
        String remoteAddr = requestIp.getRemoteAddr();
        log.info(remoteAddr);


        String remoteAddr1 = "";

        if (request != null) {
            remoteAddr1 = requestIp.getHeader("X-FORWARDED-FOR");
            if (remoteAddr1 == null || "".equals(remoteAddr1)) {
                remoteAddr1 = requestIp.getRemoteAddr();
            }
        }
        log.info(remoteAddr1);
        return remoteAddr;
    }
    /**
     * 测试token
     *
     * @param username
     * @return token
     */
    @RequestMapping(value = UrlMapping.TEST_TOKEN,method = RequestMethod.POST)
    @ApiOperation(value = "测试token")
    public String testToken(@RequestBody String username) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.generateToken(username);
        log.info(token);
        return token;
    }
}