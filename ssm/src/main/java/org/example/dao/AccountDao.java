package org.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 帳戶 Dao 接口
 */
@Repository
public interface AccountDao {

    /**
     * 方法: 查詢所有帳戶
     * @return java.util.List<org.example.domain.Account>
     */
    @Select("SELECT * FROM account")
    List<Account> findAll();

    /**
     * 方法: 保存帳戶訊息
     */
    @Insert("INSERT INTO account (name, money) VALUES (#{name}, #{money})")
    void saveAccount(Account account);

}
