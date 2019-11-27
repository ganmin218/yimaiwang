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
        #a1 {
            list-style: none;
            margin-top: 15px;
            margin-left: -30px;
            line-height: 30px;
        }

        #div1 {
            width: 330px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 200px;
            height: 440px;
            border: 1px solid skyblue;
        }
    </style>
</head>

<body>
<div id="div1">
    <center>
        <div id="div2">
            <table>
                <tr>
                    <td colspan="2"><b>用户管理</b></td>
                </tr>
                <tr>
                    <td>用户管理</td>
                    <td>新增</td>
                </tr>
                <tr>
                    <td colspan="2"><b>商品信息</b></td>
                </tr>
                <tr>
                    <td>分类管理</td>
                    <td>新增</td>
                </tr>
                <tr>
                    <td>商品管理</td>
                    <td>新增</td>
                </tr>
                <tr>
                    <td colspan="2"><b>订单管理</b></td>
                </tr>
                <tr>
                    <td>订单管理</td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2"><b>留言管理</b></td>
                </tr>
                <tr>
                    <td>留言管理</td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2"><b>新闻管理</b></td>
                </tr>
                <tr>
                    <td></td>
                    <td>新增</td>
                </tr>

            </table>
        </div>
    </center>
</div>


<script type="text/javascript">
</script>
</body>
</html>
