package com.leaf.backstagegood.repository;

import com.leaf.backstagegood.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findById(int id);

    @Query("select type from Type type")
    Page<Type> findAllType(Pageable pageable);

    @Query("select type from Type type where type.name like :query")
    Page<Type> findTypesByQuery(@Param("query") String query, Pageable pageable);

}
