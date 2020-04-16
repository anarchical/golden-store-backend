package com.leaf.wxgoods.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/15 8:57 下午
 */
@Data
public class Type {

    private int id;
    private String name;
    private List<SubType> subType;

    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
