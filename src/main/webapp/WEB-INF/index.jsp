<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAnonymous()">
    <h5><a href='<c:url value="/secu/loginPage"/>'>LOGIN</a> 로그인 해주세요.</h5>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p><sec:authentication property="principal.username"/>님, 반갑습니다.<br/> </p>
    <a href="#" onclick="document.getElementById('logout-form').submit();">Sign out</a>
    <form id="logout-form" action='<c:url value='/logout'/>' method="POST">
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
</sec:authorize>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/WEB-INF/include/header.jspf"  %>
    <title>INDEX</title>
</head>
<body>
<br><br>
<div class="container text-center">
    <h1>Security Prj</h1><br>
</div>
<br><br>
<div class="container text-center col-2">
    <a href='<c:url value="/page"/>' role="button" class="btn btn-outline-secondary btn-block">GUEST</a>
    <a href='<c:url value="/user/page"/>' role="button" class="btn btn-outline-secondary btn-block">USER</a>
    <a href='<c:url value="/member/page"/>' role="button" class="btn btn-outline-secondary btn-block">MEMBER</a>
    <a href='<c:url value="/admin/page"/>' role="button" class="btn btn-outline-secondary btn-block">ADMIN</a>
</div>
</body>
</html>