<%@page import="java.util.HashMap"%>
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
<form action="moviereserve">
	<input type="text" name="id">
	<input type="password" name="pw">
	<input type="number" name="age">
	<select name="movielist" multiple>
		<c:forEach items="${moviemodel }" var="onemovie">
			<option>${onemovie.key }</option>
		</c:forEach>
	</select>
	<input type=submit value="영화신청버튼">
</form>
</body>
</html>