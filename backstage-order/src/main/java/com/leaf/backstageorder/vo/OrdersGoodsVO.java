package com.leaf.backstageorder.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/8 7:40 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersGoodsVO {

    private int id;
    private int goodsId;
    private int quantity;
    private String goodsName;
    private float price;

}
