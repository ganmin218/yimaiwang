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

        #div3 {
            width: 530px;
            height: 40px;
            margin-top: 10px;
            font-size: 20px;
        }

        #div4 {
            width: 530px;
            height: 280px;
        }

        #div5 {
            width: 530px;
            height: 32px;
        }

        #div6 {
            width: 530px;
            height: 70px;
        }

        .img {
            width: 280px;
            height: 280px;
        }

        a {
            font-size: 14px;
            text-decoration: none;
        }

        .d1 {
            width: 80px;
            height: 120px;
            float: left;
            overflow: hidden;
            margin-left: 30px;
            margin-top: 15px;
            text-align: center;
            font-size: 15px;
        }
    </style>
</head>

<body>
<div id="div2">
    <span style="font-size: 8px;">您现在的位置:易买网&nbsp;>&nbsp;${leftmessage }</span>
    <div id="div3">
        <span><b>${eproduct.name }</b></span>
        <hr style="border: 1px dashed grey">
    </div>
    <div id="div4">
        <div style="float: left"><img src="upload/${eproduct.filename }" class="img"></div>
        <div style="line-height: 30px">
            <span>商城价:${eproduct.price }</span><br>
            <span>库存:${eproduct.stock }</span><br><br>
            <div style="background-color: #FFEB99;">
        <span style="padding-left: 30px;"><a href="gomai.do?id=${eproduct.id }"><img src="img/buyproduct.png"></a>
            <a href="addgouwu.do?id=${eproduct.id }">放入购物车</a></span></div>
        </div>
    </div>
    <div id="div5">
        <span><img src="../img/aright-top.png"><b>商品详情</b></span>
        <span style="float: right"><a onclick="history.back(-1)">返回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div id="div6">
        <span>${eproduct.description }</span>
    </div>

    <script type="text/javascript">
    </script>
    <c:choose>
        <c:when test="${!empty listEproducts }">
            <div style="width: 450px;padding: 20px;float: left;">
                <p>浏览记录:</p>
                <c:forEach items="${listEproducts }" var="listEproduct">
                    <div class="d1">
                        <a href="details.do?id=${listEproduct.id }"><img name="ig"
                                                                         src="upload/${listEproduct.filename }"
                                                                         style="width: 80px;height: 80px;">
                                ${listEproduct.name }
                                ${listEproduct.price }</a>
                    </div>
                </c:forEach>
            </div>
        </c:when>
    </c:choose>
</div>
</body>
</html>
