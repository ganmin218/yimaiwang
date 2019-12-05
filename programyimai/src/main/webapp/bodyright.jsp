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
        #div1 {
            width: 460px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 300px;
            height: 440px;
            border: 1px solid skyblue;
        }

        ul li {
            list-style: none;
            line-height: 30px;
        }

        .a1 {
            border: 1px solid gray;
            height: 40px;
            width: 300px;
            background-color: #dedede;
        }

        img {
            width: 15px;
            height: 15px;
        }

        .a2 {
            margin-left: -20px;
            float: left;
            padding: 0;
            overflow: hidden;
            position: relative;
            height: 440px;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
    <div id="div1">
            <div id="div2">
                <div class="a1">
                    <b>新闻动态</b>
                </div>
                <div class="a2">
                    <marquee behavior="scroll" direction="down" height="250px" scrollamount="6" onmouseover=this.stop()
                             onmouseout=this.start()>
                        <ul>
                            <c:forEach items="${enews}" var="enew">
                                <li><img src="img/right.png"><a href="enewsshow.do?id=${enew.id }"
                                                                target="central">${enew.title }</a></li>
                            </c:forEach>
                        </ul>
                    </marquee>
                </div>
            </div>
    </div>


<script type="text/javascript">
    // var time = setInterval(function () {
    //     t();
    // }, 2000)
    //
    // function t() {
    //     var he = $(".a2>ul>li").height();//找到li高
    //     $(".a2>ul>li").eq(0).appendTo($(".a2>ul")); //复制第一个到最后一个
    //     $(".a2>ul").animate({
    //         "marginTop": "-" - he
    //     }, 500, function () {
    //         $(".a2>ul").css({
    //             "marginTop": 0
    //         })
    //     })
    // }
    //
    // $(function () {
    //     $(".a2>ul li:gt(8)").hide();
    // })
</script>
</body>
</html>
