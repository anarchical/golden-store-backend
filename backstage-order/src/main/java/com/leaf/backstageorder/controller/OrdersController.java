package com.leaf.backstageorder.controller;

import com.leaf.backstageorder.service.OrdersService;
import com.leaf.backstageorder.vo.OrdersVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Page<OrdersVO> getAllOrders(@RequestParam(value = "size") Integer size,
                                       @RequestParam(value = "page") Integer page,
                                       @RequestParam(required = false) String query) {

        return ordersService.getAllOrders(page - 1, size);
        //todo 添加查询
    }

    @ApiOperation("获取所有订单信息根据状态")
    @GetMapping("/allOrdersByStatus")
    public Page<OrdersVO> getAllOrdersByStatus(@RequestParam(value = "size") Integer size,
                                               @RequestParam(value = "page") Integer page,
                                               @RequestParam(value = "status") String status) {
        return ordersService.getAllOrdersByStatus(page - 1, size, status);
    }

    @ApiOperation(value = "通过id查询订单信息")
    @GetMapping("/queryOrders")
    public OrdersVO getGoodsById(@RequestParam("id") int id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping("/updateOrders")
    private int updateOrders(@RequestBody OrdersVO ordersVO) {
        return ordersService.updateOrders(ordersVO);
    }

    @ApiOperation(value = "删除订单信息")
    @GetMapping("/deleteOrders")
    public boolean deleteOrders(@RequestParam("id") int id) {
        try {
            ordersService.deleteOrdersById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }

}
