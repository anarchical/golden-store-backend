package com.leaf.backstageorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.leaf.backstagegood.entity",
        "com.leaf.backstageorder.entity",
        "com.leaf.backstageuser.entity"})
public class BackstageOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackstageOrderApplication.class, args);
    }

}
