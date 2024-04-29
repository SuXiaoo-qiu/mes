package com.worlds.mes.config;

import com.github.pagehelper.util.StringUtil;
import com.worlds.mes.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Please login first.");
            return false;
        }



        // 校验token(redis)是否过期
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        HashMap<String, Object> res = jwtTokenUtil.validateToken(token);
        if (res.get("state").equals("true")){
            String username = redisTemplate.opsForValue().get(res.get("username").toString());
            if (StringUtil.isEmpty(username)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Please login first.");
                jwtTokenUtil.removeToken(username);
                return false;
            }
            return true;
        }

        return false;
    }


}
