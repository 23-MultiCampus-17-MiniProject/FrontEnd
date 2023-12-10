<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
	<link rel="stylesheet" href="./css/index.css">
	<link rel="stylesheet" href="./css/reserve.css">
    <style>
        #date{
            margin:10px;
		text-align:center;
        }
        #date>span{
            display:inline-block;
            text-align:center;
            padding:5px 8px;
        }
        #date>span:hover{
            background-color:lightgray;
        }
        #movie{
            height:100%;
            width:30%;
            float:left;
        }
        #result{
            width:70%;
            float:left;
        }
	.age_grade{
		width:20px;
		height:20px;
	}
        .sunday{
            color:red;
        }
        .satday{
            color:blue;
        }
        .movie_select:hover{
            background-color:lightgray;
        }
        .result_time>span{
            display:inline-block;
            text-align:center;
            padding:5px 10px;
        }
        .result_time>span:hover{
            background-color:lightgray;
        }
        .result_time>span:target{
            background-color:lightgreen;
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
<div id="body">
    <div id="movie">
        ▼ 영화를 선택해주세요.<br><br>
        <div class="movie_select"><img src="./images/age_grade/18.png" class="age_grade"> 이웃집 토토로</div>
        <div class="movie_select"><img src="./images/age_grade/ALL.png" class="age_grade"> 1917</div>
        <div class="movie_select"><img src="./images/age_grade/15.png" class="age_grade"> 더 마블스</div>
        <div class="movie_select"><img src="./images/age_grade/12.png" class="age_grade"> 암살</div>
        <div class="movie_select"><img src="./images/age_grade/ALL.png" class="age_grade"> 범죄도시2</div>
    </div>
    <div id="result">
        ▼ 날짜를 선택해주세요.
        <div id="date"><span>←<br>이전 주</span><span class="sunday">10/20<br>일</span><span>10/21<br>월</span><span>10/22<br>화</span><span>10/23<br>수</span><span>10/24<br>목</span><span>10/25<br>금</span><span class="satday">10/26<br>토</span><span>→<br>다음 주</span></div>
        <!-- <div id="result">영화를 선택해주세요.</div> -->
        <div>
            <div class="result_theater">
                <h3>3관</h3>
                <div class="result_time">
                    <button class="select_time" value="2023.10.21A08:40T3M25"><strong>08:40</strong><br>150/150</button>
                    <button class="select_time"><strong>10:30</strong><br>150/150</button>
                    <button class="select_time"><strong>13:10</strong><br>150/150</button>
                    <button class="select_time"><strong>15:00</strong><br>150/150</button>
                    <button class="select_time"><strong>17:30</strong><br>150/150</button>
                    <button class="select_time"><strong>19:55</strong><br>150/150</button>
                    <button class="select_time"><strong>21:15</strong><br>150/150</button>
                    <button class="select_time"><strong>23:45</strong><br>150/150</button>
                    <button class="select_time"><strong>24:55</strong><br>150/150</button>
                    <button class="select_time"><strong>26:20</strong><br>150/150</button>
                    <button class="select_time"><strong>28:00</strong><br>150/150</button>
                </div>
            </div>
            <div class="result_theater">
                <h3>5관</h3>
                <div class="result_time">
                    <button class="select_time"><strong>08:40</strong><br>150/150</button>
                    <button class="select_time"><strong>10:30</strong><br>150/150</button>
                    <button class="select_time"><strong>13:10</strong><br>150/150</button>
                    <button class="select_time"><strong>15:55</strong><br>150/150</button>
                    <button class="select_time"><strong>18:00</strong><br>150/150</button>
                    <button class="select_time"><strong>20:30</strong><br>150/150</button>
                    <button class="select_time"><strong>22:45</strong><br>150/150</button>
                    <button class="select_time"><strong>24:55</strong><br>150/150</button>
                </div>
            </div>
            <div class="result_theater">
                <h3>6관</h3>
                <div class="result_time">
                    <button class="select_time"><strong>08:40</strong><br>150/150</button>
                    <button class="select_time"><strong>10:30</strong><br>150/150</button>
                    <button class="select_time"><strong>13:10</strong><br>150/150</button>
                    <button class="select_time"><strong>15:00</strong><br>150/150</button>
                    <button class="select_time"><strong>17:30</strong><br>150/150</button>
                    <button class="select_time"><strong>19:55</strong><br>150/150</button>
                    <button class="select_time"><strong>21:15</strong><br>150/150</button>
                    <button class="select_time"><strong>23:45</strong><br>150/150</button>
                    <button class="select_time"><strong>24:55</strong><br>150/150</button>
                    <button class="select_time"><strong>26:20</strong><br>150/150</button>
                    <button class="select_time"><strong>28:00</strong><br>150/150</button>
                </div>
            </div>
            <div class="result_theater">
                <h3>8관</h3>
                <div class="result_time">
                    <button class="select_time"><strong>08:40</strong><br>150/150</button>
                    <button class="select_time"><strong>10:30</strong><br>150/150</button>
                    <button class="select_time"><strong>13:10</strong><br>150/150</button>
                    <button class="select_time"><strong>15:00</strong><br>150/150</button>
                    <button class="select_time"><strong>17:30</strong><br>150/150</button>
                    <button class="select_time"><strong>19:55</strong><br>150/150</button>
                    <button class="select_time"><strong>21:15</strong><br>150/150</button>
                    <button class="select_time"><strong>23:45</strong><br>150/150</button>
                    <button class="select_time"><strong>24:55</strong><br>150/150</button>
                    <button class="select_time"><strong>26:20</strong><br>150/150</button>
                    <button class="select_time"><strong>28:00</strong><br>150/150</button>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
	let selectTime=document.querySelectorAll(".select_time");
	selectTime.forEach((e) => {
		console.log(e.value);
		e.addEventListener("click",function(event){
			let sendForm=document.createElement("form");
			sendForm.setAttribute("method","post");
			sendForm.setAttribute("action","./reserve_select.html");
			
			let sendMovieInfo=document.createElement("input");
			sendMovieInfo.setAttribute("type","hidden");
			sendMovieInfo.setAttribute("name","movie_info");
			sendMovieInfo.setAttribute("value",e.value);
			sendForm.appendChild(sendMovieInfo);

			document.body.appendChild(sendForm);
			sendForm.submit();
		});
	});
</script>
</body>
</html>