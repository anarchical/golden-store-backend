package com.leaf.backstagegood.repository;

import com.leaf.backstagegood.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:46
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    Goods findById(int id);

    @Query("select goods from Goods goods")
    Page<Goods> findAllGoods(Pageable pageable);

    @Query("select goods from Goods goods where goods.name like :query")
    Page<Goods> findGoodsByQuery(@Param("query") String query, Pageable pageable);

    List<Goods> findGoodsBySubTypeId(int id);

    @Modifying
    @Query("update Goods goods set goods.isSell=:isSell where goods.id=:id")
    int updateGoodsSell(@Param("id") int id, @Param("isSell") boolean isSell);
}
