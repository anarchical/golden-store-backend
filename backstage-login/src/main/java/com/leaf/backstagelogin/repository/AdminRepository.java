package com.leaf.backstagelogin.repository;

import com.leaf.backstagelogin.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:47
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findById(int id);

    @Query("select admin from Admin admin")
    Page<Admin> findAllAdmin(Pageable pageable);

    @Query("select admin from Admin admin where admin.name like :query")
    Page<Admin> findAdminByQuery(@Param("query") String query, Pageable pageable);


    Admin findAdminByUsername(String username);
}
