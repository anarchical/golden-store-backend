package com.leaf.wxgoods.repository;

import com.leaf.backstagegood.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:46
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query("select new com.leaf.wxgoods.pojo.Type(type.id, type.name) from Type type")
    List<com.leaf.wxgoods.pojo.Type> findAllType();

}
