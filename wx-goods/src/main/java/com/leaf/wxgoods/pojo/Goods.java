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
    //    库存数量
    private int stock;
    //    批发价
    private float tradePrice;
    //    建议零售价
    private float price;
    //    每个批发单位数量
    private int numSpec;
    //    客户利润
    private float profit;
    //    规格
    private String specification;
    //    详细信息
    private String detail;

    private String imageUrl;
    private List<Images> imagesList;

    public Goods(int id, String name, int stock, float tradePrice, float price, int numSpec, float profit, String specification, String detail) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.tradePrice = tradePrice;
        this.price = price;
        this.numSpec = numSpec;
        this.profit = profit;
        this.specification = specification;
        this.detail = detail;
    }
}
