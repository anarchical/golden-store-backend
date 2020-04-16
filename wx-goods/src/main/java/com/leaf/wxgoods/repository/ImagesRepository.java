package com.leaf.wxgoods.repository;

import com.leaf.backstagegood.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/13 1:29 上午
 */
@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer> {

    @Query("select new com.leaf.wxgoods.pojo.Images (images.id, images.name,images.url) from Images images where images.goods.id=:id")
    List<com.leaf.wxgoods.pojo.Images> findImageListByGoodsId(@Param("id") int id);
}
