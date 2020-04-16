package com.leaf.wxgoods.controller;

import com.leaf.wxgoods.pojo.Goods;
import com.leaf.wxgoods.service.GoodsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/13 1:40 上午
 */
@Slf4j
@RestController
@RequestMapping("/wx-goods")
@Api(value = "微信商品信息接口")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/allGoods")
    public Page<Goods> getAllGoods(@RequestParam(required = false, value = "subTypeId") Integer subTypeId,
                                   @RequestParam(value = "size") Integer size,
                                   @RequestParam(value = "page") Integer page,
                                   @RequestParam(required = false, value = "query") String query) {
        if (subTypeId == null && query == null) {
            return goodsService.getAllGoods(page - 1, size);
        } else if (subTypeId != null) {
            return goodsService.getAllGoods(page - 1, size, subTypeId);
        }
        return goodsService.getAllGoods(page - 1, size, query);
    }

    @GetMapping("/getGoods")
    public Goods getGoodsById(@RequestParam(value = "id") int id) {
        return goodsService.getGoodsById(id);
    }
}
