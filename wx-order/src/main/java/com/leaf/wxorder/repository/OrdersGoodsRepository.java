package com.leaf.wxorder.repository;

import com.leaf.backstageorder.entity.OrdersGoods;
import com.leaf.backstageorder.vo.OrdersGoodsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/22 12:23 上午
 */
@Repository
public interface OrdersGoodsRepository extends JpaRepository<OrdersGoods,Integer> {

    @Query("select new com.leaf.backstageorder.vo.OrdersGoodsVO(og.id,og.goods.id," +
            "og.quantity,og.goods.name,og.goods.price) from OrdersGoods og where og.order.id=:id")
    List<OrdersGoodsVO> findByOrdersId(@Param("id") int id);
}
