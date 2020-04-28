package com.leaf.wxlogin.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.wxlogin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/wx-login")
public class UserController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public JSONObject getOpenId(@RequestBody JSONObject jsonObject) {
        return userService.getOpenId(jsonObject);
    }
}
