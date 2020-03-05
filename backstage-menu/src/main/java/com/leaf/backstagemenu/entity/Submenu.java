package com.leaf.backstagemenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Submenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String path;

    @ManyToOne
    @JsonIgnore
    private Menu menu;

}
