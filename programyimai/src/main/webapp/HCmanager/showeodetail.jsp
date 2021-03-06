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
            width: 975px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div3 {
            width: 800px;
        }

        #a3 {
            width: 800px;
            padding: 20px;
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
        <span><img src="../img/aright-top.png"><b>订单管理</b></span>
        <div id="a3">
            <span style="float: right;">订单号:<input id="id" type="text" name="id"/>
            订货人:<input id="loginname" type="text" name="loginname"/>
            <input id="chaxun" type="button" value="查询" style="background-color: darkblue"/>
            </span>
            <table cellspacing="0" cellpadding="0" style="width: 800px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">姓名</th>
                <th class="q1" width="500px">发货地址</th>
                <th class="q1" width="80px">状态</th>
                <th width="80px">操作</th>
            </tr>
            <c:forEach items="${eodetails }" var="eodetail">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${eodetail.id }</td>
                    <td class="q1" style="text-align: center">${eodetail.loginname }</td>
                    <td class="q1">${eodetail.useraddress }</td>
                    <td class="q1" style="text-align: center">${eodetail.status }</td>
                    <td class="q2" style="text-align: center">
                        <a href="updateeodetails.do?id=${eodetail.id }">修改</a>&nbsp;&nbsp;
                        <a href="deleteeodetails.do?id=${eodetail.id }" onclick="return confirm('确认删除?')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

        <div id="xx" style="float:right;font-size: 13px">
        <p>
            <span style="float: right">共&ensp;${totalPage }&ensp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </span>
            <span style="float: right"><a href="ordernextye.do">下一页</a>&ensp;&ensp;
                <a href="orderlastye.do">上一页</a>&ensp;&ensp;<a href="ordergofinal.do">最后一页</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </span>
        </p>
        <form name="form1" action="ordertiaoye.do" method="post">
        <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;页&ensp;&ensp;&ensp;&ensp;
        <input type="submit" value="GO"/>
        </span>
        </form>
    </div>
</div>

<script type="text/javascript">
    $("#chaxun").click(function () {
        /* $("tr:gt(0)").remove();*/
        $("#xx").hide();
        $("table tr:not(:first)").remove();
        var id = $("#id").val();
        var loginname = $("#loginname").val();
        $.getJSON("chaxun.do", "id=" + id + "&&loginname=" + loginname, collback);

        function collback(data) {
            $(data).each(
                function () {
                    var tr = $("<tr style='height: 20px;'></tr>");
                    var td1 = $("<td class=\"q1\" style=\"text-align: center\">" + this.id + "</td>");
                    var td2 = $("<td class=\"q1\" style=\"text-align: center\">" + this.loginname + "</td>");
                    var td3 = $("<td class=\"q1\">" + this.useraddress + "</td>");
                    var td4 = $("<td class=\"q1\" style=\"text-align: center\">" + this.status + "</td>");
                    var td5 = $("<td class=\"q2\" style=\"text-align: center\">" + "<a href=' updateeodetails.do?id=" + this.id + " '>修改</a>&nbsp;&nbsp;" +
                        "<a href=' deleteeodetails.do?id=" + this.id + " ' onclick='return confirm('确认删除?')'>删除</a>" + "</td>");
                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tr.append(td5);
                    $("table tr:first").after(tr);
                });
        }
    })
</script>
</body>
</html>
