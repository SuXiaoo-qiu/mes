package com.worlds.mes.controller;

import com.github.pagehelper.util.StringUtil;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.LoginDto;
import com.worlds.mes.dto.ResultTokenDto;
import com.worlds.mes.entity.SysUser;
import com.worlds.mes.service.LoginService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.JwtTokenUtil;
import com.worlds.mes.utils.MesEnumUtils;
import com.worlds.mes.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ResultTokenDto result = new ResultTokenDto();
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            result.setCode(MesEnumUtils.CODE_5001);
            result.setSuccess(false);
            result.setMessage("用户名或者密码不能为空呦");
            return result;
        }
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
        result.setToken(token);
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
}