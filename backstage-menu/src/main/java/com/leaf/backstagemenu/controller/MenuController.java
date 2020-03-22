package com.leaf.backstagemenu.controller;

import com.leaf.backstagemenu.entity.Menu;
import com.leaf.backstagemenu.service.MenuService;
import com.leaf.backstagemenu.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(value = "主菜单信息接口")
public class MenuController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    MenuService menuService;

    @ApiOperation(value = "增加主菜单信息")
    @PostMapping("/addMenu")
    public void addMainMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
    }

    @ApiOperation(value = "获取所有菜单信息")
    @GetMapping("/allMenu")
    public List<Menu> getAllMainMenu(HttpServletRequest request) {
        String authorization=request.getHeader("Authorization");
        Claims claims=jwtUtil.parseJwt(authorization);
        System.out.println(claims.get("username")+"\n"+claims.get("password"));
        System.out.println(authorization);
         return menuService.findAllMenu();
    }


}
