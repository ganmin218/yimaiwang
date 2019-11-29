package com.cn.controller;

import com.alibaba.fastjson.JSON;
import com.cn.entity.*;
import com.cn.service.Allservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class AllController {
    @Autowired
    Allservice allservice;

    //登陆验证
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, String loginname, String password) {
        Euser user = new Euser(loginname, password);
        Euser selectuser = allservice.selectuser(user);
        if (selectuser == null) {
            return "login";
        } else {
            session.setAttribute("user", selectuser);
            //显示左边
            List<Leibie> leibies = allservice.selectLeibie();
            HashMap<List<Epcategory>, String> map = new HashMap<List<Epcategory>, String>();
            //request存数据取不到
            for (Leibie leibie : leibies) {
                List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
                String name = leibie.getName();
                map.put(epcategories, name);
            }
            session.setAttribute("map", map);
            //显示右边
            List<Enews> enews = allservice.selectEnews();
            session.setAttribute("enews", enews);
            System.out.println(enews);
            //显示产品
            List<Eproduct> selectproducts = allservice.selectproducts();
            request.setAttribute("selectproducts", selectproducts);
            return "shouye";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(HttpSession session, HttpServletRequest request, Euser user) {
        System.out.println(user);
        allservice.insertUser(user);
        return "login";
    }

    //查看留言页面
    @RequestMapping("/message")
    public String message(HttpSession session, HttpServletRequest request) {
        List<Ecomment> ecomments = allservice.selectEcomment();
        String leftmessage = "在线留言";
        session.setAttribute("leftmessage", leftmessage);
        request.setAttribute("ecomments", ecomments);
        System.out.println(ecomments);
        return "reply";
    }

    //管理员首页
    @RequestMapping("/adminshouye")
    public String adminshouye(HttpSession session, HttpServletRequest request, String leftmessage) {
        session.setAttribute("leftmessage", leftmessage);
        System.out.println(leftmessage);
        return "HCmanager/adminshouye";
    }

    //返回前台
    @RequestMapping("/goshouye")
    public String goshouye(HttpSession session, HttpServletRequest request) {
        String leftmessage = null;
        session.setAttribute("leftmessage", leftmessage);
        return "shouye";
    }

    //添加留言
    @RequestMapping("/addcontent")
    public String addcontent(HttpSession session, HttpServletRequest request, String nickname, String content) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String now = df.format(d);
        Ecomment ecomment = new Ecomment(content, now, nickname);
        allservice.insertSelective(ecomment);
        List<Ecomment> ecomments = allservice.selectEcomment();
        request.setAttribute("ecomments", ecomments);
        return "reply";
    }

    //leibie查看二级目录
    @RequestMapping("/leibie")
    public void price(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Leibie leibie = allservice.selectLeibieByName(name);
        List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
        Object json = JSON.toJSON(epcategories);
        System.out.println(json);
        response.getWriter().print(json);
    }


    //管理员 处理事情-----------------------------------------------------------------------------------------
    //查看留言页面
    @RequestMapping("/amessage")
    public String amassage(HttpSession session, HttpServletRequest request) {
        List<Ecomment> ecomments = allservice.selectEcomment();
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    //删除留言
    @RequestMapping("/deletereply")
    public String deletereply(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteByPrimaryKey(id);
        List<Ecomment> ecomments = allservice.selectEcomment();
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    //回复留言
    @RequestMapping("/addreply")
    public String addreply(HttpSession session, HttpServletRequest request, Integer id) {
        Ecomment ecomment = allservice.selectByPrimaryKey(id);
        request.setAttribute("ecomment", ecomment);
        return "HCmanager/addreply";
    }

    //回复留言结束
    @RequestMapping("/updatereply")
    public String updatereply(HttpSession session, HttpServletRequest request, Integer id, String reply) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String now = df.format(d);
        Ecomment ecomment = new Ecomment(id, reply, now);
        allservice.updateByPrimaryKeySelective(ecomment);
        List<Ecomment> ecomments = allservice.selectEcomment();
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

}
