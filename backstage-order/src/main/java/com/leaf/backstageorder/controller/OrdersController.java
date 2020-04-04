package com.leaf.backstageorder.controller;

import com.leaf.backstageorder.entity.Orders;
import com.leaf.backstageorder.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:16 下午
 */
@Slf4j
@RestController
@RequestMapping("/orders")
@Api(value = "订单信息接口")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

//    @ApiOperation(value = "获取所有订单信息")
//    @GetMapping("/allGoods")
//    public Object getAllGoods(@RequestParam(required = false) Integer size,
//                              @RequestParam(required = false) Integer page,
//                              @RequestParam(required = false) String query) {
//        if (page != null && size != null) {
//            if (query == null) {
//                return goodsService.getAllGoods(page - 1, size);
//            }
//            return goodsService.getAllGoods("%" + query + "%", page - 1, size);
//        }
//        return goodsService.getAllGoods();
//    }

    @ApiOperation("获取所有订单信息")
    @GetMapping("/allOrders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }
}
