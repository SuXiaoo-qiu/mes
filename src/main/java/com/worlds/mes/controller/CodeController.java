package com.worlds.mes.controller;

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

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(value = "验证码",tags = "验证码")
@RestController
@RequestMapping("/sys")
public class CodeController extends BaseController {

    private static final Log log = LogFactory.getLog(CodeController.class);

    @Autowired
    private RedisTemplate  redisTemplate;

    @RequestMapping(value = UrlMapping.CODE)
    @ApiOperation(value = "验证码")
    public String  code() {
        String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
        redisTemplate.opsForValue().set(substring,substring);
        redisTemplate.expire(substring, MesEnumUtils.CodeTimeOut, TimeUnit.SECONDS);

        return substring ;
    }

}
