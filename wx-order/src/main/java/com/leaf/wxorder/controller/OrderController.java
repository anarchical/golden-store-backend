package com.leaf.wxorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.wxorder.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/21 11:31 下午
 */
@Slf4j
@RestController
@RequestMapping("/wx-orders")
@Api(value = "微信订单信息接口")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/creatOrders")
    public JSONObject setOrders(@RequestBody JSONObject jsonObject) {

        log.info(jsonObject.toJSONString());
        orderService.addOrder(jsonObject);
        return jsonObject;
    }
}
