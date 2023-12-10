<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <meta charset="utf-8">
	<link rel="stylesheet" href="./css/index.css">
    <style>
	#image_complate{
		width:100px;
		heigth:100px;
	}
        #result_title{
            text-align:center;
            margin-top:15%;
        }
        #result_msg{
            text-align:center;
        }
        #button{
            text-align:center;
        }
        #button>a{
            display:inline-block;
            text-decoration:none;
            font-size:20px;
            padding:10px;
            margin:10px 10px;
            border-radius:10px;
            background-color:rgb(254, 228, 1);
            color:black;
        }
        #button>a:hover{
            background-color:gray;
            color:white;
        }
    </style>
    <script src="script/reserve.js"></script>
</head>
<body>
<!-- 공통 UI 삽입 부분 -->
<header class="body">
	<div class="header">
		<h1 class="mainlogo">
			<a href="mainpage.html" title="홈화면으로 가기">홈으로가기</a>
		</h1>
		<div class="myinformation">
			<a href="main_signout.html">로그아웃하기</a>
			<a href="mypage.html">내정보확인</a>
		</div>
	</div>
		
	<hr>
		<ul id="mainNavigator">
			<li id="movie"><a href="movie.html">영화</a></li>
			<li id="ticketing"><a href="timetable_select.html">예매</a></li>
			<li id="theater"><a href="theater.html">영화관</a></li>
		</ul>
	<hr>
</header>

<!-- 기능별 구현 부분 -->
<div id="result_title">
    <h2>예매 결과를 불러오는 중입니다.</h2>
</div>
<div id="result_msg">
    잠시만 기다려주세요.<br>
</div>
<script>
	let resultTitle=document.querySelector("#result_title");
	let resultMsg=document.querySelector("#result_msg");

	resultTitle.innerHTML="<img id='image_complate' src='https://cdn-icons-png.flaticon.com/512/7799/7799536.png'><h2>예매 완료!<h2>";
	resultMsg.innerHTML="예매가 정상적으로 처리되었습니다.<br><div id='button'><a href='mainpage.html'>메인 페이지로 돌아가기</a>";
</script>
</body>
</html>