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
            width: 535px;
            height: 440px;
            border: 1px solid skyblue;
        }

        .tr2 {
            font-size: 7px;
        }

        .tr3 {
            font-size: 12px;
            font-weight: bold;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <span><img src="../img/aright-top.png"><b>全部留言</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div>
        <table>
            <c:forEach items="${ecomments }" var="ecomment">
                <tr class="tr1">
                    <td colspan="3"><b>${ecomment.content }</b></td>
                </tr>
                <tr class="tr2">
                    <td>网友:</td>
                    <td>${ecomment.nickname }</td>
                    <td>${ecomment.createtime }</td>
                </tr>
                <tr class="tr3">
                    <td>管理员回复:</td>
                    <td colspan="2">${ecomment.reply }</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <hr>
    <div>
        <form action="addcontent.do" method="post">
            <table>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称:</td>
                    <td><input type="text" name="nickname"></td>
                </tr>
                <tr>
                    <td>留言内容:</td>
                    <td><textarea name="content" cols="30" rows="3"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="but1"
                                                                                     value="提交留言"
                                                                                     style="background-color: darkblue"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
