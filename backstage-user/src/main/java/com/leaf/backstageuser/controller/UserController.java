package com.leaf.backstageuser.controller;

import com.leaf.backstageuser.service.UserService;
import com.leaf.backstageuser.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUser")
    public Page<UserVO> allUser( @RequestParam(value = "size") Integer size,
                                 @RequestParam(value = "page") Integer page,
                                 @RequestParam(required = false) String query){
        //todo query查询
        return userService.getAllUser(page-1,size);
    }

    @GetMapping("/getUser")
    public UserVO getUser(@RequestParam(value = "id") int id){
        return userService.getUserVOById(id);
    }

    @GetMapping("/deleteUser")
    public boolean deleteGoods(@RequestParam("id") int id) {
        try {
            userService.deleteUserById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }


}
