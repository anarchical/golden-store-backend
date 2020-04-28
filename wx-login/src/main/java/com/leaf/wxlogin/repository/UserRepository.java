package com.leaf.wxlogin.repository;

import com.leaf.backstageuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 3:14 下午
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByOpenId(String openId);

    User findByOpenId(String openId);
}
