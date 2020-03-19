package com.leaf.backstageuser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private String nickName;
    private String address;
    private String telephone;
}
