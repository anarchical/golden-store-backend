package com.leaf.backstageorder.service;

import com.leaf.backstageorder.repository.OrdersGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:10 下午
 */
@Service
public class OrdersGoodsService {

    @Autowired
    OrdersGoodsRepository ordersGoodsRepository;


}
