package com.leaf.backstagelogin.service;

import com.leaf.backstagelogin.entity.Admin;
import com.leaf.backstagelogin.repository.AdminRepository;
import com.leaf.backstagelogin.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:48
 */
@Transactional
@Service
@Slf4j
public class AdminService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AdminRepository adminRepository;

    public Object getAllAdmin(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return adminRepository.findAdminByQuery("%" + query + "%", pageRequest);
    }

    public Object getAllAdmin(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return adminRepository.findAllAdmin(pageRequest);
    }

    public Object getAllAdmin() {
        return adminRepository.findAll();
    }

    public void deleteAdminById(int id) {
        adminRepository.deleteById(id);
    }

    public Admin getAdminById(int id) {
        return adminRepository.findById(id);
    }


    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Map<Object, Object> loginAdmin(String username, String password) {

        Admin admin = adminRepository.findAdminByUsername(username);
        if (admin == null || !admin.getPassword().equals(password)) {
            Map<Object, Object> map = new HashMap<>();
            map.put("token", null);
            map.put("success", false);
            return map;
        }
        log.info(admin.toString());
        Map<Object, Object> map = new HashMap<>();
        map.put("token", jwtUtil.createJwt(username, password));
        map.put("success", true);
        return map;
    }
}
