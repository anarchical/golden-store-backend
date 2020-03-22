package com.leaf.backstagegood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/22 4:49 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //    库存数量
    private int stock;

    //    成本价
    private float costPrice;
    //    批发价
    private float tradePrice;
    //    建议零售价
    private float price;
    //    平台利润
    private float myReturn = tradePrice - costPrice;
    //    每个批发单位数量
    private int numSpec;
    //    客户利润
    private float profit = numSpec * price - tradePrice;
    //    规格
    private String specification;

    //    详细信息
    private String detail;

    private String[] imageUrls;

}
