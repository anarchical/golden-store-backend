package com.leaf.backstageuser.controller;

import com.leaf.backstageuser.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/5 8:36 下午
 */
@Slf4j
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;


}
