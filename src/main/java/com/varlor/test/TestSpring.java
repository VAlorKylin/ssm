package com.varlor.test;

import com.varlor.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(JUnit4.class)
public class TestSpring {

    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext applicatonContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) applicatonContext.getBean("accountService");
        as.findAll();
    }
}
