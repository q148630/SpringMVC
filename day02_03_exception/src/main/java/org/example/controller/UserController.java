package org.example.controller;

import org.example.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException 執行了...");

        try {
            // 模擬異常
            int a = 10 / 0;
        } catch (Exception e) {
            // 印出異常訊息
            e.printStackTrace();
            // 拋出自定義異常訊息
            throw new SysException("查詢所有用戶出現錯誤了...");
        }

        return "success";
    }

}
