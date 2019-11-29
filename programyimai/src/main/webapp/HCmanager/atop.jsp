<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="java.text.SimpleDateFormat" %>
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
        #top {
            width: 1350px;
            height: 120px;
            border: 1px solid skyblue;
        }

        html {
            overflow-x: hidden;
            overflow-y: hidden;
        }

        a {
            text-decoration: none;
        }

        #a3 {
            background-color: orange;
            height: 30px;
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
                    <span id="span1">
                            <a href="goshouye.do" target="_blank">返回前台页面</a>
                    </span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>首页</td>
                <td>用户</td>
                <td>商品</td>
                <td>订单</td>
                <td><a href="amessage.do" target="abodyright">留言</a></td>
                <td>新闻</td>
                <td></td>
                <td></td>
            </tr>
        </table>
        <div id="a3">
            <%
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String now = df.format(d);
            %>
            <span style="float: right">管理员${user.loginname }您好,今天是<%=now %>,欢迎回到管理后台。</span><br><br>
        </div>

    </div>
    <c:choose>
        <c:when test="${!empty leftmessage}">
            <span style="margin-left: 120px">您现在的位置:易买网&nbsp;>&nbsp;${leftmessage }</span>
        </c:when>
    </c:choose>


    <%--
      <center>
      <h3>论文管理系统</h3>
      </center>
      <span style="margin-left: 80px;">欢迎您! &nbsp;
       <c:choose>
          <c:when test="${empty user}">
            <c:redirect ></c:redirect>
          </c:when>
          <c:otherwise>
            ${user.username} <a target="framename" href="zhuxiao.do">注销</a>
          </c:otherwise>
       </c:choose>
      </span>
      --%>

    <script type="text/javascript">
    </script>
</div>
</body>
</html>
