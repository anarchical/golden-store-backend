package com.leaf.wxgoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.leaf.backstagegood.entity"})
public class WxGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxGoodsApplication.class, args);
    }

}
