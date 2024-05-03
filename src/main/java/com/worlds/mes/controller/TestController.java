package com.worlds.mes.controller;

import com.worlds.mes.UrlMapping;
import com.worlds.mes.utils.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(value = "测试",tags = "测试功能")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    private static Log log = LogFactory.getLog(TestController.class);

    @Autowired
    private RedisTemplate  redisTemplate;

    @RequestMapping(value = UrlMapping.TEST)
    @ApiOperation(value = "测试String转list")
    public List  test() {
        String array = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29";
        List<String> strings = Arrays.asList(array.split(","));

        List strings1 = new ArrayList<>();
        strings1.add(strings);

        log.debug(strings.toString());
        return strings ;
    }
}
