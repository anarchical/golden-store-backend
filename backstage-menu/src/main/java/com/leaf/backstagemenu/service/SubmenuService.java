package com.leaf.backstagemenu.service;

import com.leaf.backstagemenu.entity.Submenu;
import com.leaf.backstagemenu.repository.SubmenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmenuService {


    @Autowired
    SubmenuRepository submenuRepository;

    public void addSubmenu(Submenu submenu) {
        submenuRepository.save(submenu);
    }

    public List<Submenu> findAllSubmenu() {
        return submenuRepository.findAll();
    }


}
