package com.leaf.backstageorder.service;

import com.leaf.backstageorder.entity.Opinion;
import com.leaf.backstageorder.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/11 10:55 下午
 */
@Service
public class OpinionService {

    @Autowired
    OpinionRepository opinionRepository;

    public Opinion addOpinion(Opinion opinion){

        return opinionRepository.save(opinion);
    }
}
