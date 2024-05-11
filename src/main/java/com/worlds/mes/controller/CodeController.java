package com.worlds.mes.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import com.worlds.mes.UrlMapping;
import com.worlds.mes.utils.BaseController;
import com.worlds.mes.utils.MesEnumUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Api(value = "验证码",tags = "验证码")
@RestController
@RequestMapping("/sys")
public class CodeController extends BaseController {

    private static final Log log = LogFactory.getLog(CodeController.class);


    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = UrlMapping.CODE)
    @ApiOperation(value = "验证码")
    public void  code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HappyCaptcha.require(request, response).type(CaptchaType.WORD_NUMBER_LOWER).style(CaptchaStyle.ANIM).build().finish();
        String code = String.valueOf(request.getSession().getAttribute("happy-captcha"));
        redisTemplate.opsForValue().set(code,code);
        redisTemplate.expire(code, MesEnumUtils.CodeTimeOut, TimeUnit.SECONDS);
    }


       /*

       @GetMapping("/captcha")
        @ApiOperation(value = "验证码")
        public void happyCaptcha(HttpServletRequest request, HttpServletResponse response){
            boolean finish = HappyCaptcha.require(request, response).style(CaptchaStyle.ANIM).type(CaptchaType.ARITHMETIC_ZH).build().finish();
            Object attribute = request.getSession().getAttribute("happy-captcha");

        *//*HappyCaptcha.require(req,res)
                .style(CaptchaStyle.ANIM)            //设置展现样式为动画
                .type(CaptchaType.CHINESE)            //设置验证码内容为汉字
                .length(6)                            //设置字符长度为6
                .width(220)                            //设置动画宽度为220
                .height(80)                            //设置动画高度为80
                .font(Fonts.getInstance().zhFont())    //设置汉字的字体
                .build().finish();                  //生成并输出验证码
*//*
    }*/

}
