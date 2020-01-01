<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>专业注册更新</title>
    <link rel="stylesheet" href="../css/spe-update-off.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="speupdate">
        <div class="spemessage">
            <span>专业名称：</span><span>${spe.name}</span>
            <span>所属院系：</span><span>${spe.faculty}</span>
            <span>专业类型：</span><span>${spe.typeStr}</span>
        </div>
        <div class="update">
            <h2>专业学生</h2>
            <form action="/SpecialityController?sims=8" method="post">
                <c:forEach items="${student}" var="stu"><!--显示此专业的所有学生-->
                 <input type="checkbox" name="studentid" value="${stu.id}">${stu.name}<br>
                </c:forEach>
                <input type="submit"  value="提交" id="addbtn">
            </form>
        </div>
    </div>
</div>
</body>
</html>
