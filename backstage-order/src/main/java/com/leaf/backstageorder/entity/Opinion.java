package com.leaf.backstageorder.entity;

import com.leaf.backstageuser.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/5/11 10:49 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @ManyToOne
    private User user;
}
