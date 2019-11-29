<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/uploadPreview.js"></script>
    <style type="text/css">
        #buttom {
            width: 1350px;
            height: 45px;
            border: 1px solid skyblue;
        }

        #top {
            width: 1350px;
            height: 120px;
            border: 1px solid skyblue;
        }

        #top1 {
            width: 1350px;
            height: 100px;
            margin-top: 20px;
            border: 1px solid skyblue;
        }

        #div1 {
            height: 460px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 400px;
            height: 200px;
            margin-top: 100px;
            border: 1px solid skyblue;
        }

        .span {
            font-size: 1px;
            color: red;
        }

        #span1 {
            font-size: 15px;
            color: skyblue;
        }

        a {
            text-decoration: none;
        }

        #a2 {
            background-color: orange;
            height: 30px;
            margin-top: -15px;
        }

        ul li {
            list-style: none;
            display: inline;
            padding-left: 10px;
        }

    </style>
</head>
<body>
<div id="top">
        <div id="top1">
            <table width="1350px" cellpadding="0" cellspacing="0" border="1px solid red" style="text-align: center">
                <tr>
                    <td width="300px" rowspan="2"><span style="float: right"><img src="img/easybuy.png"></span></td>
                    <td width="550px" colspan="8"></td>
                    <td width="500px">
                    <span id="span1"><img src="img/gouwu.png">
                        <a href="showgouwu.do">购物车</a>&nbsp;&nbsp;
                        <a href="register.jsp">注册</a>&nbsp;&nbsp;
                        <a href="login.jsp">登陆</a>&nbsp;&nbsp;
                        <a href="message.do">留言</a></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>首页</td>
                    <td>用户</td>
                    <td>商品</td>
                    <td>订单</td>
                    <td>留言</td>
                    <td>新闻</td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <div id="a2">
                <ul style="margin-left: 200px">
                    <li>音乐<span>&nbsp;|</span></li>
                    <li>影视<span>&nbsp;|</span></li>
                    <li>少儿<span>&nbsp;|</span></li>
                    <li>动漫<span>&nbsp;|</span></li>
                    <li>小说<span>&nbsp;|</span></li>
                    <li>外语<span>&nbsp;|</span></li>
                    <li>数码相机&nbsp;<span>|</span></li>
                    <li>笔记本&nbsp;<span>|</span></li>
                    <li>Investor Relations</li>
                </ul>
            </div>
        </div>


    <div id="div1">
        <center>
            <div id="div2">
                <form action="login.do" method="post">
                    <table width="400px" style="line-height: 30px;">
                        <tr style="background-color: gainsboro">
                            <td colspan="3"><h3>欢迎回到易买网</h3></td>
                        </tr>
                        <tr>
                            <td>用户名:</td>
                            <td><input type="text" id="loginname" name="loginname" onblur="checkname()"/></td>
                            <td><span id="d1" class="span"></span></td>
                        </tr>
                        <tr>
                            <td>登录密码:</td>
                            <td><input type="text" id="password" name="password" onblur="checkcode()"/></td>
                            <td><span id="d2" class="span"></span></td>
                        </tr>
                        <tr>
                            <td><input style="background-color: green" type="submit" value="立即登录"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </center>
    </div>


    <div id="buttom" style="background-color: gray">
        <center>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="font_fff">
                <tr>
                    <td align="center">Copyright @ 2017-2023 All Rights Reserved 版权所有：艾码客教育甘敏<br/>
                        地址：长江大学东校区小西门斜对面汉科十巷9号1楼&nbsp;&nbsp;电话：400-027-3552&nbsp;&nbsp;QQ：800101800
                    </td>
                </tr>
            </table>
        </center>
    </div>


    <script type="text/javascript">
        function checkname() {
            $("#d1").text("");
            var a = $("#loginname").val();
            if (a == null || a == "") {
                $("#d1").text("*登陆名字不能为空!");
                return false;
            } else {
                var namereg = /^[a-zA-Z]+$/;
                if (!namereg.test(a)) {
                    $("#d1").text("*登陆名字只允许出现英文!");
                    return false;
                }
            }
            return true;
        }


        function checkcode() {
            $("#d2").text("");
            var a = $("#password").val();
            var codereg = /^[a-zA-Z][0-9a-zA-Z]{5,}$/;
            if (!codereg.test(a)) {
                $("#d2").text("*密码至少是6位且首位是英文字母!");
                return false;
            }
            return true;
        }
    </script>
</div>
</body>
</html>
