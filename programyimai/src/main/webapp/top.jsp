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
                        <c:choose>
                            <c:when test="${empty user }">
                                <a href="register.jsp" target="_blank">注册</a>&nbsp;&nbsp;
                                <a href="login.jsp">登陆</a>&nbsp;&nbsp;
                            </c:when>
                            <c:otherwise>
                                <a href="zhuxiao.do" target="_blank">注销&nbsp;&nbsp;</a>
                            </c:otherwise>
                        </c:choose>
                        <a href="message.do" target="central">留言&nbsp;&nbsp;</a>
                        <c:choose>
                            <c:when test="${user.type==1 }">
                                <a href="adminshouye.do?leftmessage=管理后台" target="_blank">后台管理</a>
                            </c:when>
                        </c:choose>
                    </span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>首页</td>
                <td>图书</td>
                <td>百货</td>
                <td>品牌</td>
                <td>促销</td>
                <td></td>
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
