package com.web.handler;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Todo;
import com.web.service.TodoService;
import com.web.service.UserService;
import com.web.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.model.Users;
import com.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class HelloControl extends BaseController{

    @Autowired
    UserService userService;

    @Autowired
    TodoService todoService;

    @RequestMapping(value="/login")
    @ResponseBody
    public String handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        System.out.println("df" + userService);
        List<Users> res = userService.queryAll();

        System.out.println("the http request is:"+request.getMethod());
        System.out.println("request body is"+request.getQueryString());
        return retContent(200, res);
    }

    @RequestMapping(value="/map")
    @ResponseBody
    public String mapSet(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("map", "response");
        //map.put相当于request.setAttribute方法  –
        return retContent(200, map);
    }

    @RequestMapping(value="/getUser")
    @ResponseBody
    public Users getUser(){
        //map.put相当于request.setAttribute方法  –
        return userService.queryUserById(5);
    }

    @RequestMapping(value="/todo")
    @ResponseBody
    public String getTodo(){
        System.out.println("df" + todoService);
        Todo todo = todoService.getTodoList();
        //map.put相当于request.setAttribute方法  –
        return retContent(200, todo);
    }
}