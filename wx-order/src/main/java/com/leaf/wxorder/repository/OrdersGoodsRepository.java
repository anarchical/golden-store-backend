package com.leaf.wxorder.repository;

import com.leaf.backstageorder.entity.OrdersGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/22 12:23 上午
 */
@Repository
public interface OrdersGoodsRepository extends JpaRepository<OrdersGoods,Integer> {
}