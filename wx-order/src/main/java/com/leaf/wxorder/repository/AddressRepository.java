package com.leaf.wxorder.repository;

import com.leaf.backstageuser.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/28 5:31 下午
 */
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("select address from Address address where address.user.id=:userId")
    List<Address> getAddressByUserId(@Param("userId") int userId);
}
