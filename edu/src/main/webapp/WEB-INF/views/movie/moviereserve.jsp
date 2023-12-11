<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${id }회원님 ${age }살 입니다</h1>
<H2>시청 가능 영화목록</H2>
<h3>${result }</h3>

<video src="resources/multimedia/chrome.mp4" controls width=600 height=400 poster="resources/multimedia/chrome.jpg"></video>
<!-- 
	안된다 왜? dispatcherservlet이 모든 요청을 받는데 설정안해서 근데 이건 뭘 처리할만한게 없다 => 이런건 따로 놔두기
	 => webappresources mvc구조와 상관없는것들
-->
</body>
</html>