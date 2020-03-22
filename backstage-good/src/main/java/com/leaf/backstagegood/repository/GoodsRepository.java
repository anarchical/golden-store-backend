package com.leaf.backstagegood.repository;

import com.leaf.backstagegood.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:46
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
