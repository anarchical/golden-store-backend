package com.leaf.backstageorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstageorder.entity.Opinion;
import com.leaf.backstageorder.service.OpinionService;
import com.leaf.backstageuser.entity.User;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/11 10:57 下午
 */
@Slf4j
@RestController
@RequestMapping("/wx-opinions")
@Api(value = "订单信息接口")
public class OpinionController {

    @Autowired
    OpinionService opinionService;

    @PostMapping("/addOpinion")
    public Opinion addOpinion(@RequestBody JSONObject jsonObject) {
        User user = new User();
        user.setId(jsonObject.getInteger("user_id"));
        Opinion opinion = new Opinion();
        opinion.setText(jsonObject.getString("textValue"));
        opinion.setUser(user);
        return opinionService.addOpinion(opinion);

    }
}
