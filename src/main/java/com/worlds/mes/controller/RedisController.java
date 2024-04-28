package com.worlds.mes.controller;

import com.worlds.mes.UrlMapping;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.utils.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Api(value = "测试",tags = "redis测试")
@RestController
@RequestMapping("/redis")
public class RedisController extends BaseController {

    private static Log log = LogFactory.getLog(DepartmentController.class);

    @Autowired
    private RedisTemplate  redisTemplate;

    @RequestMapping(value = UrlMapping.TEST)
    @ApiOperation(value = "redis测试")
    public ResultDto  login(@RequestBody HashMap<String, Object> map) {
        ResultDto result = new ResultDto();
        redisTemplate.opsForValue().set(map.get("username"),map.get("password"));
        return result ;
    }
}
