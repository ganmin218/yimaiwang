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
        #div1 {
            width: 345px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 200px;
            height: 300px;
            float: right;
            border: 1px solid skyblue;
        }

        dt {
            background-color: gainsboro;
            font-weight: bold;
        }

        dl {
            margin: 5px;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div2">
        <dl>
            <dt>用户管理</dt>
            <dd><a href="showuser.do" target="abodyright"><img src="img/left-dd.png">用户管理</a><span style="float: right">
                <a href="HCmanager/adminadduser.jsp" target="abodyright">新增</a></span></dd>
        </dl>
        <dl>
            <dt>商品信息</dt>
            <dd><a href="showleibie.do" target="abodyright"><img src="img/left-dd.png">分类管理</a><span
                    style="float: right">
                <a href="addleibie.do" target="abodyright">新增</a></span></dd>
            <dd><a href="showgoods.do" target="abodyright"><img src="img/left-dd.png">商品管理</a><span
                    style="float: right">
                <a href="addgoods.do" target="abodyright">新增</a></span></dd>
        </dl>
        <dl>
            <dt>订单管理</dt>
            <dd><img src="img/left-dd.png">订单管理</dd>
        </dl>
        <dl>
            <dt>留言管理</dt>
            <dd><a href="amessage.do" target="abodyright"><img src="img/left-dd.png">留言管理</a></dd>
        </dl>

        <dl>
            <dt>新闻管理</dt>
            <dd><a href="selectnews.do" target="abodyright"><img src="img/left-dd.png">新闻管理</a><span
                    style="float: right">
                <a href="HCmanager/addnews.jsp" target="abodyright">新增</a></span></dd>
        </dl>
    </div>

</div>


<script type="text/javascript">
    $(function () {
        $("dd").hide();
        $("dl dt").click(function () {
            if ($(this).parents("dl").children("dd").is(":hidden")) {
                $(this).parents("dl").children("dd").show();
            } else {
                $(this).parents("dl").children("dd").hide();
            }
        });
    })
</script>
</body>
</html>
