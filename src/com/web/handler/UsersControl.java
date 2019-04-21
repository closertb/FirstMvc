package com.web.handler;

import com.web.common.BaseController;
import com.web.model.Users;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/api/user")
public class UsersControl extends BaseController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/getUser")
    @ResponseBody
    public String getUserInfoById(@RequestParam(value ="id", required = true) int id){
        //map.put相当于request.setAttribute方法  –
        Users user = userService.queryUserById(id);
        System.out.println(user.getName());
        return retContent(200, user);
    }
}
