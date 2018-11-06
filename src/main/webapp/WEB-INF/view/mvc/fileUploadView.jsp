<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fileUpload view</h2>
	<form action="/mvc/fileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="text" name="userId" value="brown"> 
		<input type="submit" value="전송">
	</form>
</body>
</html>