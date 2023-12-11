<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일업로드폼</h1>
<form action="fileupload" method="post" enctype="multipart/form-data">
작성자<input type="text" name="name"><br>
설명<input type="text" name="desc"><br>
파일1<input type="file" name="file1"><br>
파일2<input type="file" name="file2"><br>

<input type="submit" value="파일업로드">
</form>
</body>
</html>