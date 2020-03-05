package com.leaf.backstagemenu.controller;

import com.leaf.backstagemenu.entity.Menu;
import com.leaf.backstagemenu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/addMenu")
    public void addMainMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
    }

    @GetMapping("/allMenu")
    public List<Menu> getAllMainMenu() {
         return menuService.findAllMenu();
    }


}
