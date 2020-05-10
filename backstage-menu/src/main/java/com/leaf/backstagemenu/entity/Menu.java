package com.leaf.backstagemenu.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String icon;

    @OneToMany(mappedBy = "menu")
    private List<Submenu> submenuList;


}
