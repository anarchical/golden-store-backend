package com.leaf.wxorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.leaf.backstagegood.entity",
        "com.leaf.backstageorder.entity",
        "com.leaf.backstageuser.entity"})
public class WxOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxOrderApplication.class, args);
    }

}
