package com.leaf.wxlogin.pojo;

import com.leaf.backstageuser.entity.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 3:20 下午
 */
@Data
@NoArgsConstructor
public class User {
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

    public User(int id, String openId, String nickName, int gender, String language, String city, String province, String country, String avatarUrl) {
        this.id = id;
        this.openId = openId;
        this.nickName = nickName;
        this.gender = gender;
        this.language = language;
        this.city = city;
        this.province = province;
        this.country = country;
        this.avatarUrl = avatarUrl;
    }

    private List<Address> addressList;
}
