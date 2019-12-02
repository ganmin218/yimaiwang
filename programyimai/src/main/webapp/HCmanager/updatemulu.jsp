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
            margin-top: 70px;
            margin-left: 180px;
            line-height: 30px;
            border: 1px solid skyblue;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>修改类别</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div id="div2">
        <center>
            <form action="updatemulufinally.do?id=${epcategory.id }" method="post">
                <table width="450px">
                    <tr>
                        <td>父目录:</td>
                        <td>
                            <select name="parentid">
                                <c:forEach items="${leibies }" var="leibie">
                                    <option value="${leibie.id }">${leibie.name }</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>类别名称:</td>
                        <td>
                            <input type="text" name="name" value="${epcategory.name }"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <center><input type="submit" value="更新" style="background-color: green"
                                           onclick="return confirm('确认修改这条信息么?')"/>
                                <input type="button" value="返回" onclick="history.back(-1)"/>
                            </center>
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
