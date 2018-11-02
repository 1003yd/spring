<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello.jsp
	<h2>rangers</h2>
	<c:forEach items="${rangers}" var ="ranger">
	
		rangers_name : ${ranger} <br>
	</c:forEach>
	
	<h2>/hello/request</h2>
	<form action="/hello/requset" method="post">
		userId : <input type="text" name="userId" value="brown">
		password : <input type="text" name="pass" value="password">
		<input type="submit" value="전송">
	</form>

	<h2>/hello/vo</h2>
	<form action="/hello/requset" method="post">
		userId : <input type="text" name="userId" value="브라운">
		password : <input type="text" name="pass" value="password">
		<input type="submit" value="전송">
	</form>
</body>
</html>