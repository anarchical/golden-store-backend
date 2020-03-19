package com.leaf.backstageuser.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstageuser.pojo.User;
import com.leaf.backstageuser.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map getAllMainMenu(HttpServletRequest request,
                              @RequestParam(value = "query",required = false) String query,
                              @RequestParam(value = "pagesize",required = false) int pagesize,
                              @RequestParam(value = "pagenum",required = false) int pagenum) {
        String authorization = request.getHeader("Authorization");
        Claims claims = jwtUtil.parseJwt(authorization);
        System.out.println(claims.get("username") + "\n" + claims.get("password"));
        System.out.println(authorization);
        User user1 = new User("张三", "123", "123", "123", false);
        User user2 = new User("张三", "123", "123", "123", true);
        User user3 = new User("张三", "123", "123", "123", false);
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Map map = new HashMap();
        map.put("pagenum", 1);
        map.put("total", 3);
        map.put("users", list);

        System.out.println(query+"\n"+pagenum+"\n"+pagesize);

        return map;
    }


}
