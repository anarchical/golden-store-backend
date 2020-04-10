package com.leaf.backstagegood.service;

import com.alibaba.fastjson.JSONObject;
import com.leaf.backstagegood.entity.SubType;
import com.leaf.backstagegood.repository.SubTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 9:59 下午
 */
@Service
@Transactional
public class SubTypeService {

    @Autowired
    SubTypeRepository subTypeRepository;

    public Object getAllSubType(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return subTypeRepository.findSubTypeByQuery("%" + query + "%", pageRequest);
    }

    public Object getAllSubType(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return subTypeRepository.findAllSubType(pageRequest);
    }

    public Object getAllSubType() {
        return subTypeRepository.findAll();
    }

    public List<SubType> getSubTypeByTypeId(int id) {
        return subTypeRepository.findSubTypeByTypeId(id);
    }

    public SubType addSubType(SubType subType) {
        return subTypeRepository.save(subType);
    }


    public void deleteSubTypeById(int id) {
        subTypeRepository.deleteById(id);
    }


    public SubType getSubTypeById(int id) {
        return subTypeRepository.findById(id);
    }

    public int updateImageUrl(int id, String imageUrl) {
        return subTypeRepository.updateImageUrl(id, imageUrl);
    }


}
