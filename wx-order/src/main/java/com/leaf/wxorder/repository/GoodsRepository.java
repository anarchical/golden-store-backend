package com.leaf.wxorder.repository;

import com.leaf.backstagegood.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/29 8:58 下午
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    @Query("select goods.stock from Goods goods where goods.id =:id")
    int findStockById(@Param("id") int id);

    @Modifying
    @Query("update Goods goods set goods.stock =:stock where goods.id=:id")
    int updateStockById(@Param("stock") int stock, @Param("id") int id);
}
