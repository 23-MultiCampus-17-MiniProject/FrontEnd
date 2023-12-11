<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%= request.getAttribute("title") %></h1>
<h1>${title }</h1>
<form action="login" method="post">
	아이디<input type="text" name="id">
	비번<input type="text" name="pw">
	나이<input type="number" name="age">
	<input type="submit" value="로그인">
</form>
</body>
</html>