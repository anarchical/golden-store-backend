package com.leaf.backstagemenu.controller;

import com.leaf.backstagemenu.entity.Submenu;
import com.leaf.backstagemenu.service.SubmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submenu")
public class SubmenuController {

    @Autowired
    SubmenuService submenuService;

    @PostMapping("/addSubmenu")
    public void addMainMenu(@RequestBody Submenu submenu) {
        submenuService.addSubmenu(submenu);
    }

    @GetMapping("/allSubmenu")
    public List<Submenu> getAllMainMenu() {
        return submenuService.findAllSubmenu();
    }


}
