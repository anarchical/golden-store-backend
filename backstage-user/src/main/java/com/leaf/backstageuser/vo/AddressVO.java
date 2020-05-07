package com.leaf.backstageuser.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/7 7:09 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {

    private int id;
    private String cityName;
    private String countyName;
    private String detailInfo;
    private String nationalCode;
    private String postalCode;
    private String provinceName;
    private String telNumber;
    private String userName;
}
