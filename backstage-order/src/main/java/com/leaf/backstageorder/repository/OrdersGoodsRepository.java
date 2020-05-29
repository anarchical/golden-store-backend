package com.leaf.backstageorder.repository;

import com.leaf.backstageorder.entity.OrdersGoods;
import com.leaf.backstageorder.vo.OrdersGoodsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:09 下午
 */
@Repository
public interface OrdersGoodsRepository extends JpaRepository<OrdersGoods, Integer> {

    @Query("select new com.leaf.backstageorder.vo.OrdersGoodsVO(og.id,og.goods.id," +
            "og.quantity,og.goods.name,og.goods.price) from OrdersGoods og where og.order.id=:id")
    List<OrdersGoodsVO> findByOrdersId(@Param("id") int id);

    @Query("select sum(og.goods.myReturn*og.quantity) from OrdersGoods og where og.order.status=:status")
    Float getAllReturn(@Param("status") String status);

    @Query("select sum(og.goods.myReturn*og.quantity) from OrdersGoods og where  og.order.createTime >:time and og.order.status=:status")
    Float getAllReturnByTime(@Param("time") LocalDateTime time, @Param("status") String status);
}
