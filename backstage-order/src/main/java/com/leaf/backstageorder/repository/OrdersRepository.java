package com.leaf.backstageorder.repository;

import com.leaf.backstageorder.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:09 下午
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}