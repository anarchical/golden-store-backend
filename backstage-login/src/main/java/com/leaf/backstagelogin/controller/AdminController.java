package com.leaf.backstagelogin.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstagelogin.entity.Admin;
import com.leaf.backstagelogin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:49
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/alladmin")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    @PostMapping("/addadmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody JSONObject loginInfo) {
        String username=loginInfo.getString("username");
        String password=loginInfo.getString("password");
        log.info("用户名：{} \n 密码：{}", loginInfo.getString("username"),
                loginInfo.getString("password"));

        return adminService.loginAdmin(username,password);
    }


}
