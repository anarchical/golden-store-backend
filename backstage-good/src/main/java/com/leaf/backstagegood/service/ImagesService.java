package com.leaf.backstagegood.service;

import com.leaf.backstagegood.entity.Images;
import com.leaf.backstagegood.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/27 7:14 下午
 */
@Service
public class ImagesService {

    @Autowired
    ImagesRepository imagesRepository;

    public Images addImages(Images images) {
        return imagesRepository.save(images);
    }

    public List<Images> allImages() {
        return imagesRepository.findAll();
    }

    public List<Images> getImagesByGoodsId(int id) {
        return imagesRepository.findByGoodsId(id);
    }
}
