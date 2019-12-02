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
        #div2 {
            width: 995px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div3 {
            width: 800px;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>回复留言</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <form action="updatereply.do?id=${ecomment.id}" method="post">
        <table cellspacing="0" cellpadding="0" style="margin-left:150px;text-align: center;line-height: 30px;">
            <tr>
                <td>留言编号:</td>
                <td><input type="text" readonly="readonly" value="${ecomment.id}"/></td>
            </tr>
            <tr>
                <td>留言姓名:</td>
                <td><input type="text" readonly="readonly" value="${ecomment.nickname }"/></td>
            </tr>
            <tr>
                <td>留言内容:</td>
                <td><input type="text" readonly="readonly" value="${ecomment.content }"/></td>
            </tr>
            <tr>
                <td>回复内容:</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="reply" rows="5" cols="30"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="更新" style="background-color: darkblue"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/></td>
            </tr>
        </table>
    </form>
</div>

</div>

<script type="text/javascript">
</script>
</body>
</html>
