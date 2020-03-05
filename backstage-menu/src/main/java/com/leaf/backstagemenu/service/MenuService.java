package com.leaf.backstagemenu.service;

import com.leaf.backstagemenu.entity.Menu;
import com.leaf.backstagemenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public List<Menu> findAllMenu() {
        return menuRepository.findAll();


    }


}
