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
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AllController {
    public static int count = 0;
    public static HashMap<String, Eproduct> map = new HashMap<String, Eproduct>();
    @Autowired
    Allservice allservice;

    //登陆验证
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, String loginname, String password, String yanzheng) {
        Euser user = new Euser(loginname, password);
        boolean f = false;
        Euser selectuser = allservice.selectuser(user);
        String rand = (String) session.getAttribute("rand");
        if (rand.equals(yanzheng)) {
            f = true;
        }
        if (selectuser == null || f == false) {
            return "login";
        } else {
            session.setAttribute("user", selectuser);
            session.setAttribute("username", selectuser.getLoginname());
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
            List<Eproduct> sproducts = allservice.selectproductsBypage(ye - 1);
            session.setAttribute("sproducts", sproducts);
            session.setAttribute("totalPage", totalPage);
            session.setAttribute("zonye", zonye);
            session.setAttribute("ye", ye);
            session.setAttribute("leftmessage", "产品展示");
            return "shouye";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(HttpSession session, HttpServletRequest request, Euser user, String yanzheng) {
        boolean f = false;
        String rand = (String) session.getAttribute("rand");
        if (rand.equals(yanzheng)) {
            f = true;
        }
        if (f == false) {
            return "register";
        } else {
            allservice.insertUser(user);
            Euser selectuser = allservice.selectuser(user);
            if (selectuser == null) {
                return "register";
            } else {
                return "login";
            }
        }
    }

    //注销用户
    @RequestMapping("/zhuxiao")
    public String zhuxiao(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        HttpSession session1 = request.getSession();
        return goshouye(session1, request);
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
        return "HCmanager/adminshouye";
    }

    //返回前台
    @RequestMapping("/goshouye")
    public String goshouye(HttpSession session, HttpServletRequest request) {
        String leftmessage = null;
        session.setAttribute("leftmessage", leftmessage);
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
        List<Eproduct> sproducts = allservice.selectproductsBypage(ye - 1);
        session.setAttribute("sproducts", sproducts);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        session.setAttribute("leftmessage", "产品展示");
        return "shouye";
    }

    //添加留言
    @RequestMapping("/addcontent")
    public String addcontent(HttpSession session, HttpServletRequest request, String nickname, String content) {
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String now = df.format(d);
            Ecomment ecomment = new Ecomment(content, now, nickname);
            allservice.insertSelective(ecomment);
            List<Ecomment> ecomments = allservice.selectEcomment();
            request.setAttribute("ecomments", ecomments);
            return "reply";
        }
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
        session.setAttribute("leftmessage", "新闻");
        return "enewsshow";
    }

    //显示showproduct根据二级目录
    @RequestMapping("/showproduct")
    public String showproduct(HttpSession session, HttpServletRequest request, Integer id) {
        List<Eproduct> eproduct = allservice.selectproductsByEpcategoryId(id);
        int totalPage = eproduct.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eproduct> eproducts = allservice.selectproductsByEpcategoryIdpage(id, (ye - 1));
        request.setAttribute("eproducts", eproducts);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        session.setAttribute("epcategoryId", id);
        Epcategory epcategoryaa = allservice.selectEpcategoryByPrimaryKey(id);
        session.setAttribute("leftmessage", epcategoryaa.getName());
        return "showproduct";
    }

    //查看商品详情
    @RequestMapping("/details")
    public String details(HttpSession session, HttpServletRequest request, Integer id) {
        Eproduct eproduct = allservice.selectproductByPrimaryKey(id);
        jilu(session, id);
        request.setAttribute("eproduct", eproduct);
        return "details";
    }

    //加入购物车
    @RequestMapping("/addgouwu")
    public String addgouwu(HttpSession session, HttpServletRequest request, Integer id) {
        //判断用户是否登录
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            Eproduct eproduct = allservice.selectproductByPrimaryKey(id);
            //根据商品id判断购物车是否有此物品
            Eorder eorder1 = allservice.selectByproductid(id, user.getId());
            if (eorder1 == null) {
                //购物车没有就新建
                Eorder eorder = new Eorder(eproduct.getId(), user.getId(), eproduct.getName(), eproduct.getFilename(),
                        1, user.getLoginname(), eproduct.getPrice());
                allservice.insertorderSelective(eorder);
                session.setAttribute("leftmessage", "购物车");
                return showgouwu(session, request);
            } else {
                //购物车有就加一件
                Eorder eorder2 = new Eorder(eorder1.getId(), eorder1.getQuantity() + 1, eorder1.getCost() + eproduct.getPrice());
                allservice.updateorderByPrimaryKeySelective(eorder2);
                session.setAttribute("leftmessage", "购物车");
                return showgouwu(session, request);
            }
        }
    }

    //查看购物车showgouwu
    @RequestMapping("/showgouwu")
    public String showgouwu(HttpSession session, HttpServletRequest request) {
        //判断用户是否登录
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            List<Eorder> eorder = allservice.selectallorderByuserid(user.getId());
            int totalPage = eorder.size();
            int zonye = totalPage % 3 == 0 ? (totalPage / 3) : (totalPage / 3 + 1);
            int ye = 1;
            List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1));
            session.setAttribute("totalPage", totalPage);
            session.setAttribute("zonye", zonye);
            session.setAttribute("ye", ye);
            request.setAttribute("eorders", eorders);
            session.setAttribute("leftmessage", "购物车");
            return "showgouwu";
        }
    }

    //删除购物车的东西deleteorder
    @RequestMapping("/deleteorder")
    public String deleteorder(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteorderByPrimaryKey(id);
        return showgouwu(session, request);
    }

    //updateorder修改购物车的内容
    @RequestMapping("/updateorder")
    public String updateorder(HttpSession session, HttpServletRequest request, Integer id) {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //找到订单
        Eorder eorder = allservice.selectorderByPrimaryKey(id);
        //找到商品单价
        Eproduct eproduct = allservice.selectproductByPrimaryKey(eorder.getProductid());
        Float cost = eproduct.getPrice() * quantity;
        //修改购物车信息
        Eorder eorder11 = new Eorder(id, quantity, cost);
        allservice.updateorderByPrimaryKeySelective(eorder11);
        return showgouwu(session, request);
    }

    //生成订单createEodetail
    @RequestMapping("/createEodetail")
    public String createEodetail(HttpSession session, HttpServletRequest request, String idss) {
        String[] id = idss.split(",");
        float cost = 0;
        String details = "";
        for (String s : id) {
            //找到购物车中购买物品的对应order的id录入详情
            int id1 = Integer.parseInt(s);
            Eorder eorderbuy = allservice.selectorderByPrimaryKey(id1);
            cost = cost + eorderbuy.getCost();
            details = details + "编号:" + eorderbuy.getId() + "  产品名称:" + eorderbuy.getProductname() + "  产品数量:" + eorderbuy.getQuantity() + "  产品小计:" + eorderbuy.getCost() + ";";
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Euser user = (Euser) session.getAttribute("user");
        Eodetail eodetail = new Eodetail(user.getId(), user.getLoginname(), details, user.getAddress(), new Date(), cost, uuid, "下单", "已支付");
        allservice.insertEodetailSelective(eodetail);
        //数据一致性;保证库存减少,购物车订单删除
        for (String s : id) {
            //找到购物车中购买物品的对应order的id录入详情
            int id1 = Integer.parseInt(s);
            Eorder eorderbuy = allservice.selectorderByPrimaryKey(id1);
            //产品表减少库存
            //找到商品
            Eproduct eproduct = allservice.selectproductByPrimaryKey(eorderbuy.getProductid());
            //原有的商品库存eproduct.getStock();减去的数量eorderbuy.getQuantity();
            int stock = eproduct.getStock() - eorderbuy.getQuantity();
            Eproduct eproduct22 = new Eproduct(eproduct.getId(), stock);
            //更新产品库存
            allservice.updateproductByPrimaryKeySelective(eproduct22);
            //从购物车中删除
            allservice.deleteorderByPrimaryKey(id1);
        }
        return showgouwu(session, request);
    }

    //直接购买gomai
    @RequestMapping("/gomai")
    public String gomai(HttpSession session, HttpServletRequest request, Integer id) {
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            String details = "";
            Eproduct eproductbuy = allservice.selectproductByPrimaryKey(id);
            details = details + "编号:" + "直接下单" + "  产品名称:" + eproductbuy.getName() + "  产品数量:" + 1 + "  产品小计:" + eproductbuy.getPrice() + ";";
            String uuid = UUID.randomUUID().toString().replace("-", "");
            Eodetail eodetail = new Eodetail(user.getId(), user.getLoginname(), details, user.getAddress(), new Date(), eproductbuy.getPrice(), uuid, "下单", "已支付");
            allservice.insertEodetailSelective(eodetail);
            //数据一致性;保证库存减少
            //产品表减少库存
            //原有的商品库存eproductbuy.getStock();减去的数量1
            int stock = eproductbuy.getStock() - 1;
            Eproduct eproduct22 = new Eproduct(eproductbuy.getId(), stock);
            //更新产品库存
            allservice.updateproductByPrimaryKeySelective(eproduct22);
            return showgouwu(session, request);
        }
    }

    //查看自己的订单showmybuy
    @RequestMapping("/showmybuy")
    public String showmybuy(HttpSession session, HttpServletRequest request) {
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetail = allservice.selectmyEodetail(user.getId());
        int totalPage = eodetail.size();
        int zonye = totalPage % 4 == 0 ? (totalPage / 4) : (totalPage / 4 + 1);
        int ye = 1;
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1));
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("eodetails", eodetails);
        session.setAttribute("leftmessage", "订单展示");
        return "showmybuy";
    }

    //模糊查询订单
    @RequestMapping("/chaxun")
    public void chaxun(HttpServletRequest request, HttpServletResponse response, Integer id, String loginname) throws Exception {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println(loginname);
        Eodetail eodetail = new Eodetail(id, loginname);
        List<Eodetail> eodetails = allservice.selectEodetailByidname(eodetail);
        Object json = JSON.toJSON(eodetails);
        response.getWriter().print(json);
    }






















    //管理员 处理事情-----------------------------------------------------------------------------------------
    //查看留言页面
    @RequestMapping("/amessage")
    public String amassage(HttpSession session, HttpServletRequest request) {
        List<Ecomment> ecomment = allservice.selectEcomment();
        int totalPage = ecomment.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Ecomment> ecomments = allservice.selectEcommentByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
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
        List<Euser> euser = allservice.selectAlluser();
        int totalPage = euser.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Euser> eusers = allservice.selectuserByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
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
        List<Enews> enewee = allservice.selectEnews();
        int totalPage = enewee.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Enews> enew = allservice.selectEnewsByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
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
        List<Eproduct> products = allservice.selectproductsBypage(ye - 1);
        request.setAttribute("products", products);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        return "HCmanager/showgoods";
    }

    //管理员修改商品updategoods
    @RequestMapping("/updategoods")
    public String updategoods(HttpSession session, HttpServletRequest request, Integer id) {
        Eproduct eproduct = allservice.selectproductByPrimaryKey(id);
        request.setAttribute("eproduct", eproduct);
        List<Epcategory> epcategories = allservice.selectAllEpcategory();
        request.setAttribute("epcategories", epcategories);
        return "HCmanager/updategoods";
    }

    //updategoodsfinally修改商品
    @RequestMapping("/updategoodsfinally")
    public String updategoodsfinally(HttpServletRequest request, @RequestParam MultipartFile filename, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("id"));
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
                    new Eproduct(id, name, description, price, stock, categorylevel1id, datePath + "/" + fname);
            allservice.updateproductByPrimaryKeySelective(product);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return showgoods(session, request);
    }

    //addgoods管理员新增商品
    @RequestMapping("/addgoods")
    public String deletegoods(HttpSession session, HttpServletRequest request) {
        List<Epcategory> epcategories = allservice.selectAllEpcategory();
        request.setAttribute("epcategories", epcategories);
        return "HCmanager/addgoods";
    }

    @RequestMapping("/addgoodsfinally")
    public String addgoodsfinally(HttpServletRequest request, @RequestParam MultipartFile filename, HttpSession session) {
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
        return showgoods(session, request);
    }

    //管理员删除商品deletegoods
    @RequestMapping("/deletegoods")
    public String deletegoods(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteproductByPrimaryKey(id);
        return showgoods(session, request);
    }


    //管理员商品分类管理
    //查看分类showleibie
    @RequestMapping("/showleibie")
    public String showleibie(HttpSession session, HttpServletRequest request) {
        List<Leibie> lei = allservice.selectLeibie();
        int totalPage = lei.size();
        int zonye = totalPage % 2 == 0 ? (totalPage / 2) : (totalPage / 2 + 1);
        int ye = 1;
        List<Leibie> leibies = allservice.selectLeibieByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
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
        List<Leibie> leibies = allservice.selectLeibie();
        request.setAttribute("leibies", leibies);
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

    //添加分类栏目,先找到一级栏目
    @RequestMapping("/addleibie")
    public String addleibie(HttpSession session, HttpServletRequest request) {
        List<Leibie> leibies = allservice.selectLeibie();
        request.setAttribute("leibies", leibies);
        return "HCmanager/addleibie";
    }

    @RequestMapping("/addleibiefinally")
    public String addleibiefinally(HttpSession session, HttpServletRequest request, String fumulu, String name) {
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

    //订单管理先显示showeodetail
    @RequestMapping("/showeodetail")
    public String showeodetail(HttpSession session, HttpServletRequest request) {
        List<Eodetail> eodetail = allservice.selectAllEodetail();
        int totalPage = eodetail.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eodetail> eodetails = allservice.selectEodetailByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("eodetails", eodetails);
        return "HCmanager/showeodetail";
    }

    //管理员删除订单deleteeodetails
    @RequestMapping("/deleteeodetails")
    public String deleteeodetails(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteEodetailByPrimaryKey(id);
        return showeodetail(session, request);
    }

    //updateeodetails管理员修改订单
    @RequestMapping("/updateeodetails")
    public String updateeodetails(HttpSession session, HttpServletRequest request, Integer id) {
        Eodetail eodetail = allservice.selectEodetailByPrimaryKey(id);
        request.setAttribute("eodetail", eodetail);
        return "HCmanager/updateeodetails";
    }

    //updateeodetailsfinally管理员修改订单
    @RequestMapping("/updateeodetailsfinally")
    public String updateeodetailsfinally(HttpSession session, HttpServletRequest request, Eodetail eodetail) {
        allservice.updateEodetailByPrimaryKeySelective(eodetail);
        return showeodetail(session, request);
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


    //管理员管理商品分页--------------------------------------------------------
    @RequestMapping("/adnextye")
    public String adnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCmanager/showgoods";
    }

    @RequestMapping("/adlastye")
    public String adlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCmanager/showgoods";
    }

    @RequestMapping("/adgofinal")
    public String adgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.selectproductsBypage((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCmanager/showgoods";
    }

    //跳转到相应页面
    @RequestMapping("/adtiaoye")
    public String adtiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
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
        return "HCmanager/showgoods";
    }

    //管理员管理留言分页--------------------------------------------------------
    @RequestMapping("/menextye")
    public String menextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Ecomment> ecomments = allservice.selectEcommentByPage((ye - 1) * 8);
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    @RequestMapping("/melastye")
    public String melastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Ecomment> ecomments = allservice.selectEcommentByPage((ye - 1) * 8);
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    @RequestMapping("/megofinal")
    public String megofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Ecomment> ecomments = allservice.selectEcommentByPage((ye - 1) * 8);
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    //跳转到相应页面
    @RequestMapping("/metiaoye")
    public String metiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Ecomment> ecomments = allservice.selectEcommentByPage((ye - 1) * 8);
        request.setAttribute("ecomments", ecomments);
        return "HCmanager/amessage";
    }

    //管理员管理新闻分页--------------------------------------------------------
    @RequestMapping("/enewsnextye")
    public String enewsnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Enews> enew = allservice.selectEnewsByPage((ye - 1) * 8);
        request.setAttribute("enew", enew);
        return "HCmanager/shownews";
    }

    @RequestMapping("/enewslastye")
    public String enewslastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Enews> enew = allservice.selectEnewsByPage((ye - 1) * 8);
        request.setAttribute("enew", enew);
        return "HCmanager/shownews";
    }

    @RequestMapping("/enewsgofinal")
    public String enewsgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Enews> enew = allservice.selectEnewsByPage((ye - 1) * 8);
        request.setAttribute("enew", enew);
        return "HCmanager/shownews";
    }

    //跳转到相应页面
    @RequestMapping("/enewstiaoye")
    public String enewstiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Enews> enew = allservice.selectEnewsByPage((ye - 1) * 8);
        request.setAttribute("enew", enew);
        return "HCmanager/shownews";
    }

    //管理员管理用户分页--------------------------------------------------------
    @RequestMapping("/usernextye")
    public String usernextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Euser> eusers = allservice.selectuserByPage((ye - 1) * 8);
        request.setAttribute("eusers", eusers);
        return "HCmanager/showuser";
    }

    @RequestMapping("/userlastye")
    public String userlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Euser> eusers = allservice.selectuserByPage((ye - 1) * 8);
        request.setAttribute("eusers", eusers);
        return "HCmanager/showuser";
    }

    @RequestMapping("/usergofinal")
    public String usergofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Euser> eusers = allservice.selectuserByPage((ye - 1) * 8);
        request.setAttribute("eusers", eusers);
        return "HCmanager/showuser";
    }

    //跳转到相应页面
    @RequestMapping("/usertiaoye")
    public String usertiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Euser> eusers = allservice.selectuserByPage((ye - 1) * 8);
        request.setAttribute("eusers", eusers);
        return "HCmanager/showuser";
    }

    //管理员管理类别分页--------------------------------------------------------
    @RequestMapping("/leinextye")
    public String leinextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectLeibieByPage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCmanager/showleibie";
    }

    @RequestMapping("/leilastye")
    public String leilastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectLeibieByPage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCmanager/showleibie";
    }

    @RequestMapping("/leigofinal")
    public String leigofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectLeibieByPage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCmanager/showleibie";
    }

    //跳转到相应页面
    @RequestMapping("/leitiaoye")
    public String leitiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectLeibieByPage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCmanager/showleibie";
    }

    //管理员管理订单分页--------------------------------------------------------
    @RequestMapping("/ordernextye")
    public String ordernextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCmanager/showeodetail";
    }

    @RequestMapping("/orderlastye")
    public String orderlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCmanager/showeodetail";
    }

    @RequestMapping("/ordergofinal")
    public String ordergofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCmanager/showeodetail";
    }

    //跳转到相应页面
    @RequestMapping("/ordertiaoye")
    public String ordertiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCmanager/showeodetail";
    }

    //查看自己订单分页--------------------------------------------------------
    @RequestMapping("/myordernextye")
    public String myordernextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1) * 4);
        request.setAttribute("eodetails", eodetails);
        return "showmybuy";
    }

    @RequestMapping("/myorderlastye")
    public String myorderlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1) * 4);
        request.setAttribute("eodetails", eodetails);
        return "showmybuy";
    }

    @RequestMapping("/myordergofinal")
    public String myordergofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1) * 4);
        request.setAttribute("eodetails", eodetails);
        return "showmybuy";
    }

    //跳转到相应页面
    @RequestMapping("/myordertiaoye")
    public String myordertiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1) * 4);
        request.setAttribute("eodetails", eodetails);
        return "showmybuy";
    }

    //查看自己购物车分页--------------------------------------------------------
    @RequestMapping("/gouwunextye")
    public String gouwunextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    @RequestMapping("/gouwulastye")
    public String gouwulastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    @RequestMapping("/gouwugofinal")
    public String gouwugofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    //跳转到相应页面
    @RequestMapping("/gouwutiaoye")
    public String gouwutiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }


    //浏览记录功能
    public void jilu(HttpSession session, Integer id) {
        Eproduct eproductaa = allservice.selectproductByPrimaryKey(id);
        List<Eproduct> listEproducts = new ArrayList<Eproduct>();
        if (count == 0) {
            map.put("1", eproductaa);
            listEproducts.add(map.get("1"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count == 1) {
            map.put("2", eproductaa);
            listEproducts.add(map.get("1"));
            listEproducts.add(map.get("2"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count == 2) {
            map.put("3", eproductaa);
            listEproducts.add(map.get("1"));
            listEproducts.add(map.get("2"));
            listEproducts.add(map.get("3"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count > 2) {
            //查看记录有没有这个商品,去重
            boolean flag = true;
            if (eproductaa.getName().equals(map.get("1").getName())) {
                flag = false;
            }
            if (eproductaa.getName().equals(map.get("2").getName())) {
                flag = false;
            }
            if (eproductaa.getName().equals(map.get("3").getName())) {
                flag = false;
            }
            if (flag == true) {
                map.remove("1");
                Eproduct eproductaa2 = map.get("2");
                Eproduct eproductaa3 = map.get("3");
                map.remove("2");
                map.remove("3");
                map.put("1", eproductaa2);
                map.put("2", eproductaa3);
                map.put("3", eproductaa);
                listEproducts.add(map.get("1"));
                listEproducts.add(map.get("2"));
                listEproducts.add(map.get("3"));
                session.setAttribute("listEproducts", listEproducts);
            }
        }
        count++;
    }




}
