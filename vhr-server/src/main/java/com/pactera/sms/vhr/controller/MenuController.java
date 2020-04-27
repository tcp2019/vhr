package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.Menu;
import com.pactera.sms.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MenuController
 * @Description:根据登录角色查询menu信息
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/system/config/menu")
    private List<Menu> getAllMenu() {
        return menuService.getMenuList();
    }
}
