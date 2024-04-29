package com.worlds.mes.config;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.worlds.mes.dto.ResultDto;
import com.worlds.mes.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@Component
public class JwtTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 排除swagger访问接口
        String path = request.getRequestURI();
        if (path.contains("swagger") || path.contains("doc")) {
            return true;
        }

        String token = request.getHeader("Authorization");
        // 校验 Token
        if (token == null) {
            // 返回客户端数据
            this.resData(response);
            return false;
        }


        // 校验token(redis)是否过期
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        HashMap<String, Object> res = jwtTokenUtil.validateToken(token);
        // 如果没有过期
        if (res.get("state").equals("true")) {
            String username = redisTemplate.opsForValue().get(res.get("username").toString());
            if (StringUtil.isEmpty(username)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Please login first.");
                jwtTokenUtil.removeToken(username);
                // 返回客户端数据
                this.resData(response);
                return false;
            }
            if(username.equals(token)){
                return true;
            }
        }
        // 返回客户端数据
        this.resData(response);
        return false;
    }


    /**
     * 返回客户端数据
     */
    public void resData(HttpServletResponse response) throws Exception {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(401);
        resultDto.setMessage("会话过期请重新登录");
        resultDto.setSuccess(false);
        String s = JSON.toJSONString(resultDto);
        returnJson(response, s);
    }

    /**
     * 返回客户端数据
     */
    private void returnJson(HttpServletResponse response, String result) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(result);

        } catch (IOException e) {
        } finally {
            if (writer != null) {
                writer.close();
            }
        }


    }
}
