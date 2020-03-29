package com.leaf.backstagegood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //    库存数量
    private int stock;

    //    成本价
    private double costPrice;
    //    批发价
    private double tradePrice;
    //    建议零售价
    private double price;
    //    平台利润
    private double myReturn;
    //    每个批发单位数量
    private int numSpec;
    //    客户利润
    private double profit;
    //    规格
    private String specification;

    //    详细信息
    private String detail;

    //    是否上架
    private boolean isSell;
    //    商品类别
    @ManyToOne
    private Type type;

    //    设置级联删除
    @JsonIgnore
    @OneToMany(mappedBy = "goods", cascade = CascadeType.REMOVE)
    private List<Images> imageUrls;

}
