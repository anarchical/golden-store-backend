package com.leaf.backstageorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leaf.backstagegood.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 4:04 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Goods goods;

    private int num;

    @JsonIgnore
    @ManyToOne
    private Orders order;

}
