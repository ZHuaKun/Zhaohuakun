<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 2021/11/29
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<form action="${pageContext.request.contextPath}/param2/reg" method="post">
    用户名：<input name="username"><br>
    密码：<input name="pwd"><br>
    年龄：<input name="age"><br>
    <input type="submit" value="reg">
</form>
</body>
</html>
