package com.leaf.backstageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:30
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
