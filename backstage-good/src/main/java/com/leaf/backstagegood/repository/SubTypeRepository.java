package com.leaf.backstagegood.repository;

import com.leaf.backstagegood.entity.SubType;
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
 * @email yyq920201895@163.com
 * @time 2020/4/4 9:59 下午
 */
@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Integer> {


    SubType findById(int id);

    @Query("select subType from SubType subType")
    Page<SubType> findAllSubType(Pageable pageable);

    @Query("select subType from SubType subType where subType.name like :query")
    Page<SubType> findSubTypeByQuery(@Param("query") String query, Pageable pageable);


    List<SubType> findSubTypeByTypeId(int id);

    @Modifying
    @Query("update SubType subtype set subtype.imageUrl=:imageUrl where subtype.id=:id")
    int updateImageUrl(@Param("id") int id, @Param("imageUrl") String imageUrl);
}
