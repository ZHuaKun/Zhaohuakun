<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 2021/11/26
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
  <title>登录(首页)</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
</head>
<body class="login_bg">
<section class="loginBox">
  <header class="loginHeader">
    <h1>超市订单管理系统</h1>
  </header>
  <section class="loginCont">
    <form class="loginForm" action="${pageContext.request.contextPath }/user/login"  name="actionForm" id="actionForm"  method="post" >
      <div class="info">${msg}</div>
      <div class="inputbox">
        <label >用户名：</label>
        <input type="text" class="input-text" id="userCode" name="username" placeholder="请输入用户名" required/>
      </div>
      <div class="inputbox">
        <label >密&nbsp&nbsp&nbsp&nbsp码：</label>
        <input type="password" id="userPassword" name="pwd" placeholder="请输入密码" required/>
      </div>
      <div class="subBtn">
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
      </div>
      <a href="${pageContext.request.contextPath}/user/delete.do">执行删除功能</a>
    </form>
  </section>
</section>
</body>
</html>

