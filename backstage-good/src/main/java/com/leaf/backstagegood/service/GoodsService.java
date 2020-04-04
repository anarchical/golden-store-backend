package com.leaf.backstagegood.service;

import com.leaf.backstagegood.entity.Goods;
import com.leaf.backstagegood.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/22 5:40 下午
 */
@Service
@Transactional
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    public Object getAllGoods(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return goodsRepository.findGoodsByQuery("%" + query + "%", pageRequest);
    }

    public Object getAllGoods(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return goodsRepository.findAllGoods(pageRequest);
    }

    public Object getAllGoods() {
        return goodsRepository.findAll();
    }

    public void deleteGoodsById(int id) {
        goodsRepository.deleteById(id);
    }

    public Goods addGoods(Goods goods) {
        //计算利润
        goods.setMyReturn(goods.getTradePrice() - goods.getCostPrice());
        goods.setProfit(goods.getPrice() - goods.getTradePrice());
        return goodsRepository.save(goods);
    }

    public Goods updateGoods(Goods goods) {
        //计算利润
        goods.setMyReturn(goods.getTradePrice() - goods.getCostPrice());
        goods.setProfit(goods.getPrice() - goods.getTradePrice());
        return goodsRepository.save(goods);
    }

    public Goods getGoodsById(int id) {
        return goodsRepository.findById(id);
    }

    public List<Goods> getGoodsByTypeId(int id) {
        return goodsRepository.findGoodsBySubTypeId(id);
    }

    public int updateGoodsSell(int id, boolean isSell) {
        return goodsRepository.updateGoodsSell(id, isSell);
    }


}
