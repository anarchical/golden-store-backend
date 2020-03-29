package com.leaf.backstagegood.repository;

import com.leaf.backstagegood.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/27 7:14 下午
 */
@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer> {

    List<Images> findByGoodsId(int id);
}
