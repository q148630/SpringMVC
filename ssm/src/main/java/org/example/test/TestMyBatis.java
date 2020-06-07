package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.AccountDao;
import org.example.domain.Account;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 方法: 測試查詢
     */
    @Test
    public void run1() throws IOException {
        // 載入配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 建立 SqlSessionFactory 物件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 建立 SqlSession 物件
        SqlSession session = factory.openSession();
        // 取得代理物件
        AccountDao dao = session.getMapper(AccountDao.class);
        // 查詢所有資料
        List<Account> list = dao.findAll();
        for (Account account: list) {
            System.out.println(account);
        }
        // 關閉資源
        session.close();
        in.close();
    }

    /**
     * 方法: 測試保存
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(1000d);

        // 載入配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 建立 SqlSessionFactory 物件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 建立 SqlSession 物件
        SqlSession session = factory.openSession();
        // 取得代理物件
        AccountDao dao = session.getMapper(AccountDao.class);

        // 保存
        dao.saveAccount(account);

        // 提交事務
        session.commit();

        // 關閉資源
        session.close();
        in.close();
    }

}
