package org.example.controller;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帳戶 Web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 方法: 查詢
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("findAll")
    public String findAll(Model model) {
        System.out.println("表現層，查詢所有帳戶...");

        // 調用 Service 的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);

        return "list";
    }

    /**
     * 方法: 保存
     * @param account
     * @return java.lang.String
     */
    @RequestMapping("save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
