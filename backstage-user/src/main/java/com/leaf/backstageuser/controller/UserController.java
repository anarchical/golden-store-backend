package com.leaf.backstageuser.controller;

import com.leaf.backstageuser.pojo.User;
import com.leaf.backstageuser.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/allUser")
    public Map getAllMainMenu(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        Claims claims = jwtUtil.parseJwt(authorization);
        System.out.println(claims.get("username") + "\n" + claims.get("password"));
        System.out.println(authorization);
        User user1 = new User("张三", "123", "123", "123");
        User user2 = new User("张三", "123", "123", "123");
        User user3 = new User("张三", "123", "123", "123");
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Map map = new HashMap();
        map.put("pagenum", 1);
        map.put("total", 4);
        map.put("users", list);

        return map;
    }


}
