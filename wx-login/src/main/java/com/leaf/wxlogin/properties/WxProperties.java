package com.leaf.wxlogin.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 4:13 下午
 */
@Component
@ConfigurationProperties(prefix = "wx-info")
@Getter
@Setter
public class WxProperties {

    private String appid;
    private String secret;
    private String grant_type;
    private String url;

}
