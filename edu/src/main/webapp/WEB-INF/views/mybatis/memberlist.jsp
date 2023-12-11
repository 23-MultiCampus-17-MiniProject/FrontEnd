<%@page import="spring.mybatis.service.MemberDTO"%>
<%@page import="java.util.List"%>
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
<a href="registermember">회원가입하러 가기</a>
<a href="modifymember">회원정보수정하러 가기</a>
<a href="deletemember?memberid=springinsertid">회원탈퇴하러 가기</a>

<form action="membersearchlist">
<select name="item">
	<option>이름 검색</option>
	<option>아이디 검색</option>
	<option>폰번호 검색</option>
	<option>이메일 검색</option>
</select>
검색어:<input type=text name="searchword">
<input type="submit" value="검색">
</form>
<hr>
<h1>${memberCount }</h1>

<hr>
<h1>=====자바로======</h1>
<% List<MemberDTO> memberlist = (List<MemberDTO>)request.getAttribute("memberlist"); 
for(MemberDTO dto : memberlist){
%>

<h3>
<%=dto.getMemberid() %>,
<%=dto.getMembername() %>,
<%=dto.getEmail() %>,
<%=dto.getRegdate() %>
</h3>

<% 	
}
%>
<hr>
<h1>=====EL로======</h1>
<c:forEach items="${memberlist}" var="dto">
	<h3>
	${dto.memberid },
	${dto.membername },
	${dto.email },
	${dto.regdate },
	</h3>
</c:forEach>


</body>
</html>