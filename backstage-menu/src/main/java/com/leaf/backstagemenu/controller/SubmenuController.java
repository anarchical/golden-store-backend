package com.leaf.backstagemenu.controller;

import com.leaf.backstagemenu.entity.Submenu;
import com.leaf.backstagemenu.service.SubmenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submenu")
@Api(value = "子菜单信息接口")
public class SubmenuController {

    @Autowired
    SubmenuService submenuService;

    @ApiOperation(value = "添加子菜单信息")
    @PostMapping("/addSubmenu")
    public void addMainMenu(@RequestBody Submenu submenu) {
        submenuService.addSubmenu(submenu);
    }

    @ApiOperation(value = "获取所有子菜单信息")
    @GetMapping("/allSubmenu")
    public List<Submenu> getAllMainMenu() {
        return submenuService.findAllSubmenu();
    }


}
