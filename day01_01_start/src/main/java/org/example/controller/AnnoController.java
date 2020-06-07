package org.example.controller;

import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用的註解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes({"msg"})     // 把 msg=美美 儲存到 Session 域物件中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("執行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 方法: 取得請求體(Request Body)的內容
     * @param body
     * @return java.lang.String
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("執行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * 方法: PathVariable 註解
     * @param id
     * @return java.lang.String
     */
    @RequestMapping(value = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println("執行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 方法: RequestHeader 註解
     * @param header
     * @return java.lang.String
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("執行了...");
        System.out.println(header);
        return "success";
    }

    /**
     * 方法: 取得 Cookie 的值
     * @param cookieValue
     * @return java.lang.String
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue) {
        System.out.println("執行了...");
        System.out.println("CookieValue: " + cookieValue);
        return "success";
    }

    /**
     * 方法: ModelAttribute 註解
     * @return java.lang.String
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute 執行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser 執行了...");
        // 通過用戶查詢資料庫 (模擬)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * 方法: 該方法會先執行
     * @return User

    @ModelAttribute
    public User showUser(String uname) {
        System.out.println("showUser 執行了...");
        // 通過用戶查詢資料庫 (模擬)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/


    /**
     * 方法: SessionAttributes 註解
     * @return java.lang.String
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes 執行了...");
        // 底層會儲存到 request 域物件中
        model.addAttribute("msg", "美美");
        return "success";
    }

    /**
     * 方法: 取值
     * @param model
     * @return java.lang.String
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(Model model) {
        System.out.println("getSessionAttributes 執行了...");
        String msg = (String) model.getAttribute("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 方法: 清除
     * @return java.lang.String
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes 執行了...");
        status.setComplete();
        return "success";
    }


}
