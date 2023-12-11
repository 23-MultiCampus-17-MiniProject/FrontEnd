<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
let today = new Date();
let hour = today.getHours();
let oneDay = 86400000;
let numberDate = "";
let yesterday = "";

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
$(document).ready(function(){
	
	$.ajax({
		url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		method: "GET",
		dataType: 'json',
		data:{
			key: "f0b5971de85c22ab8010d759968eef23",
			itemPerPage: "10",
			targetDt: numberDate
		}
		
	}).done(function(msg){
		
		let result = "";
		for(let i=0; i<msg.boxOfficeResult.dailyBoxOfficeList.length; i++){
			let short_url = msg.boxOfficeResult.dailyBoxOfficeList[i];
			
			result += "<b>" + i + "</b>"
			result += "<b>영화제목: " + short_url.movieNm + "</b>"
			result += ", <b>영화순위: " + short_url.rank + "</b>"
			result += ", <b>영화코드: " + short_url.movieCd +"</b><br>"
		}
		$("#result").append(result);
	});
	
	$.ajax({
		url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
		method: "GET",
		dataType: 'json',
		data:{
			key: "f0b5971de85c22ab8010d759968eef23",
			movieCd: "20235360"
			
		}
		
	}).done(function(msg){
		let short_url = msg.movieInfoResult.movieInfo;
		let result = "";
		for(let i=0; i<short_url.audits.length; i++){
			
			result += "<b>배우: " + short_url.audits[i].watchGradeNm + "</b><br>";
			
		}
		$("#result").append(result);
	});
	
	
});
</script>
<body>
<div id="result"></div>
</body>
</html>