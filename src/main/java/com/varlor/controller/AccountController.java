package com.varlor.controller;

import com.varlor.domain.Account;
import com.varlor.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//账户web
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/testFindAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有账户信息");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层查询所有账户信息");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/testFindAll");
    }
}
