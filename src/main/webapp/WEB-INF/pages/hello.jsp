<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 2021/11/26
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uesr/uplpad.do">
        上传头像:<input type="file" name="image" /><br>
        <input type="submit" value="上传"/>
    </form>
</div>
<%--你好！！！,${requestScope.username}!!!你今年${requestScope.age}岁.--%>
<%--你好！！！,${sessionScope.username}!!!你今年${sessionScope.age}岁.--%>
你好！！！,${requestScope.user.username}!!!你今年${requestScope.user.age}岁.
</body>
</html>
