
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <link rel="stylesheet" href="../css/user-add.css">
</head>
<body>
<div class="banner">
    <h2>学生信息管理系统</h2>
    <span>欢迎您使用</span>
</div>
<div class="side">
    <ul class="menu">
        <li id="usermanner" class="bigslide">用户管理
            <ul id="userul">
                <li id="userlist" name="userlist"><a href="javascript:0">用户查询</a></li>
                <li id="useradd" name="useradd"><a href="javascript:0">用户添加</a></li>
                <li id="usergrant" name="usergrant"><a href="javascript:0">用户授权</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="space"></div>
<div class="main">
    <div class="addlist">
        <form action="#" method="post">
            <input type="text" name="username" placeholder="请输入用户名"><br/>
            <input type="text" name="email" placeholder="请输入邮箱"><br/>
            <input type="text" name="type" placeholder="请输入用户类型"><br/>
            <input type="submit" name="addbtn" value="添加" id="addbtn">
        </form>
    </div>
</div>
<script src="../js/user-add.js"></script>
</body>
</html>
