$(document).ready(function(){
	let today = new Date();
	let hour = today.getHours();
	let oneDay = 86400000;
	let numberDate = "";
	let yesterday = "";
	var movieListLength = 10;
	function yyyyMMdd(dt){
	
		let year = dt.getFullYear(); 
		let month = dt.getMonth() + 1;  
		let date = dt.getDate();
		
		month = month >= 10 ? month : '0' + month;
		date = date >= 10 ? date : '0' + date;
		
		let res = "".concat(year,month,date);
		
		return res;
	}

	if(hour >= 18){
		numberDate = yyyyMMdd(today);
	}else{
		yesterday = new Date(today-oneDay);
		numberDate = yyyyMMdd(yesterday);
	}
	
	let test = "20231201";
	
	console.log(numberDate)
	console.log(yesterday)
	console.log(test);

	let movie_title = document.getElementsByClassName("movie_title");
	let movie_btn = document.querySelectorAll(".movie_btn a");
	let movie_detail = document.getElementsByClassName("movie_detail");
	
	
	let movie_info_score = document.getElementsByClassName("movie_info_score");

	function spaceTo_(str){
		let result = str.replace(" ", "_");
		while(result.indexOf(" ") != -1){
			let tmp = result.replace(" ", "_");
			result = tmp;
		}
		return result;
	}
	
	function ageLimitUrl(grade){
		
		if(grade == "전체"){
			return "resources/images/age_grade/ALL.png"
		}else if(grade == "12"){
			return "resources/images/age_grade/12.png"
		}else if(grade == "15"){
			return "resources/images/age_grade/15.png"
		}else if(grade == "18"){
			return "resources/images/age_grade/18.png"
		}
	}
	
	let movieList = document.getElementById("movieList");
	
	function movie_maker(movie_input){
		movieList.style = "width:" + Math.ceil(movieListLength / 5) * 1392.5 + "px";
		movieList.innerHTML += `
			<div class="movie">
				<div class = "img_wrap">
					<img src= "resources/images/movie_poster/${movie_input.rank}.jpg" alt="${movie_input.movieNm}" >
					<div class="movie_detail_wrap" style="visibility: hidden">
						<a href="moviedetail?movieCd" class="movie_detail" >
							<div class="movie_detail_btn">상세보기</div>
						</a>
					</div>
					<div class = "age_limit_icon">
						<img src="${ageLimitUrl(movie_input.grade)}">
					</div>
					<div class = "rank">${movie_input.rank}</div>
				</div>
				<div class = "movie_info">
					<div class="movie_title">${movie_input.movieNm}</div>
					<span class="movie_info_score">평점 </span><span>예매율 </span>
				</div>
				<div class = "movie_btn">
					<div class = "ticket_btn"><a href=""> 예매하기 </a></div>
					<div class = "review_btn"><a href=""> 리뷰보기 </a></div>
				</div>
			</div>`

	}
	
	function add_event(){
		
		let movie_poster_frame = document.querySelectorAll(".movie > .img_wrap > img");
		let movie_grade_frame = document.querySelectorAll(".movie > .img_wrap > .age_limit_icon > img");
		let movie_detail_wrap = document.getElementsByClassName("movie_detail_wrap");
		let movie_detail_btn = document.getElementsByClassName("movie_detail_btn");
		for(let i =0; i < movie_poster_frame.length; i++){
			movie_poster_frame[i].addEventListener("mouseenter", ()=>{
				movie_detail_wrap[i].style = "visibility: visible";
			})
			movie_detail_wrap[i].addEventListener("mouseleave", e =>{
				e.target.style = "visibility: hidden";
			})
		
			movie_detail_btn[i].addEventListener("mouseenter", e =>{
				e.target.style = "background-color: rgb(254, 228, 1)"
			})
			movie_detail_btn[i].addEventListener("mouseleave", e =>{
				e.target.style = "background-color: white"
			})
		}
	}
	
	
	function Movie(movieCd, movieNm, grade, rank){
		
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.rank = rank;
		this.grade = grade;
		
	}
	
	let movie_arr = [];
	$.ajax({
		url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		method: "GET",
		async: false,
		dataType: 'json',
		data:{
			key: "f0b5971de85c22ab8010d759968eef23",
			itemPerPage: "10",
			targetDt: numberDate
		}
		
	}).done(function(msg){
		
		for(let i=0; i<msg.boxOfficeResult.dailyBoxOfficeList.length; i++){
			let short_url = msg.boxOfficeResult.dailyBoxOfficeList[i];
			let movie = new Movie(short_url.movieCd, short_url.movieNm, get_grade(short_url.movieCd), short_url.rank);
			movie_maker(movie);
		}
		add_event();
	});
	
	function get_grade(movieCd_input){
		let result = "";
		$.ajax({
			url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
			method: "GET",
			
			dataType: 'json',
			data:{
				key: "f0b5971de85c22ab8010d759968eef23",
				movieCd: movieCd_input
				
			}
		}).done(function(msg){
			let short_url = msg.movieInfoResult.movieInfo;
			
			for(let i=0; i<short_url.audits.length; i++){
				let tmp = short_url.audits[i].watchGradeNm;
				result = tmp.substring(0, 2);
				console.log(result);
			}
		});
		
		return result;
	};
	
	
	
	
	console.log("테스트")
	let btn_left = document.getElementById("slide_btn_left");
	let btn_right = document.getElementById("slide_btn_right");
	var current_page = 1;
	var end_page = Math.ceil(movieListLength / 5);
	
	console.log(movieListLength);
	btn_right.addEventListener('click', function(){
		if(end_page != current_page){
			document.getElementById("movieList").style.transform = "translate(-" + (1428 * current_page) + "px)"
			document.getElementById("movieList").style.transitionProperty = "transition-property: transform;";
			document.getElementById("movieList").style.transitionDuration = "0.5s";
			current_page++;
			console.log(current_page);
			console.log("endpage:" +end_page);
		}
	});
	btn_left.addEventListener('click', function(){
		if(current_page != 1){
			current_page--;
			document.getElementById("movieList").style.transform = "translate(-" + (1428 * (current_page - 1))+ "px)"
			document.getElementById("movieList").style.transitionProperty = "transition-property: transform;";
			document.getElementById("movieList").style.transitionDuration = "0.5s";
			console.log(current_page);
			
		}
	});
});