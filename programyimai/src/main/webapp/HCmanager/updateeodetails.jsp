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
            width: 995px;
            height: 440px;
            border: 1px solid skyblue;
        }

        #div3 {
            width: 800px;
        }

        #div2 {
            width: 450px;
            height: 370px;
            margin-top: 15px;
            margin-left: 180px;
            border: 1px solid skyblue;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>修改订单</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div id="div2">
        <center>
            <form action="updateeodetailsfinally.do?" method="post">
                <table width="450px">
                    <tr>
                        <td>订单编号:</td>
                        <td><input type="text" name="id" readonly="readonly" value="${eodetail.id}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>订购人姓名:</td>
                        <td><input type="text" name="loginname" value="${eodetail.loginname}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>订购人地址:</td>
                        <td><input type="text" name="useraddress" value="${eodetail.useraddress}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>总金额:</td>
                        <td><input type="text" name="cost" value="${eodetail.cost}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>下单日期:</td>
                        <td><input type="text" readonly="readonly" name="createtime" value="${eodetail.createtime}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>订单状态:</td>
                        <td>
                            <select name="status">
                                <option value="${eodetail.status}">${eodetail.status}</option>
                                <option value="下单">下单</option>
                                <option value="审核通过">审核通过</option>
                                <option value="配货">配货</option>
                                <option value="送货中">送货中</option>
                                <option value="收获并确认">收获并确认</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center><input type="submit" value="更新" style="background-color: green"
                                           onclick="return confirm('确认修改么?')"/>
                                <input type="button" value="返回" onclick="history.back(-1)"/></center>
                        </td>
                    </tr>

                </table>
            </form>
        </center>
    </div>

</div>

<script type="text/javascript">
</script>
</body>
</html>
