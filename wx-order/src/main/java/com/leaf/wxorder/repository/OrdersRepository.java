package com.leaf.wxorder.repository;

import com.leaf.backstageorder.entity.Orders;
import com.leaf.backstageorder.vo.OrdersVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/22 12:23 上午
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("select new com.leaf.backstageorder.vo.OrdersVO(orders.id,orders.price,orders.createTime," +
            "orders.user.openId,orders.address.cityName,orders.address.countyName,orders.address.detailInfo," +
            "orders.address.postalCode,orders.address.provinceName,orders.address.telNumber," +
            "orders.address.userName,orders.status,orders.remarks) from Orders orders where orders.user.id=:id")
    Page<OrdersVO> findAllOrderVOByUserId(@Param("id") int id, Pageable pageable);


    @Query("select new com.leaf.backstageorder.vo.OrdersVO(orders.id,orders.price,orders.createTime," +
            "orders.user.openId,orders.address.cityName,orders.address.countyName,orders.address.detailInfo," +
            "orders.address.postalCode,orders.address.provinceName,orders.address.telNumber," +
            "orders.address.userName,orders.status,orders.remarks) from Orders orders where orders.id=:id")
    OrdersVO findOrderVOById(@Param("id") int id);
}