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
        <span><img src="../img/aright-top.png"><b>新闻详情</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div>
        <center><p><b>新闻标题:${enewsshow.title }</b></p></center>
        <div class="tr2">
            内容:
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                ${enewsshow.content }
            </p>
        </div>
        <div class="tr3">
            <span style="float: right">发布时间:${enewsshow.createtime }
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </span>
        </div>
    </div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
