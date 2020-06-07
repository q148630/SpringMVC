package org.example.controller;

import org.example.domain.Account;
import org.example.domain.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**   
 * 請求參數綁定
 */  
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 方法: 請求參數綁定入門
     * @return java.lang.String
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("執行了...");
        System.out.println("用戶名: " + username);
        System.out.println("密碼: " + password);

        return "success";
    }

    /**
     * 方法: 請求參數綁定，把數據封裝到 JavaBean 的類中
     * @return java.lang.String
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("執行了...");
        System.out.println(account);
        return "success";
    }

    /**
     * 方法: 自定義類型轉換器
     * @return java.lang.String
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("執行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 方法: 原生的 API
     * @return java.lang.String
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("執行了...");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }

}
