<%--
  Created by IntelliJ IDEA.
  User: Stormer
  Date: 2019/12/23
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用学生信息管理系统！请登录</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
<div class="space"></div><!--页面填充效果-->
<div class="logindiv" id="logindiv">
    <div class="banner">
        <h2>学生信息管理系统</h2>
    </div>
    <form action="/UserController" method="post" id="login">
        <span class="user"></span><input type="text" placeholder="请输入用户名" id="username">
        <span id="usermessage"></span>
        <span class="pass"></span><input type="password" placeholder="请输入密码" id="password">
        <span id="passmessage"></span>
        <input type="text" id="code">
        <span><img src = "#" id = "codeImage" alt="验证码图片"/></span>
        <input type="submit" value="登录" id="loginbtn">
        <input type="hidden" name="sims" value="1">
    </form>
    <input type="button" value="去注册" id="toregister">
</div><!--登录框-->
<div class="registerdiv" id="registerdiv">
    <div class="banner">
        <h2>学生信息管理系统</h2>
    </div>
    <form action="/UserController" method="post" id="register">
        <span class="user"></span><input type="text" placeholder="请输入用户名" id="username2">
        <span id="usermessage2"></span>
        <span class="pass"></span><input type="password" placeholder="请输入密码" id="password2">
        <span id="passmessage2"></span>
        <span class="email"></span><input type="text" placeholder="请输入邮箱" id="email">
        <span id="emailmessage"></span>
        <input type="submit" value="注册" id="registerbtn">
        <input type="hidden" name="sims" value="0">
    </form>
    <input type="button" value="去登录" id="tologin">
</div><!--注册框-->
<div class="foot"></div><!--底部框-->
<script src="../js/login.js"></script>
</body>
</html>
