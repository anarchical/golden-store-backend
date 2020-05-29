package com.leaf.backstageorder.service;

import com.leaf.backstageorder.entity.OrdersGoods;
import com.leaf.backstageorder.repository.OrdersGoodsRepository;
import com.leaf.backstageorder.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/28 8:27 下午
 */
@Service
@Slf4j
public class DataService {

    @Autowired
    OrdersGoodsRepository ordersGoodsRepository;
    @Autowired
    OrdersRepository ordersRepository;

    public Map<String, Object> getAllOrdersGoods() {


        LocalDateTime yesterday = LocalDateTime.now().plusDays(-1);

//        成交数
        Integer volume = ordersRepository.getAllVolume("已完成");
        Integer volumeToday = ordersRepository.getAllVolumeByTime("已完成", yesterday);

//        交易额
        Float allTrade = ordersRepository.getAllTrade("已完成");
        allTrade=allTrade==null?0:allTrade;
        Float todayTrade = ordersRepository.getAllTradeByTime(yesterday, "已完成");
        todayTrade=todayTrade==null?0:todayTrade;

//        收益
        Float allReturn = ordersGoodsRepository.getAllReturn("已完成");
        allReturn=allReturn==null?0:allReturn;
        Float todayReturn = ordersGoodsRepository.getAllReturnByTime(yesterday, "已完成");
        todayReturn=todayReturn==null?0:todayReturn;

        Map<String, Object> map = new HashMap();
        map.put("volume", volume);
        map.put("volumeToday", volumeToday);
        map.put("allTrade", allTrade);
        map.put("todayTrade", todayTrade);
        map.put("allReturn", allReturn);
        map.put("todayReturn", todayReturn);

        return map;
    }


}
