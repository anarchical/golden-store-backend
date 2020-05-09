package com.leaf.wxorder.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leaf.backstagegood.entity.Goods;
import com.leaf.backstageorder.entity.Orders;
import com.leaf.backstageorder.entity.OrdersGoods;
import com.leaf.backstageorder.enums.OrdersEnum;
import com.leaf.backstageuser.entity.Address;
import com.leaf.backstageuser.entity.User;
import com.leaf.wxorder.repository.AddressRepository;
import com.leaf.wxorder.repository.OrdersGoodsRepository;
import com.leaf.wxorder.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/28 4:16 下午
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersGoodsRepository ordersGoodsRepository;

    public void addOrder(JSONObject jsonObject) {

        User user = new User();
        user.setId(jsonObject.getJSONObject("user").toJavaObject(User.class).getId());

        Address newAddress = jsonObject.getJSONObject("address").toJavaObject(Address.class);
        newAddress.setUser(user);

        Address address = setAddress(newAddress, user.getId());


        Orders orders = new Orders();
        orders.setPrice(jsonObject.getFloat("price"));
        orders.setAddress(address);
        orders.setUser(user);
        orders.setStatus(OrdersEnum.UNDO.getStatus());

        Orders order = ordersRepository.save(orders);


        List<OrdersGoods> ordersGoodsList = new ArrayList<>();

        JSONArray orderGoodsJsonList = jsonObject.getJSONArray("goods");

        for (int i = 0; i < orderGoodsJsonList.size(); i++) {
            OrdersGoods ordersGoods = new OrdersGoods();
            Goods goods=new Goods();
            ordersGoods.setQuantity(orderGoodsJsonList.getJSONObject(i).getInteger("quantity"));
            goods.setId(orderGoodsJsonList.getJSONObject(i).getInteger("id"));
            ordersGoods.setGoods(goods);
            ordersGoods.setOrder(order);
            ordersGoodsList.add(ordersGoods);

        }

        log.info("订单商品{}",ordersGoodsList.size());

        ordersGoodsRepository.saveAll(ordersGoodsList);


        log.info("orderGoodsList{}", ordersGoodsList.size());
        log.info("address{}", address);
        log.info("user{}", user);

    }

    private Address setAddress(Address newAddress, int userId) {

        List<Address> addressList = addressRepository.getAddressByUserId(userId);

        for (Address address : addressList) {
            if (newAddress.getDetailInfo().equals(address.getDetailInfo())) {
                log.info("地址已经存在，直接返回");
                return address;
            }
        }
        log.info("地址不存在，新增后返回");
        return addressRepository.save(newAddress);
    }

}
