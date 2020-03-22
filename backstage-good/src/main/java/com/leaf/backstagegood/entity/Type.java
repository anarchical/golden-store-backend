package com.leaf.backstagegood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/22 4:51 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
