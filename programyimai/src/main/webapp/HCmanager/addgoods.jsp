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
        <span><img src="../img/aright-top.png"><b>新增商品</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div id="div2">
        <center>
            <form action="addgoods.do" method="post" enctype="multipart/form-data">
                <table width="450px">
                    <tr>
                        <td>商品名称:</td>
                        <td><input type="text" name="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>描述:</td>
                        <td><input type="text" name="description"/>
                        </td>
                    </tr>
                    <tr>
                        <td>所属分类:</td>
                        <td>
                            <%--  <select name="categorylevel1id">
                                  <c:forEach items="" var="">
                                  <option values=""></option>
                                  </c:forEach>
                              </select>--%>
                            <select name="categorylevel1id">
                                <option value="548">化妆品</option>
                                <option value="628">家用商品</option>
                                <option value="670">电子商品</option>
                                <option value="660">进口食品,生鲜</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>商品价格:</td>
                        <td><input type="text" name="price"/>
                        </td>
                    </tr>
                    <tr>
                        <td>库存:</td>
                        <td><input type="text" name="stock"/>
                        </td>
                    </tr>
                    <tr>
                        <td>商品图片:</td>
                        <td><input id="filename" type="file" name="filename"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <img id="imgupload" width="100px" height="100px">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <center><input type="submit" value="添加" style="background-color: green"
                                           onclick="return confirm('确认新增这个商品么?')"/></center>
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </div>

</div>

<script type="text/javascript">
    $(function () {

        function file_click() {
            new uploadPreview({UpBtn: "filename", ImgShow: "imgupload"});
        }

        window.onload = file_click;

    });
</script>
</body>
</html>
