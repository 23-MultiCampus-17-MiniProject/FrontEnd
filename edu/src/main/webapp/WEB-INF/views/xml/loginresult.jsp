<%@page import="loginmvc.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% LoginDTO model = (LoginDTO)request.getAttribute("login"); %>
<%=model.getId()%> 회원님 암호는 <%=model.getPw()%>입니다.
<hr>
${login.id }회원님 암호는 ${login.pw }입니다.

</body>
</html>