package com.leaf.wxlogin.pojo;

import com.leaf.backstageuser.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 3:20 下午
 */
@Data
@NoArgsConstructor
public class Address {

    private int id;
    private String cityName;
    private String countyName;
    private String detailInfo;
    private String nationalCode;
    private String postalCode;
    private String provinceName;
    private String telNumber;
    private String userName;


    public Address(int id, String cityName, String countyName, String detailInfo, String nationalCode, String postalCode, String provinceName, String telNumber, String userName) {
        this.id = id;
        this.cityName = cityName;
        this.countyName = countyName;
        this.detailInfo = detailInfo;
        this.nationalCode = nationalCode;
        this.postalCode = postalCode;
        this.provinceName = provinceName;
        this.telNumber = telNumber;
        this.userName = userName;
    }

    private User user;
}
