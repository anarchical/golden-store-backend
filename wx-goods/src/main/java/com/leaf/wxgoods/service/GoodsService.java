package com.leaf.wxgoods.service;

import com.leaf.wxgoods.pojo.Goods;
import com.leaf.wxgoods.pojo.Images;
import com.leaf.wxgoods.repository.GoodsRepository;
import com.leaf.wxgoods.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/13 1:35 上午
 */
@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    ImagesRepository imagesRepository;

    public Page<Goods> getAllGoods(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Goods> goodsList = goodsRepository.findAllGoods(pageRequest);
        return setImagesForGoods(goodsList);
    }

    public Page<Goods> getAllGoods(Integer page, Integer size, int subTypeId) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Goods> goodsList = goodsRepository.findAllGoodsBySubTypeId(pageRequest, subTypeId);
        return setImagesForGoods(goodsList);
    }

    public Page<Goods> getAllGoods(Integer page, Integer size, String query) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Goods> goodsList = goodsRepository.findAllGoodsByQuery(pageRequest, "%" + query + "%");
        return setImagesForGoods(goodsList);
    }

    public Goods getGoodsById(int id) {
        Goods goods = goodsRepository.findGoodsById(id);
        List<Images> imagesList = imagesRepository.findImageListByGoodsId(id);
        goods.setImagesList(imagesList);
        goods.setImageUrl(imagesList.get(0).getUrl());
        return goods;
    }

    /**
     * 为商品添加图片信息
     * @param goodsList 传入商品数组
     * @return 添加好图片信息的商品数组
     */
    private Page<Goods> setImagesForGoods(Page<Goods> goodsList) {
        for (Goods goods : goodsList) {
            List<Images> imagesList = imagesRepository.findImageListByGoodsId(goods.getId());
            goods.setImagesList(imagesList);
            if (!imagesList.isEmpty()) {
                goods.setImageUrl(imagesList.get(0).getUrl());
            } else {
                goods.setImageUrl(null);
            }
        }
        return goodsList;
    }

}
