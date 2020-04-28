package com.leaf.wxlogin.prover;

import com.alibaba.fastjson.JSONObject;
import com.leaf.wxlogin.properties.WxProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 4:05 下午
 */
@Slf4j
@Component
public class UserProver {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WxProperties wxProperties;

    public JSONObject getOpenId(String code){

        UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(
                wxProperties.getUrl()).
                queryParam("appid",wxProperties.getAppid()).
                queryParam("secret", wxProperties.getSecret()).
                queryParam("js_code", code).
                queryParam("grant_type",wxProperties.getGrant_type());

        URI url=builder.build().encode().toUri();

        String OpenId=restTemplate.getForObject(url,String.class);

        return JSONObject.parseObject(OpenId);
    }
}
