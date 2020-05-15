package com.leaf.wxorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstageorder.vo.OrdersVO;
import com.leaf.wxorder.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation("获取所有订单信息")
    @GetMapping("/allOrders")
    public Page<OrdersVO> getAllOrders(@RequestParam(value = "size") Integer size,
                                       @RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "id") Integer id,
                                       @RequestParam(required = false) String query) {

        return orderService.getAllOrders(page - 1, size, id);
        //todo 添加查询
    }

    @ApiOperation(value = "通过id查询订单信息")
    @GetMapping("/queryOrders")
    public OrdersVO getOrdersById(@RequestParam("id") int id) {
        return orderService.getOrderById(id);
    }


}
