package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 控制器類
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 方法: 入門案例
     * @return java.lang.String
     */
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello StringMVC");
        return "success";
    }

    /**
     * 方法: RequestMapping 註解
     * @return java.lang.String
     */
    @RequestMapping(value = "/testRequestMapping", params = {"username=heihei"}, headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("測試 RequestMapping 註解...");
        return "success";
    }
}
