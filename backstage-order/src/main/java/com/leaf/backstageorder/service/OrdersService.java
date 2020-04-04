package com.leaf.backstageorder.service;

import com.leaf.backstageorder.entity.Orders;
import com.leaf.backstageorder.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:10 下午
 */
@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

//    public Object getAllGoods(String query, Integer page, Integer size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return goodsRepository.findGoodsByQuery("%" + query + "%", pageRequest);
//    }
//
//    public Object getAllGoods(Integer page, Integer size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        return goodsRepository.findAllGoods(pageRequest);
//    }
//
//    public Object getAllGoods() {
//        return goodsRepository.findAll();
//    }

    public List<Orders> getAllOrders(){
        return  ordersRepository.findAll();
    }
}
