package com.leaf.backstagegood.service;

import com.leaf.backstagegood.entity.Type;
import com.leaf.backstagegood.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:47
 */
@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public Object getAllType(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return typeRepository.findTypesByQuery("%" + query + "%", pageRequest);
    }

    public Object getAllType(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return typeRepository.findAllType(pageRequest);
    }

    public Object getAllType() {
        return typeRepository.findAll();
    }

    public void deleteTypeById(int id) {
        typeRepository.deleteById(id);
    }

    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    public Type updateType(Type type) {
        return typeRepository.save(type);
    }

    public Type getTypeById(int id) {
        return typeRepository.findById(id);
    }


}
