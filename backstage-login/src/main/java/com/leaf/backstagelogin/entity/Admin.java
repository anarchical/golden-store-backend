package com.leaf.backstagelogin.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-02-28 0:27
 */
@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String username;

    private String password;


}
