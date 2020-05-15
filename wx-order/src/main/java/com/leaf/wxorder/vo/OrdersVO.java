package com.leaf.wxorder.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/8 7:40 下午
 */
@Data
@NoArgsConstructor
public class OrdersVO {

    private int id;
    private float price;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String openId;

    private String cityName;
    private String countyName;
    private String detailInfo;
    private String postalCode;
    private String provinceName;
    private String telNumber;
    private String userName;

    private String status;
    private String remarks;

    public OrdersVO(int id, float price, LocalDateTime createTime, String openId, String cityName, String countyName, String detailInfo, String postalCode, String provinceName, String telNumber, String userName, String status,String remarks) {
        this.id = id;
        this.price = price;
        this.createTime = createTime;
        this.openId = openId;
        this.cityName = cityName;
        this.countyName = countyName;
        this.detailInfo = detailInfo;
        this.postalCode = postalCode;
        this.provinceName = provinceName;
        this.telNumber = telNumber;
        this.userName = userName;
        this.status = status;
        this.remarks=remarks;
    }

    private List<OrdersGoodsVO> goodsVOList;
}
