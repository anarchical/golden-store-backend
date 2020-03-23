package com.leaf.backstagegood.service;

import com.leaf.backstagegood.entity.Type;
import com.leaf.backstagegood.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 22:47
 */
@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public Page<Type> getAllType(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return typeRepository.findAllType(pageRequest);
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

    /**
     * 类型模糊查询 加%
     *
     * @param query 查询内容
     * @return 返回查询结果
     */
    public Page<Type> queryType(String query, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return typeRepository.findTypesByQuery("%" + query + "%", pageRequest);
    }
}
