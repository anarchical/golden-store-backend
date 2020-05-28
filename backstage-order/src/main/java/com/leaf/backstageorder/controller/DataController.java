package com.leaf.backstageorder.controller;

import com.leaf.backstageorder.entity.OrdersGoods;
import com.leaf.backstageorder.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/28 8:46 下午
 */
@Slf4j
@RestController
@RequestMapping("/data")
@Api(value = "订单信息接口")
public class DataController {

    @Autowired
    DataService dataService;

    @ApiOperation("获取所有订单信息")
    @GetMapping("/allData")
    public Map<String, Object> getAllOrders() {

        return dataService.getAllOrdersGoods();
        //todo 添加查询
    }
}
