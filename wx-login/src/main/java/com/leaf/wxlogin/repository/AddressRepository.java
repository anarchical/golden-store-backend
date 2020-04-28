package com.leaf.wxlogin.repository;

import com.leaf.backstageuser.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 3:15 下午
 */
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
