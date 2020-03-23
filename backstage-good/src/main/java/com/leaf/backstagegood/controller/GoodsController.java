package com.leaf.backstagegood.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstagegood.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/22 5:15 下午
 */
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    AliOssUtil aliOssUtil;

    @PostMapping("/addGoods")
    public JSONObject addGoods(@RequestParam("file") MultipartFile[] file) {

        for (MultipartFile multipartFile : file) {
            log.info(aliOssUtil.getImageUrl(multipartFile));
        }

        return null;
    }

    @PostMapping("/upload")
    public void upload(MultipartFile file) {
        log.info(file.toString());
    }
}
