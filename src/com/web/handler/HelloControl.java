package com.web.handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.userService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Users;
import com.web.common.BaseController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/user")
public class HelloControl extends BaseController{

    @RequestMapping(value="/login")
    @ResponseBody
    public String handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从ioc容器中获取dao
        userService dao = (userService) context.getBean("dao");

        List<Users> res = dao.queryAll();

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

}