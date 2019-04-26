package com.web.handler;

import com.web.common.BaseController;
import com.web.model.Users;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(@RequestParam(value ="name", required = true) String name,
                           @RequestParam(value ="pwd", required = true) String pwd) {
        Users user = new Users();
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "21");
        user.setName(name);
        user.setPwd(pwd);
        System.out.println(name + pwd);
        Boolean res = userService.saveUser(user);
        return retContent(200, map);
    }
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(Users user) {
//        Users user = new Users();
        Map<String, String> map = new HashMap<String, String>();
//        user.setId(id);
//        user.setName(name);
//        user.setPwd(pwd);
//        System.out.println(name + pwd);
        Boolean res = userService.updateUser(user);
        return retContent(200, map);
    }
}
