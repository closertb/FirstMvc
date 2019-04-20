package com.web.test;

import com.web.handler.HelloControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext");
        HelloControl helloControl = (HelloControl)applicationContext.getBean("helloControl");
        String res = helloControl.getTodo();
        System.out.println("res:"+res);
    }

}
