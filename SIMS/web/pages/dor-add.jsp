
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍添加</title>
    <link rel="stylesheet" href="../css/dor-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="UserController/" method="post">
            <input type="hidden" name="sims" value="#">
            <span>编      号:</span><input type="text" name="id" id="idadd" ><br/>
            <span>宿  舍  号:</span><input type="text" name="dno" id="dnoadd" ><br/>
            <span>类      型:</span><input type="text" name="type" id="typeadd"><br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
