
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师添加</title>
    <link rel="stylesheet" href="../css/tea-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/UserController" method="post">
            <input type="hidden" name="sims" value="2">
            <span>工      号:</span><input type="text" name="sno" id="snoadd" ><br/>
            <span>姓      名:</span><input type="text" name="name" id="nameadd" ><br/>
            <span>性      别:</span><input type="radio" name="sex" value="1" class="sexinput">男
                                    <input type="radio" name="sex" value="0" class="sexinput">女<br/>
            <span>生      日:</span><input type="date" name="birth" id="birthadd"><br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
