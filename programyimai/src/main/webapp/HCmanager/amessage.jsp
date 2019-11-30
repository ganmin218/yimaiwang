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

        #a3 {
            width: 800px;
            padding: 20px;
            float: left;
            margin-top: 20px;
            text-align: center;
            border-top: 2px solid orange;
            position: relative;
        }

        .q1 {
            border-bottom: 1px solid gold;
            border-right: 1px solid gold;
            height: 30px;
        }

        .q2 {
            border-bottom: 1px solid gold;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>留言管理</b></span><br>
    </div>
    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 800px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">姓名</th>
                <th class="q1">留言内容</th>
                <th class="q1">回复内容</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${ecomments}" var="ecomment">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${ecomment.id }</td>
                    <td class="q1" style="text-align: center">${ecomment.nickname }</td>
                    <td class="q1">${ecomment.content }</td>
                    <td class="q1" style="text-align: center">${ecomment.reply==null?"":"已回复" }</td>
                    <td class="q2" style="text-align: center">
                        <a href="addreply.do?id=${ecomment.id }">回复</a>&nbsp;&nbsp;
                        <a href="deletereply.do?id=${ecomment.id }" onclick="return confirm('确认删除?')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%--<div>
        <table cellspacing="0" cellpadding="0" style="margin-left:30px;text-align: center;">
            <tr style="background-color: ghostwhite">
                <td>编号</td>
                <td>姓名</td>
                <td>留言内容</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${ecomments }" var="ecomment">
                <tr>
                    <td>${ecomment.id }</td>
                    <td>${ecomment.nickname }</td>
                    <td>${ecomment.content }</td>
                    <td>${ecomment.reply==null?"":"已回复" }</td>
                    <td><a href="addreply.do?id=${ecomment.id }">回复</a>&nbsp;&nbsp;
                        <a href="deletereply.do?id=${ecomment.id }">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>--%>

</div>

<script type="text/javascript">
</script>
</body>
</html>
