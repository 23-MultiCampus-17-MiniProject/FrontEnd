<%@page import="java.util.HashMap"%>
<%@page import="com.mc.multicinema.movieinfo.dto.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mc.multicinema.moviecomment.dto.MovieCommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MultiCinema</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/movie_detail.css">
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
<script>
$(document).ready(function(){
	$("#write_btn").on('click', function(e){
		
		if("${login_user_id}" == ""){
			if(confirm("한줄평은 로그인 후 등록 가능합니다. 로그인하시겠습니까?") == true){
				e.preventDefault();
				location.href = "login";//이 부분은 나중에 확인 확인이든 취소든 뭘 눌러도 오류뜸 왜?
			}
		}else{
			e.submit();
		}
	});
	
	let movie_comments_list = document.getElementById("movie_comments_list");
			
	//******************************   평점   ****************************************//
		let stars = document.querySelectorAll(".stars");
		let click_star_value = 0;
		let flg = false;
		
		function addEvent(start){
			stars = document.querySelectorAll(".stars");
			if(start == null){
				start = 0;
			}
			for(let i = start; i < stars.length; i++){
				
				stars[i].addEventListener("mouseenter", () =>  lightenStar(i));
				stars[i].addEventListener("mouseleave", () => darkenStar(start, i));
			}
		}	
		
		function addClickEvent(){
			
			stars = document.querySelectorAll(".stars");
			for(let i = 0; i < stars.length; i++){
				stars[i].addEventListener("click", (e) => {
					//같은별 클릭했을 경우
					if(click_star_value == stars[i].value){
						click_star_value = 0;
						e.target.checked = false;
					//다른 별 클릭했을 경우
					}else{
						click_star_value = stars[i].value;
						for(let j = click_star_value; j < stars.length; j++){
							stars[j].style.content = "url(resources/images/1emptystar.png)";
						}
					}
				});
			}
		}
		
		function lightenStar(end){
			
			for(let j = 0; j <= end; j++){
				stars[j].style.content = "url(resources/images/1star.png)";
			}
		}

		function darkenStar(start, end){
			for(let j = start; j <= end; j++){
				if(click_star_value <= j){
					stars[j].style.content = "url(resources/images/1emptystar.png)";
				}
			}
		}
		addEvent();
		addClickEvent();
		
		let btn_left = document.getElementById("slide_btn_left");
		let btn_right = document.getElementById("slide_btn_right");
		var current_page = 1;
		
		<% 
		HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)request.getAttribute("map");
		ArrayList<String> stillcutlist = map.get("stillcutlist");
		ArrayList<String> actorlist = map.get("actorlist");
		%>
		let stillcutlistlength = (Number(<%=stillcutlist.size() %>) + 2) * 180;
		$("#still_cut_slider").attr("style","width: "+ stillcutlistlength + "px");
		var end_page = Math.ceil(stillcutlistlength / 800);
		btn_right.addEventListener('click', function(){
			if(end_page != current_page){
				document.getElementById("still_cut_slider").style.transform = "translate(-" + (800 * current_page) + "px)"
				document.getElementById("still_cut_slider").style.transitionProperty = "transition-property: transform;";
				document.getElementById("still_cut_slider").style.transitionDuration = "0.5s";
				current_page++;
				console.log(current_page);
				console.log("endpage:" +end_page);
			}
		});
		btn_left.addEventListener('click', function(){
			if(current_page != 1){
				current_page--;
				document.getElementById("still_cut_slider").style.transform = "translate(-" + (800 * (current_page - 1))+ "px)"
				document.getElementById("still_cut_slider").style.transitionProperty = "transition-property: transform;";
				document.getElementById("still_cut_slider").style.transitionDuration = "0.5s";
				console.log(current_page);
				
			}
		});
		
});
</script>
<script src="resources/script/movie_detail_1.js"></script>
<body>
<div id="headerInput"></div>
<!-- body start -->
<%
String message = (String)session.getAttribute("message");
if(message != null){
%>	
	<script>alert("${message}");</script>
<%
	session.removeAttribute("message");
}
%>

<%MovieDTO moviedto = (MovieDTO)request.getAttribute("moviedto"); %>

<input type="hidden" id="hidden_login_user_id" value="${login_user_id}">
<input type="hidden" id="hidden_movie_cd" value="${movie_cd}">
<input type="hidden" id="hidden_login_user_key" value="${login_user_key}">
<div id="contents">
	<div id="contents_movie_detail">
		<div id="movie_datail_upper">
			<div id="movie_poster">
				<img src="<%=moviedto.getMovie_img_src() %>" alt="더_마블스.jpg">
			</div>
			<div id="movie_info">
				<div id="movie_info_title">
					<h1><%=moviedto.getMovie_title() %></h1>
				</div>
				<div>
					<h4>감독: <%=moviedto.getMovie_director() %></h4>
					<h4>배우: 
					<%
					for(int i = 0; i<actorlist.size(); i++){
						if(i == actorlist.size()-1){
							%><%=actorlist.get(i) %><%
						}else{
							%><%=actorlist.get(i) %>, <%
						}
					%> <%} %></h4>
					<h4 id="movie_info_etc"><span><%=moviedto.getMovie_genre() %></span><span><%=moviedto.getMovie_makeNt() %></span><span><%=moviedto.getMovie_showTm() %>분</span><span><%=moviedto.getMovie_openDt().split(" ")[0] %></span></h4>
				</div>
				<div id="movie_info_synopsis">
					<p><%=moviedto.getMovie_spec() %>
					</p>
				</div>
				<div id="movie_info_ticketing">
					<a href="/ticketing.html?movie=">
						<div>예매하기</div>
					</a>
				</div>
			</div>
		</div>
		
		<div id="still_cut_list">
			<div id="still_cut_slider">
		<%
		
		for(int i = 0; i < stillcutlist.size(); i++){ %>
			<a href="<%=stillcutlist.get(i) %>"><img src="<%=stillcutlist.get(i) %>" alt="<%=stillcutlist.get(i) %>"></a>
		<%} %>
			</div>
		</div>
		
		<button id="slide_btn_left"> < </button><button id="slide_btn_right"> > </button>
		
	</div>
	<div id="contents_movie_comments">
		<h2>한줄평</h2>
		<div id="comments_sort_btn">
			<button class = "sort_btn" id="sort_date_btn">날짜 별로 정렬</button><button class = "sort_btn" id="sort_like_btn">좋아요 순으로 정렬</button><button class = "sort_btn" id="sort_score_btn">평점 순으로 정렬</button>
		</div>
		<form action="moviedetail" method="post">
		<div id="write_comments">
			<div id="rating_star">
				<input type="radio" name="comment_score" id="1star" value="1" class="stars">
				<input type="radio" name="comment_score" id="2star" value="2" class="stars">
				<input type="radio" name="comment_score" id="3star" value="3" class="stars">
				<input type="radio" name="comment_score" id="4star" value="4" class="stars">
				<input type="radio" name="comment_score" id="5star" value="5" class="stars">
			</div>
			<div>
				
			</div>
			<input id="writing_commentbox" type="text" name="comment_content" placeholder="최대 50글자를 입력해주세요" maxlength="50">
			<input type="hidden" id="movie_cd" name="movie_cd" value="${movie_cd }"><!-- 영화정보같이 -->
			<input type="hidden" id="user_key" name="user_key" value="${login_user_key }">
			<button id="write_btn">쓰기</button><!-- 버튼 이벤트 구현 -->
		</div>
		</form>
		<div id="movie_comments_list">
			
			<% ArrayList<MovieCommentDTO> commentlist= (ArrayList<MovieCommentDTO>)request.getAttribute("commentlist");
			String login_user_id = (String)session.getAttribute("login_user_id");
			if(login_user_id == null){
				login_user_id = "";
			}
			for(MovieCommentDTO dto : commentlist){ 
				//if(로그인 유저의 키 == dto.user_key)
			%>
				<div class="comments" id='<%=dto.getComment_num() %>'>
					<div>
						<div class="comments_id" style="display: inline-block">
							<%=dto.getUser_id() %>
						</div>
						<span>
							평점
						</span>
						<span class="comment_score">
							<%=dto.getComment_score() %>
						</span>
						<div class="like_btn"  style="display: inline-block">
							<img src="resources/images/like.png"  ><span class="comment_like"><%=dto.getComment_like() %></span>
						</div>
					</div>
					
					<div>
						<div class="comments_date" style="display: inline-block">
							<%=dto.getComment_write_date() %>
						</div>
						<%if(login_user_id.equals(dto.getUser_id())){
							%>
						<div id="my_comment_modify_part" style="display: inline-block">
							<form id="updateform" action="updatemoviecomment" method="post" style="display: none">
								<input type="hidden" name="comment_num" value="<%=dto.getComment_num() %>">
								<input type="hidden" name="movie_cd" value="<%=dto.getMovie_cd() %>">
								<select id="update_score" name="comment_score">
									<option value="0">0
									<option value="1">1
									<option value="2">2
									<option value="3">3
									<option value="4">4
									<option value="5">5
								</select>
								<textarea id="updateform_content" name="comment_content" ></textarea>							
								<button id="my_comments_modify_confirm_btn">수정확인</button>
							</form>
								<button id="my_comments_modify_cancel_btn" style="display: none">취소</button>
								<button id="my_comments_modify_btn">수정</button>
							<form id="deleteform" action="deletemoviecomment" method="post" style="display: inline-block">
								<input type="hidden" name="comment_num" value="<%=dto.getComment_num() %>">
								<input type="hidden" name="movie_cd" value="<%=dto.getMovie_cd() %>">
								<button id="my_comments_delete_btn">삭제</button>
							</form>
						</div>
						<%}%>
					</div>
					<div class="comments_contents">
						<%=dto.getComment_content() %>
					</div>
					
				</div>
			<%} %>
		</div>
		<button id="more_comments_btn">더보기 버튼</button>
	</div>


</div>


<!-- body end -->
<div id="footerInput"></div>
</body>




</html>