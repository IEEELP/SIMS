<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>教师查询</title>
    <link rel="stylesheet" href="../css/tea-list.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="search">
        <form action="#" method="post">
            <input type="text" name="keyword" placeholder="请输入关键字">
            <input type="submit" name="submit" value="搜索" id="searchbtn">
        </form>
    </div>
    <div class="searchdetail">
        <table id="table">
            <tr>
                <th>工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
                <th>专业</th>
                <th>删除用户</th>
            </tr>
            <c:forEach items="${requestScope.result}" var="student">
                <tr>
                    <td>${teacer.tno}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.sex}</td>
                    <td>${teacher.birthday}</td>
                    <td>${teacher.academic}</td>
                    <td><a href="#">删除</a></td>
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
