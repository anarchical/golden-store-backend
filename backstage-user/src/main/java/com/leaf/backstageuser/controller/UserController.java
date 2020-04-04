package com.leaf.backstageuser.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstageuser.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/allUser")
    public Map getAllMainMenu(HttpServletRequest request,
                              @RequestParam(value = "query", required = false) String query,
                              @RequestParam(value = "pagesize", required = false) int pagesize,
                              @RequestParam(value = "pagenum", required = false) int pagenum) {
//        String authorization = request.getHeader("Authorization");
//        Claims claims = jwtUtil.parseJwt(authorization);
//        log.info(claims.get("username") + "\n" + claims.get("password"));
//        log.info(authorization);
//        User user1 = new User("张三", "123", "123", "123", false);
//        User user2 = new User("Lisi", "123", "123", "123", true);
//        User user3 = new User("wangyi", "123", "123", "123", false);
//        List list = new ArrayList();
//        for (int i = 0; i < 3; i++) {
//            list.add(user1);
//            list.add(user2);
//            list.add(user3);
//        }

        Map map = new HashMap();
        map.put("pagenum", 1);
        map.put("total", 3);
//        map.put("userList", list);

        log.info(query + "\n" + pagenum + "\n" + pagesize);

        return map;
    }

    @PostMapping("/addUser")
    public Map addUser(@RequestBody JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
        Map map = new HashMap();
        map.put("message", "success");
        return map;
    }


}
