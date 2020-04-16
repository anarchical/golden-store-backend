package com.leaf.wxgoods.repository;

import com.leaf.backstagegood.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/13 1:20 上午
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    @Query("select new com.leaf.wxgoods.pojo.Goods (goods.id, goods.name) from Goods goods")
    Page<com.leaf.wxgoods.pojo.Goods> findAllGoods(Pageable pageable);

    @Query("select new com.leaf.wxgoods.pojo.Goods (goods.id, goods.name) from Goods goods where goods.subType.id=:id")
    Page<com.leaf.wxgoods.pojo.Goods> findAllGoodsBySubTypeId(Pageable pageable, @Param("id") int id);

    @Query("select new com.leaf.wxgoods.pojo.Goods (goods.id, goods.name) from Goods goods where goods.name like :query")
    Page<com.leaf.wxgoods.pojo.Goods> findAllGoodsByQuery(Pageable pageable, @Param("query") String query);

    @Query("select new com.leaf.wxgoods.pojo.Goods (goods.id, goods.name) from Goods goods where goods.id=:id")
    com.leaf.wxgoods.pojo.Goods findGoodsById(@Param("id") int id);
}
