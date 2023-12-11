<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드자<%=request.getParameter("name") %></h1>
<h1>설명<%=request.getParameter("desc") %></h1>
<h1>${saveresult1 }</h1>
<h1>${saveresult2 }</h1>
</body>
</html>