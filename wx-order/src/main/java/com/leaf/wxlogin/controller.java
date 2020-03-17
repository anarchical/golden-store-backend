package com.leaf.wxlogin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class controller {

    @PostMapping("/wx-order")
    public Map<String, String> getUserOrder(@RequestBody JSONObject jsonObject,HttpServletRequest request) {
        System.out.println(jsonObject);
        System.out.println(JSON.toJSONString(request.getParameter("Authorization")));
        Map<String, String> orderNumber = new HashMap<>();
        orderNumber.put("orderNumber", "zheshidingdanbiaohaomonia");
        return orderNumber;
    }

    @PostMapping("/wx-pay")
    public Map<String, String> pay(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        Map<String, String> pay = new HashMap<>();
        pay.put("nonceStr", "zheshidingdanbiaohaomonia");
        pay.put("package", "zheshidingdanbiaohaomonia");
        pay.put("paySign", "zheshidingdanbiaohaomonia");
        pay.put("timeStamp", "zheshidingdanbiaohaomonia");
        pay.put("signType", "zheshidingdanbiaohaomonia");
        return pay;
    }
}
