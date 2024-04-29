package com.worlds.mes.controller;

import com.github.pagehelper.util.StringUtil;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.LoginDto;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.entity.User;
import com.worlds.mes.service.LoginService;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Api(value = "登录注册",tags = "登录注册")
@RestController
@RequestMapping("/sys")
public class LoginController  extends BaseController {

    private static Log log = LogFactory.getLog(DepartmentController.class);

    @Autowired
    LoginService loginService;

    /**
     * 登录
     *
     * @param  request
     * @return 登录信息
     */
    @RequestMapping(value = UrlMapping.LOGIN)
    @ApiOperation(value = "登录")
    public ResultDto<List<LoginDto>> login(@RequestBody HashMap<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        ResultDto result = new ResultDto();
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
                result.setCode(MesEnumUtils.CODE_5001);
                result.setSuccess(false);
                result.setMessage("用户名或者密码不能为空呦");
                return result;
        }
        List<User> login = loginService.login(username,password);
        if (login.isEmpty()) {
            result.setCode(MesEnumUtils.CODE_5000);
            result.setSuccess(false);
            result.setMessage("账号或者密码错误");
            return result;
        }

        result =getPageDataByMap(login, User.class);
        return result ;
    }

}
