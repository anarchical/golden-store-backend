package com.leaf.backstageorder.repository;

import com.leaf.backstageorder.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/11 10:55 下午
 */
@Service
public interface OpinionRepository extends JpaRepository<Opinion,Integer> {
}
