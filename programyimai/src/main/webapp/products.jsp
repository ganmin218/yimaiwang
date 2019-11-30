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

        #a3 {
            width: 450px;
            padding: 20px;
            float: left;
        }

        .d1 {
            width: 80px;
            float: left;
            overflow: hidden;
            margin-left: 30px;
            margin-top: 15px;
            text-align: center;
            font-size: 15px;
        }

        .img {
            width: 80px;
            height: 80px;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <span><img src="../img/aright-top.png"><b>商品列表</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div>
        <%-- <div>
             <c:forEach items="${sproducts }" var="sproduct">

             </c:forEach>
         </div>--%>
        <div id="a3">
            <c:forEach items="${products }" var="product">
                <div class="d1">
                    <a href="productdetail.do?id=${product.id }"><img src="img/left-dd.png" class="img">
                        第三方萨芬的
                        ￥25.6</a>
                </div>
                <%--<div class="d1">--%>
                <%--<a href=""><img src="upload/${sproduct.filename }" class="img">--%>
                <%--${sproduct.name }--%>
                <%--${sproduct.price }</a>--%>
                <%--</div>--%>

            </c:forEach>
        </div>

        <div style="float:right;font-size: 13px">
            <p>
            <span style="float: right">共&ensp;${totalPage }&ensp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </span>
                <br>
                <span style="float: right"><a href="snextye.do">下一页</a>&ensp;&ensp;
                <a href="slastye.do">上一页</a>&ensp;&ensp;<a href="sgofinal.do">最后一页</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </span>
            </p>
            <form name="form1" action="stiaoye.do" method="post">
        <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;页&ensp;&ensp;&ensp;&ensp;
        <input type="submit" value="GO"/>
        </span>
            </form>
        </div>

    </div>

    <script type="text/javascript">
    </script>
</div>
</body>
</html>
