package org.example.controller;

import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 方法: 返回 String
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString 方法執行了...");
        // 模擬從資料庫中查詢出 User 物件
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        // model 物件
        model.addAttribute("user", user);

        return "success";
    }

    /**
     * 方法: 返回 void
     * 請求轉發一次請求，不用寫專案名稱
     * @return void
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid 方法執行了...");
        // 寫請求轉發的程式
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 設定中文亂碼
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 直接進行響應
        response.getWriter().print("你好");

        return;
    }

    /**
     * 方法: 返回 ModelAndView
     * @return java.lang.String
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 建立 ModelAndView 物件
        ModelAndView mv = new ModelAndView();

        System.out.println("testModelAndView 方法執行了...");
        // 模擬從資料庫中查詢出 User 物件
        User user = new User();
        user.setUsername("小夙");
        user.setPassword("456");
        user.setAge(30);

        // 把 user 物件儲存到 mv 物件中，也會把 user 物件儲存到 request 域中
        mv.addObject("user", user);

        // 跳轉到哪個頁面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 方法: 使用關鍵字的方式進行轉發或重定向
     * @return java.lang.String
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect 方法執行了...");

        // 請求的轉發
//        return "forward:/WEB-INF/pages/success.jsp";
        // 重定向
        return "redirect:/index.jsp";
    }

    /**
     * 方法: 模擬異步請求響應
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax 方法執行了...");
        // 客戶端發送 ajax 請求，傳的是 json 字串，後端把 json 字串封裝到 user 物件中
        System.out.println(user);
        // 模擬查詢資料庫
        user.setUsername("haha");
        user.setAge(20);
        // 做響應
        return user;
    }

}
