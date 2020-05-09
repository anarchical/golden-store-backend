package com.leaf.backstageorder.repository;

import com.leaf.backstageorder.entity.Orders;
import com.leaf.backstageorder.vo.OrdersVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:09 下午
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query("select new com.leaf.backstageorder.vo.OrdersVO(orders.id,orders.price,orders.createTime," +
            "orders.user.openId,orders.address.cityName,orders.address.countyName,orders.address.detailInfo," +
            "orders.address.postalCode,orders.address.provinceName,orders.address.telNumber," +
            "orders.address.userName,orders.status,orders.remarks) from Orders orders ")
    Page<OrdersVO> findAllOrderVO(Pageable pageable);


    @Query("select new com.leaf.backstageorder.vo.OrdersVO(orders.id,orders.price,orders.createTime," +
            "orders.user.openId,orders.address.cityName,orders.address.countyName,orders.address.detailInfo," +
            "orders.address.postalCode,orders.address.provinceName,orders.address.telNumber," +
            "orders.address.userName,orders.status,orders.remarks) from Orders orders where orders.id=:id")
    OrdersVO findOrderVOById(@Param("id") int id);

    @Modifying
    @Query("update Orders orders set orders.status=:status,orders.remarks=:remarks where orders.id=:id")
    int updateOrderById(@Param("id") int id,@Param("status") String status,@Param("remarks") String remarks);
}