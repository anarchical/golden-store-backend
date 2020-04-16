package com.leaf.wxgoods.repository;

import com.leaf.backstagegood.entity.SubType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 9:59 下午
 */
@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Integer> {

    @Query("select new com.leaf.wxgoods.pojo.SubType(subType.id, subType.name, subType.imageUrl) from SubType subType where subType.type.id=:id")
    List<com.leaf.wxgoods.pojo.SubType> findSubTypeByTypeId(@Param("id") int id);

}
