package com.leaf.wxlogin.service;

import com.alibaba.fastjson.JSONObject;
import com.leaf.wxlogin.pojo.User;
import com.leaf.wxlogin.prover.UserProver;
import com.leaf.wxlogin.repository.UserRepository;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/25 3:32 下午
 */
@Slf4j
@Service
@Transactional
public class UserService {

    @Autowired
    UserProver userProver;
    @Autowired
    UserRepository userRepository;

    public JSONObject getOpenId(JSONObject jsonObject) {

        JSONObject openIdInfo = userProver.getOpenId(jsonObject.getString("code"));
        User user = jsonObject.getJSONObject("rawData").toJavaObject(User.class);

        String openId = openIdInfo.getString("openid");

        com.leaf.backstageuser.entity.User userEntity = new com.leaf.backstageuser.entity.User();
        userEntity.setNickName(EmojiParser.parseToAliases(user.getNickName()));
        userEntity.setAvatarUrl(user.getAvatarUrl());
        userEntity.setGender(user.getGender());
        userEntity.setCity(user.getCity());
        userEntity.setProvince(user.getProvince());
        userEntity.setLanguage(user.getLanguage());
        userEntity.setCountry(user.getCountry());
        userEntity.setOpenId(openId);

        if (userRepository.existsByOpenId(openId)) {
            userEntity.setId(userRepository.findByOpenId(openId).getId());
        }

        openIdInfo.put("id",userRepository.save(userEntity).getId());

        return openIdInfo;
    }


}
