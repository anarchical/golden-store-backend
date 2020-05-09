package com.leaf.backstageorder.service;

import com.leaf.backstageorder.repository.OrdersGoodsRepository;
import com.leaf.backstageorder.repository.OrdersRepository;
import com.leaf.backstageorder.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:10 下午
 */
@Service
@Transactional
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersGoodsRepository ordersGoodsRepository;

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

    public Page<OrdersVO> getAllOrders(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrdersVO> ordersVOList = ordersRepository.findAllOrderVO(pageRequest);

        for (OrdersVO ordersVO : ordersVOList) {
            ordersVO.setGoodsVOList(ordersGoodsRepository.findByOrdersId(ordersVO.getId()));
        }
        return ordersVOList;
    }

    public OrdersVO getOrderById(int id) {

        OrdersVO ordersVO = ordersRepository.findOrderVOById(id);
        ordersVO.setGoodsVOList(ordersGoodsRepository.findByOrdersId(ordersVO.getId()));
        return ordersVO;
    }

    public int updateOrders(OrdersVO ordersVO) {
        return ordersRepository.updateOrderById(ordersVO.getId(), ordersVO.getStatus(), ordersVO.getRemarks());
    }

    public void deleteOrdersById(int id){
         ordersRepository.deleteById(id);
    }
}
