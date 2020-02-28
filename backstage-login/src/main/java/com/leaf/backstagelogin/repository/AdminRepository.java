package com.leaf.backstagelogin.repository;

import com.leaf.backstagelogin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:47
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminByUsername(String username);
}
