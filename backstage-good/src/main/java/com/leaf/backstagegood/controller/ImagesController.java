package com.leaf.backstagegood.controller;

import com.leaf.backstagegood.entity.Images;
import com.leaf.backstagegood.service.ImagesService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/3/27 7:17 下午
 */
@Slf4j
@RestController
@RequestMapping("/images")
@Api(value = "图片信息接口")
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    @PostMapping("/addImages")
    public Images addImages(@RequestBody Images images) {
        log.info("图片信息{}", images);
        return imagesService.addImages(images);
    }

    @GetMapping("/allImages")
    public List<Images> allImages() {
        return imagesService.allImages();
    }

    @GetMapping("/getImagesByGoodsId")
    public List<Images> getImagesByGoodsId(@RequestParam("id") int id) {
        return imagesService.getImagesByGoodsId(id);
    }

    @GetMapping("/deleteImagesByGoodsId")
    public int deleteImagesByGoodsId(@RequestParam("id") int id) {
        return imagesService.deleteImagesByGoodsId(id);
    }

    @GetMapping("/deleteImageById")
    public boolean deleteImageById(@RequestParam("id") int id) {
        try {
            imagesService.deleteImageById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }
}
