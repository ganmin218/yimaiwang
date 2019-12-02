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
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>全部订单</b></span>
    </div>
    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 535px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">姓名</th>
                <th class="q1">发货地址</th>
                <th class="q1" width="80px">状态</th>
            </tr>
            <c:forEach items="${eodetails }" var="eodetail">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${eodetail.id }</td>
                    <td class="q1">${eodetail.details }</td>
                    <td class="q1">${eodetail.useraddress }</td>
                    <td class="q2" style="text-align: center">${eodetail.status }</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div style="float:right;font-size: 13px">
        <p>
            <span style="float: right">共&ensp;${totalPage }&ensp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页
            </span>
            <span style="float: right"><a href="myordernextye.do">下一页</a>&ensp;&ensp;
                <a href="myorderlastye.do">上一页</a>&ensp;&ensp;<a href="myordergofinal.do">最后一页</a>
            </span>
        </p>
        <form name="form1" action="myordertiaoye.do" method="post">
        <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;页&ensp;&ensp;&ensp;&ensp;
        <input type="submit" value="GO"/>
        </span>
        </form>
    </div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
