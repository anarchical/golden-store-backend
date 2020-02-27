package com.leaf.backstagelogin.controller;

import com.leaf.backstagelogin.entity.Admin;
import com.leaf.backstagelogin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:49
 */
@RestController
@RequestMapping("/login")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/all_admin")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }
}
