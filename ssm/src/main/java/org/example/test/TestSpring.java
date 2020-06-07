package org.example.test;

import org.example.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        // 載入配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 取得物件
        AccountService as = ac.getBean("accountService", AccountService.class);
        // 調用方法
        as.findAll();
    }

}
