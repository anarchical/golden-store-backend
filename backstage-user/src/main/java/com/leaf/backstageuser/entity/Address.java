package com.leaf.backstageuser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/22 12:03 上午
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cityName;
    private String countyName;
    private String detailInfo;
    private String nationalCode;
    private String postalCode;
    private String provinceName;
    private String telNumber;
    private String userName;

    @JsonIgnore
    @ManyToOne
    private User user;
}
