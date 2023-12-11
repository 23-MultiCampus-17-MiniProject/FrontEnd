<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼</h1>
<form action="memberservice" method="post">
	아이디<input type="text" name="memberid"><br>
	비번<input type="password" name="pw"><br>
	이름<input type="text" name="membername"><br>
	폰<input type="text" name="phone"><br>
	이메일<input type="email" name="email"><br>
	가입일<input type="datetime-local" name="regdate"><br>
	<input type="submit" value="회원가입">
</form>
</body>
</html>