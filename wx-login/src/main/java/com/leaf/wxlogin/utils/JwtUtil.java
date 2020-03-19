package com.leaf.wxlogin.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.key}")
    private String key;

    @Value("${jwt.expTime}")
    private long expTime;

    public String createJwt(String username, String password) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuedAt(new Date()) //设置当前时间
                .signWith(SignatureAlgorithm.HS256, key) //设置加密算法和私钥
                .setExpiration(new Date(System.currentTimeMillis() + expTime))//设置token失效时间
                .claim("username", username)
                .claim("password", password);
        return jwtBuilder.compact();
    }

}
