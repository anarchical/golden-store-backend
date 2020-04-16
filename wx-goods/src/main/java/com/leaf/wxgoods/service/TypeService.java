package com.leaf.wxgoods.service;

import com.leaf.wxgoods.pojo.Type;
import com.leaf.wxgoods.repository.SubTypeRepository;
import com.leaf.wxgoods.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/15 9:08 下午
 */
@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    SubTypeRepository subTypeRepository;

    public List<Type> getAllType() {
        List<Type> typeList = typeRepository.findAllType();
        for (Type type : typeList) {
            type.setSubType(subTypeRepository.findSubTypeByTypeId(type.getId()));
        }
        return typeList;
    }
}
