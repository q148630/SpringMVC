package org.example.service;

import org.example.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 方法: 查詢所有帳戶
     * @return java.util.List<org.example.domain.Account>
     */
    List<Account> findAll();

    /**
     * 方法: 保存帳戶訊息
     */
    void saveAccount(Account account);

}
