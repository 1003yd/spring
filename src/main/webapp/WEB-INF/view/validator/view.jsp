<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Validate</h2>
	<form action="/validator/validate" method="post">
													<!-- 에러 메세지가 있을 때 출력하라는 의미 -->				
		userId : <input type="text" name="userId" value="${param.userId}" /> <form:errors path="userVo.userId"/> <br>
		userPass : <input type="text" name="pass" /> <form:errors path="userVo.pass"/> <br>
		userName : <input type="text" name="name" value="${param.name}" /> <form:errors path="userVo.name"/> <br>
		<input type="submit" value="전송"/>
	</form>

	<h2>Jsr 303</h2>
	<form action="/validator/validateJsr" method="post">
													<!-- 에러 메세지가 있을 때 출력하라는 의미 -->				
		userId : <input type="text" name="userId" value="${param.userId}" /> <form:errors path="userVoJsr303.userId"/> <br>
		userPass : <input type="text" name="pass" /> <form:errors path="userVoJsr303.pass"/> <br>
		userName : <input type="text" name="name" value="${param.name}" /> <form:errors path="userVoJsr303.name"/> <br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>