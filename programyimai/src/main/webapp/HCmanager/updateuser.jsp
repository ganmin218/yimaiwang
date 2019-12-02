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

        .span1 {
            font-size: 1px;
            color: red;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div3">
        <br>
        <span><img src="../img/aright-top.png"><b>修改用户</b></span><br>
        <hr style="border: 1px solid orange">
    </div>
    <div id="div2">
        <center>
            <form action="updateuserfinally.do?id=${euser.id }" method="post">
                <table width="450px">
                    <tr>
                        <td>用户名:</td>
                        <td><input type="text" id="d2" name="loginname" onblur="checkEname()"
                                   value="${euser.loginname}"/>
                            <span id="b2" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>真实姓名:</td>
                        <td>
                            <input type="text" id="d1" name="username" onblur="checkname()" value="${euser.username}"/>
                            <span id="b1" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>登陆密码:</td>
                        <td>
                            <input type="password" name="password" id="d4" onblur="checkcode()"
                                   value="${euser.password}"/>
                            <span id="b4" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码:</td>
                        <td>
                            <input type="password" id="d5" onblur="checkcode1()" value="${euser.password}"/>
                            <span id="b5" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td>
                            男<input type="radio" name="sex" value="1" onclick="checkdire()"/>
                            女<input type="radio" name="sex" value="0" onclick="checkdire()"/>
                            <span id="b15" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期:</td>
                        <td>
                            <input type="text" name="birthday" id="d12" onblur="checkborn()" value="${euser.birthday}"/>
                            <span id="b12" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>身份证:</td>
                        <td>
                            <input type="text" name="identitycode" id="d8" onblur="checkcard()"
                                   value="${euser.identitycode}"/>
                            <span id="b8" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>电子邮件:</td>
                        <td>
                            <input type="text" name="email" id="d6" onblur="checkemai()" value="${euser.email}"/>
                            <span id="b6" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>手机:</td>
                        <td>
                            <input type="text" name="mobile" id="d11" onblur="checkphone()" value="${euser.mobile}"/>
                            <span id="b11" class="span1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>地址:</td>
                        <td>
                            <textarea id="d17" name="address" onblur="checkself()" value="${euser.address}"></textarea>
                            <span id="b17" class="span1"></span>
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
    function checkname() {
        $("#b1").text("");
        var a = $("#d1").val();
        var namereg = /^[\u4e00-\u9fa5]+$/;
        if (!namereg.test(a)) {
            $("#b1").text("*真实名字只允许出现中文!");
            return false;
        }
        $("#b1").text("名字可以使用!");
        return true;
    }

    function checkEname() {
        $("#b2").text("");
        var a = $("#d2").val();
        var Enamereg = /^[a-zA-Z]+$/;
        if (!Enamereg.test(a)) {
            $("#b2").text("*英文名字为英文!");
            return false;
        }
        $("#b2").text("名字正确!");
        return true;
    }


    function checkcode() {
        $("#b4").text("");
        var a = $("#d4").val();
        var codereg = /^[a-zA-Z][0-9a-zA-Z]{5,}$/;
        if (a == "" || a == null) {
            $("#b4").text("密码不能为空!");
            return false;
        }
        if (!codereg.test(a)) {
            $("#b4").text("*密码至少是6位且首位是英文字母!");
            return false;
        }
        $("#b4").text("密码可以使用!");
        return true;
    }

    function checkcode1() {
        $("#b5").text("");
        var a = $("#d4").val();
        var b = $("#d5").val();
        if (b == "" || a == null) {
            $("#b5").text("密码不能为空!");
            return false;
        }
        if (b != a) {
            $("#b5").text("*两次密码不一致!");
            return false;
        }
        $("#b5").text("输入正确!");
        return true;
    }

    function checkemai() {
        $("#b6").text("");
        var a = $("#d6").val();
        var emaireg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!emaireg.test(a)) {
            $("#b6").text("*邮箱格式输入错误!");
            return false;
        }
        $("#b6").text("正确!");
        return true;
    }

    function checkcard() {
        $("#b8").text("");
        var a = $("#d8").val();
        var cardreg = /^\d{15}|\d{18}$/;
        if (!cardreg.test(a)) {
            $("#b8").text("*身份证是15位或者18位!");
            return false;
        }
        $("#b8").text("正确!");
        return true;
    }


    function checkphone() {
        $("#b11").text("");
        var a = $("#d11").val();
        var phonereg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        if (!phonereg.test(a)) {
            $("#b11").text("*手机号不合法!");
            return false;
        }
        $("#b11").text("正确!");
        return true;
    }

    function checkborn() {
        $("#b12").text("");
        var a = $("#d12").val();
        var bornreg = /^((19\d{2})|(200\d)|(201\d))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
        if (!bornreg.test(a)) {
            $("#b12").text("*出生日期不合法!");
            return false;
        }
        $("#b12").text("正确!");
        return true;
    }


    function checkdire() {
        $("#b15").text("");
        var sex = document.getElementsByName("sex");
        var sexvalue = "";
        for (var i = 0; i < sex.length; i++) {
            if (sex[i].checked) {
                sexvalue = sex[i].value;
            }
        }
        if (sexvalue == "") {
            /*$("#b15").text("*请选择您所在的性别!");*/
            return false;
        }
        $("#b15").text("*选择完成!");
        /*$("#b15").text("您选择的性别是:"+sexvalue+"!");*/
        return true;
    }


    function checkself() {
        $("#b17").text("");
        var a = $("#d17").val();
        /*var selfreg=/^[\u4e00-\u9fa5]{10,}$/;
        if(!selfreg.test(a)){
            $("#b17").text("*自我介绍不得少于10个字!");
            return false;
        }*/
        $("#b17").text("输入完成!");
        return true;
    }
</script>
</body>
</html>
