<%--
  Created by IntelliJ IDEA.
  User: 82107
  Date: 2021-10-05
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="document.f.username.focus();">
<h3>Login with Username and Password</h3>
<form name="f" action="/login" method="POST">
    <input type="text" class="form-control" name="loginId" placeholder="example">
    <input type="password" class="form-control" name="loginPwd" placeholder="Password">
    <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</body>
</html>
