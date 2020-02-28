package com.leaf.backstagelogin.service;

import com.leaf.backstagelogin.entity.Admin;
import com.leaf.backstagelogin.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:48
 */
@Service
@Slf4j
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public boolean loginAdmin(String username, String password) {

        Admin admin = adminRepository.findAdminByUsername(username);
        if (admin == null) {
            return false;
        }
        log.info(admin.toString());
        return admin.getPassword().equals(password);
    }
}
