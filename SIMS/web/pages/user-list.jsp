<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户查询</title>
    <link rel="stylesheet" href="../css/user-list.css">
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
                <li id="userlist" name="userlist"><a href="javascript:0">用户查询</a></li>
                <li id="useradd" name="useradd"><a href="javascript:0">用户添加</a></li>
                <li id="usergrant" name="usergrant"><a href="javascript:0">用户授权</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="space"></div>
<div class="main">
    <div class="search">
        <form action="#" method="post">
            <input type="text" name="keyword" placeholder="请输入关键字">
            <input type="submit" name="submit" value="搜索" id="searchbtn">
        </form>
    </div>
    <div class="searchdetail">
        <table id="table">
            <tr>
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>注册时间</th>
                <th>用户类型</th>
            </tr>
            <c:forEach items="" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.time}</td>
                    <td>${user.typeStr}</td>
                </tr>
            </c:forEach>

        </table>
        <a href="#" id="btn0"></a>
        <a href="#" id="btn1">首页</a>
        <a href="#" id="btn2">上一页</a>
        <a href="#" id="btn3">下一页</a>
        <a href="#" id="btn4">尾页</a>
    </div>
</div>
</div>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/user-list.js"></script>
</body>
</html>
