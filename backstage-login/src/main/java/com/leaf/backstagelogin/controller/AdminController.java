package com.leaf.backstagelogin.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstagelogin.entity.Admin;
import com.leaf.backstagelogin.service.AdminService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @ApiOperation(value = "获取所有管理员信息")
    @GetMapping("/allAdmin")
    public Object getAllAdmin(@RequestParam(required = false) Integer size,
                              @RequestParam(required = false) Integer page,
                              @RequestParam(required = false) String query) {
        if (page != null && size != null) {
            if (query == null) {
                return adminService.getAllAdmin(page - 1, size);
            }
            return adminService.getAllAdmin("%" + query + "%", page - 1, size);
        }
        return adminService.getAllAdmin();
    }

    @ApiOperation(value = "通过id查询管理员信息")
    @GetMapping("/queryAdmin")
    public Admin getAdminById(@RequestParam("id") int id) {
        return adminService.getAdminById(id);
    }

    @ApiOperation(value = "删除管理员信息")
    @GetMapping("/deleteAdmin")
    public boolean deleteAdmin(@RequestParam("id") int id) {
        try {
            adminService.deleteAdminById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }

    @ApiOperation(value = "添加管理员信息")
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        log.info("管理员信息：{}", admin);
        return adminService.addAdmin(admin);
    }

    @ApiOperation(value = "更新管理员信息")
    @PostMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        log.info("管理员信息：{}", admin);
        return adminService.addAdmin(admin);
    }


    @PostMapping("/login")
    public Map<Object, Object> loginAdmin(@RequestBody JSONObject loginInfo) {
        String username = loginInfo.getString("username");
        String password = loginInfo.getString("password");
        log.info("用户名：{} \n 密码：{}", loginInfo.getString("username"),
                loginInfo.getString("password"));

        return adminService.loginAdmin(username, password);
    }


}
