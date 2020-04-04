package com.leaf.backstagegood.controller;

import com.leaf.backstagegood.entity.Goods;
import com.leaf.backstagegood.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/22 5:15 下午
 */
@Slf4j
@RestController
@RequestMapping("/goods")
@Api(value = "商品信息接口")
public class GoodsController {
//    @Autowired
//    AliOssUtil aliOssUtil;
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value = "获取所有商品信息")
    @GetMapping("/allGoods")
    public Object getAllGoods(@RequestParam(required = false) Integer size,
                              @RequestParam(required = false) Integer page,
                              @RequestParam(required = false) String query) {
        if (page != null && size != null) {
            if (query == null) {
                return goodsService.getAllGoods(page - 1, size);
            }
            return goodsService.getAllGoods("%" + query + "%", page - 1, size);
        }
        return goodsService.getAllGoods();
    }

    @ApiOperation(value = "通过id查询商品信息")
    @GetMapping("/queryGoods")
    public Goods getGoodsById(@RequestParam("id") int id) {
        return goodsService.getGoodsById(id);
    }

    @ApiOperation(value = "删除商品信息")
    @GetMapping("/deleteGoods")
    public boolean deleteGoods(@RequestParam("id") int id) {
        try {
            goodsService.deleteGoodsById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }

    @ApiOperation(value = "添加商品信息")
    @PostMapping("/addGoods")
    public Goods addGoods(@RequestBody Goods goods) {
        log.info("商品信息：{}", goods);
        return goodsService.addGoods(goods);
    }

    @ApiOperation(value = "更新商品信息")
    @PostMapping("/updateGoods")
    public Goods updateGoods(@RequestBody Goods goods) {
        return goodsService.updateGoods(goods);
    }

    @ApiOperation(value = "通过类型Id查询商品信息")
    @GetMapping("/getGoodsByTypeId")
    public List<Goods> getGoodsByTypeId(@RequestParam("id") int id) {
        return goodsService.getGoodsByTypeId(id);
    }

    @ApiOperation(value = "修改商品上架状态")
    @GetMapping("/updateIsSell")
    public int updateGoodsSell(@RequestParam("id") int id,
                               @RequestParam("isSell") boolean isSell) {
        return goodsService.updateGoodsSell(id, isSell);
    }


}
