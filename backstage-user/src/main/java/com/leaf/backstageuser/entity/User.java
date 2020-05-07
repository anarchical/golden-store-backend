package com.leaf.backstageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:25
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String openId;

    private String nickName;
    //    性别
    private int gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.REMOVE)
    private List<Address> addressList;
}
