package com.worlds.mes.utils;

import com.github.pagehelper.util.StringUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtTokenUtil {
    private static final String SECRET_KEY = "tototoken-secretkey";
    private static final long EXPIRATION_TIME = MesEnumUtils.TokenTimeout;  //有效期30分钟 1800000毫秒


    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }
    //判断koken是否有效
    public HashMap<String, Object> validateToken(String token) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("state", "false");
        res.put("msg", "token无效");
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            String username = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
            if (StringUtil.isEmpty(username)) {
               return res;
            }
            res.put("state", "true");
            res.put("msg", "token有效");
            res.put("username", username);
            return res;
        } catch (Exception e) {
            return res;
        }
    }

    /**
     *  销毁token
     */
    public String removeToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 0))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
