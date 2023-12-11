<%@page import="springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HelloDTO dto = (HelloDTO)request.getAttribute("model");
%>
<%= dto.getMessage() %>
</body>
</html>