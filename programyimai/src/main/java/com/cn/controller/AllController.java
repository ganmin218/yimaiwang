package com.cn.controller;

import com.alibaba.fastjson.JSON;
import com.cn.entity.*;
import com.cn.service.Allservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
            //显示产品
            List<Eproduct> selectproduct = allservice.selectproducts();
            int totalPage = selectproduct.size();
            int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
            int ye = 1;
            List<Eproduct> sproducts = allservice.selectproductsBypage(ye - 0);
            session.setAttribute("sproducts", sproducts);
            session.setAttribute("totalPage", totalPage);
            session.setAttribute("zonye", zonye);
            session.setAttribute("ye", ye);
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
  /*  @RequestMapping("/leibie")
    public void leibie(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Leibie leibie = allservice.selectLeibieByName(name);
        List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
        Object json = JSON.toJSON(epcategories);
        System.out.println(json);
        response.getWriter().print(json);
    }*/

    //显示enewsshow单条详细信息
    @RequestMapping("/enewsshow")
    public String enewsshow(HttpSession session, HttpServletRequest request, Integer id) {
        Enews enewsshow = allservice.selectEnewsByPrimaryKey(id);
        request.setAttribute("enewsshow", enewsshow);
        return "enewsshow";
    }

    //显示showproduct根据二级目录
    @RequestMapping("/showproduct")
    public String showproduct(HttpSession session, HttpServletRequest request, Integer id, Integer ye) {
        List<Eproduct> eproduct = allservice.selectproductsByEpcategoryId(id);
        int totalPage = eproduct.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        ye = 1;
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 0));
        System.out.println(eproducts);
        request.setAttribute("eproducts", eproducts);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        session.setAttribute("epcategoryId", id);
        return "showproduct";
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

    //用户管理
    //showuser用户管理显示
    @RequestMapping("/showuser")
    public String showuser(HttpSession session, HttpServletRequest request) {
        List<Euser> eusers = allservice.selectAlluser();
        request.setAttribute("eusers", eusers);
        return "HCmanager/showuser";
    }

    //showuser用户修改
    @RequestMapping("/updateuser")
    public String updateuser(HttpSession session, HttpServletRequest request, Integer id) {
        Euser euser = allservice.selectuserByPrimaryKey(id);
        request.setAttribute("euser", euser);
        return "HCmanager/updateuser";
    }

    //updateuserfinally用户修改完成
    @RequestMapping("/updateuserfinally")
    public String updateuserfinally(HttpSession session, HttpServletRequest request, Euser euser) {
        allservice.updateUserByPrimaryKeySelective(euser);
        return showuser(session, request);
    }

    //adminadduser管理员添加用户
    @RequestMapping("/adminadduser")
    public String adminadduser(HttpSession session, HttpServletRequest request, Euser user) {
        allservice.insertUser(user);
        return showuser(session, request);
    }

    //deleteuser删除用户
    @RequestMapping("/deleteuser")
    public String adminadduser(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteUserByPrimaryKey(id);
        return showuser(session, request);
    }

    //新闻管理
    //selectnews查看新闻
    @RequestMapping("/selectnews")
    public String selectnews(HttpSession session, HttpServletRequest request) {
        List<Enews> enew = allservice.selectEnews();
        request.setAttribute("enew", enew);
        return "HCmanager/shownews";
    }

    //updatenews修改新闻(查看单条新闻)
    @RequestMapping("/updatenews")
    public String updatenews(HttpSession session, HttpServletRequest request, Integer id) {
        Enews adminenews = allservice.selectEnewsByPrimaryKey(id);
        request.setAttribute("adminenews", adminenews);
        return "HCmanager/updatenews";
    }

    //updatenewsfinally管理员修改新闻
    @RequestMapping("/updatenewsfinally")
    public String updatenewsfinally(HttpSession session, HttpServletRequest request, Enews enews) {
        allservice.updatenewsByPrimaryKeySelective(enews);
        return selectnews(session, request);
    }

    //addnews管理员添加新闻
    @RequestMapping("/addnews")
    public String addnews(HttpSession session, HttpServletRequest request, Enews enews) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String now = df.format(d);
        Enews enew = new Enews(enews.getTitle(), enews.getContent(), now);
        allservice.insertnewsSelective(enew);
        return selectnews(session, request);
    }

    //updatenewsfinally管理员删除新闻
    @RequestMapping("/deletenews")
    public String deletenews(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deletenewsByPrimaryKey(id);
        return selectnews(session, request);
    }

    //商品管理
    //显示商品showgoods
    @RequestMapping("/showgoods")
    public String showgoods(HttpSession session, HttpServletRequest request) {
        List<Eproduct> selectproduct = allservice.selectproducts();
        int totalPage = selectproduct.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eproduct> products = allservice.selectproductsBypage(ye - 0);
        request.setAttribute("products", products);
        return "HCmanager/showgoods";
    }

    //addgoods管理员新增商品
    @RequestMapping("/addgoods")
    public String addgoods(HttpServletRequest request, @RequestParam MultipartFile filename, HttpSession session) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int categorylevel1id = Integer.parseInt(request.getParameter("categorylevel1id"));
        Float price = Float.parseFloat(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        //MultipartFile处理上传文件的对象
        System.out.println("执行上传文件操作!");
        //获取文件上传的位置
        //String basePath = session.getServletContext().getRealPath("upload");
        String basePath = "I:\\IDEAprogrammerTest\\Yimainet\\yimai-common\\programyimai\\src\\main\\webapp\\upload";
        //以日期创建二级文件目录
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //判断此文件是否存在,不存在就重新创建
        File file = new File(basePath, datePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件名,并且拼接文件名
        String fname = filename.getOriginalFilename();
        //获取一个随机序列,防止不同用户文件名一样(文件名字一样的话会被新的覆盖),UUID.randomUUID()是获取随机序列的方法;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fname = uuid + "-" + fname;
        //对文件进行保存
        try {
            filename.transferTo(new File(file, fname));
            Eproduct product =
                    new Eproduct(name, description, price, stock, categorylevel1id, datePath + "/" + fname);
            allservice.insertproductSelective(product);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //return showgoods(session,request);
        return "central";
    }


    //管理员商品分类管理
    //查看分类showleibie
    @RequestMapping("/showleibie")
    public String showleibie(HttpSession session, HttpServletRequest request) {
        List<Leibie> leibies = allservice.selectLeibie();
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCmanager/showleibie";
    }

    //修改一级分类
    @RequestMapping("/updateleibie")
    public String updateleibie(HttpSession session, HttpServletRequest request, Integer id) {
        Leibie leibie = allservice.selectleibieByPrimaryKey(id);
        request.setAttribute("leibie", leibie);
        return "HCmanager/updateleibie";
    }

    //updateleibiefinally修改一级分类
    @RequestMapping("/updateleibiefinally")
    public String updateleibiefinally(HttpSession session, HttpServletRequest request, Leibie leibie) {
        allservice.updateleibieByPrimaryKeySelective(leibie);
        return showleibie(session, request);
    }

    //删除一级分类
    @RequestMapping("/deleteleibie")
    public String deleteleibie(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteleibieByPrimaryKey(id);
        return showleibie(session, request);
    }

    //修改二级级分类
    @RequestMapping("/updatemulu")
    public String updatemulu(HttpSession session, HttpServletRequest request, Integer id) {
        Epcategory epcategory = allservice.selectEpcategoryByPrimaryKey(id);
        request.setAttribute("epcategory", epcategory);
        return "HCmanager/updatemulu";
    }

    //updatemulufinally修改二级分类
    @RequestMapping("/updatemulufinally")
    public String updatemulufinally(HttpSession session, HttpServletRequest request, Epcategory epcategory) {
        allservice.updateEpcategoryByPrimaryKeySelective(epcategory);
        return showleibie(session, request);
    }

    //删除二级级分类
    @RequestMapping("/deletemulu")
    public String deletemulu(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteEpcategoryByPrimaryKey(id);
        return showleibie(session, request);
    }

    //添加分类栏目
    @RequestMapping("/addleibie")
    public String addleibie(HttpSession session, HttpServletRequest request, String fumulu, String name) {
        int id = Integer.parseInt(fumulu);
        if (id == 0) {
            Leibie leibie = new Leibie(name);
            allservice.insertleibieSelective(leibie);
        } else {
            Epcategory epcategory = new Epcategory(name, id);
            allservice.insertEpcategorySelective(epcategory);
        }
        return showleibie(session, request);
    }


    //left点击商品分页--------------------------------------------------------
    @RequestMapping("/nextye")
    public String nextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("aaaaaa");
        int id = (Integer) session.getAttribute("epcategoryId");
        System.out.println(id);
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 1) * 8);
        request.setAttribute("eproducts", eproducts);
        return "showproduct";
    }

    @RequestMapping("/lastye")
    public String lastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int id = (Integer) session.getAttribute("epcategoryId");
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 1) * 8);
        request.setAttribute("eproducts", eproducts);
        return "showproduct";
    }

    @RequestMapping("/gofinal")
    public String gofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int id = (Integer) session.getAttribute("epcategoryId");
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 1) * 8);
        request.setAttribute("eproducts", eproducts);
        return "showproduct";
    }

    //跳转到相应页面
    @RequestMapping("/tiaoye")
    public String tiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int id = (Integer) session.getAttribute("epcategoryId");
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 1) * 8);
        request.setAttribute("eproducts", eproducts);
        return "showproduct";
    }

    //首页start商品分页--------------------------------------------------------
    @RequestMapping("/snextye")
    public String snextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "products";
    }

    @RequestMapping("/slastye")
    public String slastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "products";
    }

    @RequestMapping("/sgofinal")
    public String sgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "products";
    }

    //跳转到相应页面
    @RequestMapping("/stiaoye")
    public String stiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "products";
    }


}
