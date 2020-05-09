package com.leaf.backstageorder.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/9 2:40 下午
 */
@Getter
@AllArgsConstructor
public enum OrdersEnum {

    UNDO("未处理"),
    DOING("备货中"),
    TRANSIT("配送中"),
    DONE("已完成");

    private final String status;
}
