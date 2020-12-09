package com.varlor.test;

import com.varlor.dao.AccountDao;
import com.varlor.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    @Test
    public void run1() throws IOException {
        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        AccountDao acc = sqlSession.getMapper(AccountDao.class);
        System.out.println(acc.findAll());
        sqlSession.close();
        in.close();
    }

    @Test
    public void run2() throws IOException {
        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        AccountDao acc = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("大大");
        account.setMoney(2000d);
        acc.saveAccount(account);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
