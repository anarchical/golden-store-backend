package com.leaf.backstagegood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/24 6:59 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String url;

    @ManyToOne
    Goods goods;
}
