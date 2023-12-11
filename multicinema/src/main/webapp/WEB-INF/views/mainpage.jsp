<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>최고의 영화관. MultiCinema</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="resources/js/jquery-3.7.1.min.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="/multicinema/resources/css/index.css">
</head>
<style>
	html{
		text-align:center;
	}
	#contents{
		margin-top: 70px;
	}
	#boxoffice{
		font-size: 30px;
		margin:0 auto;
		margin-bottom: 30px;
	}
	
	#movieChart{
		width: 1400px;
		margin: 0 auto;
	}
	.movie{
		width:250px;
		height:520px;
		margin-right:30px;
		position:relative;
		display: inline-block;
	}
	.movie:nth-child(5){
		margin-right:0px;
	}
	.img_wrap{
		
		width: 100%;
		height: 70%;
		position:relative;

	}
	
	.movie_detail_wrap{
		width: 100%;
		height: 100%;
		position:absolute;
		z-index: 2;
		background-color: rgba(0,0,0,0.6);
		top: 0%;
		border-radius: 10px;
	}
	
	.img_wrap > img{
		border-radius: 10px;
		width: 100%;
		height: 100%;
		z-index: 0;
		position:relative;
	}
	.age_limit_icon{
		width: 30px;
		height : 30px;
		position:relative;
		top: -95%;
		left: 85%;
		z-index: 1;
	}
	
	.age_limit_icon > img{
		width: 100%;
		height: 100%;
		z-index: 1;
	}
	
	.movie_info{
		width: 100%;
		height: 10%;
	}
	.movie_btn{
		width: 90%;
		height: 15%;
		margin:0 auto;
	}
	.movie_title{
		width: 100%; 
		margin-top: 20px; 
		text-align: center;
		font-size: 20px;
		font-weight: 900;
		
	}
	.score_percentage{
		margin: 20px;
		text-align: center;
	}
	.movie_info > span{
		width: 50%;
		
	}
	.movie_btn a{
		text-decoration: none;
		color: rgb(0, 0, 0);
		font-size: 15px;
		font-weight: 900;
		line-height: 40px;
		
	}
	.movie_btn div{
		display: inline-block;
		width: 40%;
		height : 40px;
		background-color: rgb(254, 228, 1);
		margin: 5%;
		border-radius: 20px;
		text-align: center;
		
	}
	.rank{
		font-size: 70px;
		font-style: italic;
		color: white;
		font-weight: 400;
		text-shadow: 2px 2px 2px rgba(0,0,0,0.8);
		left: 0%;
		top:-31%;
		position: relative;
		width: 50px;
		height: 60px
	}
	
	.movie_detail_btn{
		background-color: white;
		width: 50%;
		height: 10%;
		border-radius: 10px;
		text-align: center;
		line-height: 38px;
		margin-left: auto;
		margin-right: auto;
		position: relative;
		top:50%;
		margin-top: -5%;
	}
	
	.movie_detail{
		text-decoration: none;
		color: rgb(0, 0, 0);
	}
	.movie_info_score{
		margin-right: 2px;
		padding-right: 5px;
		border-right: 1px solid rgb(0,0,0,0.2) ;
	}
</style>

<script>
	


onload = () => {
		
	
	let movie_arr = [{title:"더 마블스", score:90, grade:15},{title:"이웃집 토토로", score:80, grade:18},
	{title:"암살", score:85, grade:12},{title:"범죄도시2", score:65, grade:"ALL"},{title:"1917", score:75, grade:"ALL"}];
	
	movie_arr.sort((a,b) => b.score - a.score);//평점순으로 내림차순 정렬
	
	let movie_poster_frame = document.querySelectorAll(".movie > .img_wrap > img");
	let movie_grade_frame = document.querySelectorAll(".movie > .img_wrap > .age_limit_icon > img");
	let movie_title = document.getElementsByClassName("movie_title");
	let movie_btn = document.querySelectorAll(".movie_btn a");
	let movie_detail = document.getElementsByClassName("movie_detail");
	let movie_detail_wrap = document.getElementsByClassName("movie_detail_wrap");
	let movie_detail_btn = document.getElementsByClassName("movie_detail_btn");
	let movie_info_score = document.getElementsByClassName("movie_info_score");
	//평점이나 예매율은 나중에 팀이랑 물어보고
	
//	let movie_grade


	function spaceTo_(str){
		let result = str.replace(" ", "_");
		while(result.indexOf(" ") != -1){
			let tmp = result.replace(" ", "_");
			result = tmp;
		}
		return result;
	}
	
	function ageLimitUrl(grade){
		if(grade == "ALL"){
			return "images/age_grade/ALL.png"
		}else if(grade == 12){
			return "images/age_grade/12.png"
		}else if(grade == 15){
			return "images/age_grade/15.png"
		}else if(grade == 18){
			return "images/age_grade/18.png"
		}
	}

	function movie_maker(movie, idx){
		
		movie_poster_frame[idx].src = "images/movie_poster/" + spaceTo_(movie.title) + ".jpg";
		movie_grade_frame[idx].src = ageLimitUrl(movie.grade);
		movie_title[idx].innerHTML = movie.title;
		movie_btn[idx*2].href = "timetable_movie.html?movie_title="+movie.title;
		movie_btn[idx*2+1].href = "review.html?movie_title="+movie.title;
		movie_detail[idx].href = "detail.html?movie_title="+movie.title;
		movie_info_score[idx].innerHTML = "평점 " + movie.score;
		
		movie_poster_frame[idx].addEventListener("mouseenter", ()=>{
			movie_detail_wrap[idx].style = "visibility: visible";
		})
		movie_detail_wrap[idx].addEventListener("mouseleave", e =>{
			e.target.style = "visibility: hidden";
		})
		
		movie_detail_btn[idx].addEventListener("mouseenter", e =>{
			e.target.style = "background-color: rgb(254, 228, 1)"
		})
		movie_detail_btn[idx].addEventListener("mouseleave", e =>{
			e.target.style = "background-color: white"
		})
	}
	
	for(let i = 0; i < movie_arr.length; i++){
		movie_maker(movie_arr[i], i);
	}
	
	
		
}
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
	<div id="contents"><!--박스오피스 칸-->
		<div id="boxoffice">박스오피스</div>
		<div id ="movieChart">
			<div class="movie">
				<div class = "img_wrap">
					<img src="" alt="영화 포스터" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="">
					</div>
					<div class = "rank">1</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title"></div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a> 예매하기 </a></div><div class = "review_btn"><a> 리뷰보기 </a></div>
				</div>
			</div>
			<div class="movie">
				<div class = "img_wrap">
					<img src="" alt="영화 포스터" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="">
					</div>
					<div class = "rank">2</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title"></div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a> 예매하기 </a></div><div class = "review_btn"><a> 리뷰보기 </a></div>
				</div>
			</div>
			<div class="movie">
				<div class = "img_wrap">
					<img src="" alt="영화 포스터" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="">
					</div>
					<div class = "rank">3</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title">더 마블스</div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a> 예매하기 </a></div><div class = "review_btn"><a> 리뷰보기 </a></div>
				</div>
			</div>
			<div class="movie">
				<div class = "img_wrap">
					<img src="" alt="영화 포스터" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="">
					</div>
					<div class = "rank">4</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title">더 마블스</div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a> 예매하기 </a></div><div class = "review_btn"><a> 리뷰보기 </a></div>
				</div>
			</div>
			<div class="movie">
				<div class = "img_wrap">
					<img src="" alt="영화 포스터" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="">
					</div>
					<div class = "rank">5</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title">더 마블스</div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a> 예매하기 </a></div><div class = "review_btn"><a> 리뷰보기 </a></div>
				</div>
			</div>
			
		</div>
	</div> 
</body>
</html>