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
            line-height: 30px;
        }

        #div1 {
            width: 460px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 250px;
            height: 440px;
            border: 1px solid skyblue;
        }
    </style>
</head>

<body>
<center>
    <div id="div1">
        <center>
            <div id="div2">
                <table width="250px">
                    <tr style="background-color: gainsboro">
                        <td><b>新闻动态</b></td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                    <tr>
                        <td>新闻动态</td>
                    </tr>
                </table>
            </div>
        </center>
    </div>
</center>


<script type="text/javascript">
</script>
</body>
</html>
