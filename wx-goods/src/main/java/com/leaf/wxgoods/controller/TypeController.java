package com.leaf.wxgoods.controller;

import com.leaf.wxgoods.pojo.Type;
import com.leaf.wxgoods.service.TypeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/15 9:12 下午
 */

@Slf4j
@RestController
@RequestMapping("/wx-type")
@Api(value = "微信类型信息接口")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/allType")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }

}
