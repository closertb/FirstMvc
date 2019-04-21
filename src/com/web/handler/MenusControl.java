package com.web.handler;

import com.web.common.BaseController;
import com.web.model.Menus;
import com.web.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/menu")
public class MenusControl extends BaseController {
    @Autowired
    MenusService menusService;

    @RequestMapping("/getMenus")
    @ResponseBody
    public String getValidMenus() {
        return retContent(200, menusService.getMenus(true));
    }
    @RequestMapping("/getAllMenus")
    @ResponseBody
    public String getAllMenus() {
        return retContent(200, menusService.getMenus(false));
    }
}
