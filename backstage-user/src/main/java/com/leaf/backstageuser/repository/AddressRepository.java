package com.leaf.backstageuser.repository;

import com.leaf.backstageuser.entity.Address;
import com.leaf.backstageuser.vo.AddressVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/5 8:35 下午
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select new com.leaf.backstageuser.vo.AddressVO(address.id,address.cityName,address.countyName,address.detailInfo,address.nationalCode,address.postalCode,address.provinceName,address.telNumber,address.userName) from Address address where address.user.id=:id")
    List<AddressVO> findAddressByUserId(@Param("id") int id);
}
