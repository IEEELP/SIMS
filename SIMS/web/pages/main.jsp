<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="../css/main.css">
</head>
<body>
<div class="banner">
    <h2>学生信息管理系统</h2>
    <span>${username}欢迎您使用</span>
</div>
<div class="side">
    <ul class="menu">
        <li id="usermanner" class="bigslide">用户管理
            <ul id="userul">
                <li id="userlist" name="userlist"><a href="${pageContext.request.contextPath}/UserController?sims=2">用户查询</a></li>
                <li id="useradd" name="useradd"><a href="javascript:0">用户添加</a></li>
                <li id="usergrant" name="usergrant"><a href="javascript:0">用户授权</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="space"></div>
<div class="main">
    <div class="welcomemessage"></div>
</div>
<script src="../js/main.js"></script>
</body>
</html>
