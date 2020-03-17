package com.leaf.wxlogin;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class controller {

    @PostMapping("/wx-login")
    public Map<String, String> getUserInfo(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        Map<String, String> token = new HashMap<>();
        token.put("token", "abdshaviauehijbFIDYFIYY111");
        return token;
    }
}
