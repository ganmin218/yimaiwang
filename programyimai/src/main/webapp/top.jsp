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
    </style>
</head>

<body>
<div id="top">
    <center>
        <table width="1350px" cellpadding="1" cellspacing="1" border="1px solid red" style="text-align: center">
            <tr>
                <td width="300px" rowspan="2">易买网</td>
                <td width="550px" colspan="6"></td>
                <td width="500px"><span style="float: left;">返回前台页面</span></td>
            </tr>
            <tr>
                <td>首页</td>
                <td>用户</td>
                <td>商品</td>
                <td>订单</td>
                <td>留言</td>
                <td>新闻</td>
                <td></td>
            </tr>
            <tr style="background-color: orange;">
                <td colspan="8"><span style="float: right;">管理员**您好,今天是2019-11-25,欢迎回到管理后台。</span></td>
            </tr>
        </table>
    </center>
    <span style="margin-left: 100px">您所在的位置是:易买网>管理后台</span>


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
