package com.leaf.wxgoods.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/13 1:20 上午
 */
@Data
public class Goods {

    private int id;
    private String name;
    private String imageUrl;

    private List<Images> imagesList;

    public Goods(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
