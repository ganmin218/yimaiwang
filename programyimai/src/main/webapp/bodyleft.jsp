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
            width: 330px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div2 {
            width: 200px;
            height: 300px;
            float: right;
            border: 1px solid skyblue;
        }

        #div3 {
            width: 200px;
            height: 140px;
            float: right;
            border: 1px solid skyblue;
        }

        dt {
            background-color: gainsboro;
            font-weight: bold;
        }

        dl {
            margin: 5px;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div2">
        <p><b>商品分类</b></p>
        <c:forEach items="${map }" var="map">
            <dl>
                <dt>${map.value }</dt>
                <c:forEach items="${map.key }" var="mulu">
                    <dd><img src="img/left-dd.png"><a href="showproduct.do?id=${mulu.id }"
                                                      target="central">${mulu.name }</a></dd>
                </c:forEach>
            </dl>
        </c:forEach>
        </div>

    <div id="div3">
        放浏览记录!
    </div>


</div>


<script type="text/javascript">
    /* $(function(){
         $("dd").hide();

         $("dl dt").click(function(){
             var obj=$(this);
             var a=$(this).text();
             $(this).parents("dl").nextAll("dd").remove();
             $.getJSON("leibie.do","name="+a,collback);
             function collback(data) {
                 $(data).each(function () {
                     var dd=$("<dd><img src='img/left-dd.png'>"+this.name+"</dd>");
                     $(obj).parents("dl").after(dd);
                 });
             }
         });
         $("p b").click(function () {
             $("dl").nextAll("dd").remove();
         });

     })*/
    $(function () {
        $("dd").hide();
        $("dl dt").click(function () {
            if ($(this).parent().find("dd").is(":hidden")) {
                $(this).parent().find("dd").show();
            } else {
                $(this).parent().find("dd").hide();
            }
        });

    })

</script>
</body>
</html>
