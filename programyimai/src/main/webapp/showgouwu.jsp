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
            width: 535px;
        }

        #a3 {
            width: 535px;
            float: left;
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

        .img {
            width: 80px;
            height: 80px;
        }

        a {
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
        <br>
        <span><img src="../img/aright-top.png"><b>购物车信息</b></span>
    </div>
    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 535px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1" width="250px">商品名称</th>
                <th class="q1">商品价格</th>
                <th class="q1">购买数量</th>
                <th class="q1" width="50px">操作</th>
                <th>是否选择</th>
            </tr>
            <c:forEach items="${eorders }" var="eorder">
                <form action="updateorder.do?id=${eorder.id }" method="post">
                    <tr style="height: 20px;">
                        <td class="q1"><span><img class="img" src="upload/${eorder.productfilname }"/>
                                ${eorder.productname }</span></td>
                        <td class="q1" style="text-align: center">${eorder.cost }</td>
                        <td class="q1" style="text-align: center">
                            <input type="text" style="width: 20px" name="quantity" value="${eorder.quantity }"/>
                            <input type="submit" value="修改"/>&nbsp;&nbsp;
                        </td>
                        <td class="q1" style="text-align: center">
                            <a href="deleteorder.do?id=${eorder.id }" onclick="return confirm('确认删除?')">删除</a>
                        </td>
                        <td class="q2" style="text-align: center">
                            <input type="checkbox" name="xuan" value="${eorder.id }"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
    <div style="float:right ;width:535px;">
        <span style="float:right;">
            <a href="showmybuy.do"><button>查看订单</button></a>
            <input style="background-color: limegreen;font-size: 15px" type="button" value="结算" onclick="jiesuan()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    </div>

    <div style="float:right;font-size: 13px;">
        <p>
            <span style="float: right">共&ensp;${totalPage }&ensp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页
            </span>
            <span style="float: right"><a href="gouwunextye.do">下一页</a>&ensp;&ensp;
                <a href="gouwulastye.do">上一页</a>&ensp;&ensp;<a href="gouwugofinal.do">最后一页</a>
            </span>
        </p>
        <form name="form1" action="gouwutiaoye.do" method="post">
        <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;页&ensp;&ensp;&ensp;&ensp;
        <input type="submit" value="GO"/>
        </span>
        </form>
    </div>
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

<script type="text/javascript">
    function jiesuan() {
        var a = confirm('确认付款将生产订单?');
        if (a == true) {
            var idd = document.getElementsByName("xuan");
            var flag = true;
            var idss = "";
            for (var i = 0; i < idd.length; i++) {
                if (idd[i].checked) {
                    flag = false;
                    idss = idss + idd[i].value + ",";
                }
            }
            if (flag == true) {
                alert("请选择您确定要购买支付的商品!");
            } else {
                location.href = "createEodetail.do?idss=" + idss;
            }
        } else {
            alert("取消成功!");
        }
    }
</script>
</body>
</html>
