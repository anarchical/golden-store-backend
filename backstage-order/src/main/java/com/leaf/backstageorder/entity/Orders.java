package com.leaf.backstageorder.entity;

import com.leaf.backstageuser.entity.Address;
import com.leaf.backstageuser.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author YeYaqiao
 * @email yyq920201895@163.com
 * @time 2020/4/4 3:57 下午
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float price;

    @ManyToOne
    private User user;

    @ManyToOne
    private Address address;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",
            insertable = false,
            updatable = false)
    private LocalDateTime createTime;

    @OneToMany(mappedBy = "order")
    private List<OrdersGoods> orderGoods;
}
