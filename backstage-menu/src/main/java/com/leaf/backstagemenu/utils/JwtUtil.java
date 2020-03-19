package com.leaf.backstagemenu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.key}")
    private String key;

    /**
     * token解析方法
     * @param token 前端返回的token值
     * @return 返回解析结果
     */
    public Claims parseJwt(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
