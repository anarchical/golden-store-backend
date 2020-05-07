package com.leaf.backstageuser.repository;

import com.leaf.backstageuser.entity.User;
import com.leaf.backstageuser.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/5 8:33 下午
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select new com.leaf.backstageuser.vo.UserVO(user.id,user.openId,user.nickName,user.gender,user.language,user.city,user.province,user.country,user.avatarUrl) from User user")
    Page<UserVO> findAllUserVO(Pageable pageable);




    @Query("select new com.leaf.backstageuser.vo.UserVO(user.id,user.openId,user.nickName,user.gender,user.language,user.city,user.province,user.country,user.avatarUrl) from User user where user.id=:id")
    UserVO findUserVOById(@Param("id")int id);
}
