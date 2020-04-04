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
 * @time 2020/4/4 9:33 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String imageUrl;

    @ManyToOne
    private Type type;

    @JsonIgnore
    @OneToMany(mappedBy = "subType")
    private List<Goods> goods;
}
