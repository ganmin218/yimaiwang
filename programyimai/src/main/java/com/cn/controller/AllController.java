package com.cn.controller;

import com.cn.entity.Eproduct;
import com.cn.entity.Euser;
import com.cn.service.Allservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AllController {
    @Autowired
    Allservice allservice;

    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, String loginname, String password) {
        Euser user = new Euser(loginname, password);
        Euser selectuser = allservice.selectuser(user);
        if (selectuser == null) {
            return "login";
        } else {
            session.setAttribute("user", selectuser);
            List<Eproduct> selectproducts = allservice.selectproducts();
            request.setAttribute("selectproducts", selectproducts);
            return "shouye";
        }
    }


    @RequestMapping("/register")
    public String register(HttpSession session, HttpServletRequest request, Euser user) {
        System.out.println(user);
        allservice.insertUser(user);
        return "login";
    }

}
