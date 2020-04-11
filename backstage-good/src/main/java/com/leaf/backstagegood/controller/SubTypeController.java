package com.leaf.backstagegood.controller;

import com.leaf.backstagegood.entity.SubType;
import com.leaf.backstagegood.service.SubTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 10:00 下午
 */
@Slf4j
@RestController
@RequestMapping("/subType")
@Api(value = "商品子类型信息接口")
public class SubTypeController {

    @Autowired
    SubTypeService subTypeService;

    @ApiOperation(value = "获取所有类型信息,分页")
    @GetMapping("/allSubType")
    public Object getAllSubType(@RequestParam(required = false) Integer size,
                                @RequestParam(required = false) Integer page,
                                @RequestParam(required = false) String query) {
        if (page != null && size != null) {
            if (query == null) {
                return subTypeService.getAllSubType(page - 1, size);
            }
            return subTypeService.getAllSubType("%" + query + "%", page - 1, size);
        }
        return subTypeService.getAllSubType();
    }

    @ApiOperation(value = "通过id查询类型信息")
    @GetMapping("/querySubType")
    public SubType getSubTypeById(@RequestParam("id") int id) {
        return subTypeService.getSubTypeById(id);
    }

    @ApiOperation(value = "更新类型信息")
    @PostMapping("/updateSubType")
    public SubType updateSubType(@RequestBody SubType SubType) {
        return subTypeService.addSubType(SubType);
    }

    @ApiOperation(value = "添加子类型信息")
    @PostMapping("/addSubType")
    public SubType addSubType(@RequestBody SubType subType) {
        return subTypeService.addSubType(subType);
    }

    @ApiOperation(value = "删除类型信息")
    @GetMapping("/deleteSubType")
    public boolean deleteSubType(@RequestParam("id") int id) {
        try {
            subTypeService.deleteSubTypeById(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }

    @GetMapping("/getSubTypeByTypeId")
    public List<SubType> getSubTypeByTypeId(@RequestParam("id") int id) {
        return subTypeService.getSubTypeByTypeId(id);
    }

    @GetMapping("/updateImages")
    public int updateImageUrl(@RequestParam("id") int id,
                              @RequestParam("imageUrl") String imageUrl) {
        return subTypeService.updateImageUrl(id, imageUrl);

    }

    @GetMapping("/deleteImage")
    public boolean deleteImageUrl(@RequestParam("id") int id) {
        try {
            subTypeService.deleteImageUrl(id);
            return true;
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return false;
    }


}
