
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生添加</title>
    <link rel="stylesheet" href="../css/stu-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="UserController/" method="post">
            <input type="hidden" name="sims" value="#">
            <span>学      号:</span><input type="text" name="sno" id="snoadd" ><br/>
            <span>姓      名:</span><input type="text" name="name" id="nameadd" ><br/>
            <span>性      别:</span><input type="text" name="sex" id="sexadd"><br/>
            <span>生      日:</span><input type="text" name="bith" id="birthadd"><br/>
            <span>专      业:</span><input type="text" name="spe" id="speadd"><br/>
            <span>宿      舍:</span><input type="text" name="dor" id="doradd"><br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
