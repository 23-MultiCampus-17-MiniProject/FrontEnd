<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MultiCinema</title>
<link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<style>
	#contents_movie_detail{
		width: 790px;
		height: 500px;
		margin: 0 auto;
		text-align: left;
		padding: 0 5px 0 5px;
		
	}
	#movie_poster{
		height: 450px;
		width: 300px;
		float: left;
		padding:25px 30px 25px 10px;
	}
	#movie_poster > img{
		height: 100%;
		width: 100%;
		border-radius: 5px;
	}
	#movie_info{
		float: left;
		margin-top: 55px;
		width: 450px;
	}
	#movie_info_synopsis{
		height: 200px;
		width: 440px;
		overflow-x: hidden;
		overflow-y: scroll;
	}
	#movie_info_ticketing{
		width: 200px;
		height: 50px;
		border: 1px solid rgb(254, 228, 1);
		background-color: rgb(254, 228, 1);
		border-radius: 5px;
		text-align: center;
		margin: 20px;
	}
	
	#movie_info_ticketing a{
		text-decoration: none;
		color: black;
		line-height: 50px;
	}
	
	#movie_info_ticketing div{
		width: 100%;
		height: 100%;
	}
	#contents_movie_comments{
		border-top: 1px solid  rgb(0,0,0,0.2);
		text-align: left;
		width: 800px;
		margin: 0 auto;
	}
	.comments > div{
		margin: 3px;
	}
	.comments {
		border-top: 1px solid  rgb(0,0,0,0.2);
	}
	.comments_date{
		margin: 5px;
		font-size: 14px;
	}
	.comments_contents{
		font-weight: 900;
	}
	#comments_sort_btn{
		text-align: right;
	}
	.sort_btn{
		border: 0;
		cursor: pointer;
		font-size: 15px;
		background-color: white;
	}
	#sort_date_btn{
		border-right: 1px solid rgb(0,0,0,0.2);
	}
	#write_comments{
		height: 70px;
		width:800px;
		margin-top:30px;
	}
	#write_comments > input{
		height: 46px;
		width:500px;
		margin-right: 30px;
	}
	#write_comments > button{
		margin-left:10px;
		border: 1px solid rgb(254, 228, 1);
		background-color: rgb(254, 228, 1);
		cursor: pointer;
		border-radius: 5px;
		width:100px;
		height: 50px;
	}
	
</style>

<body>
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>
<!-- body start -->

<div id="contents">
	<div id="contents_movie_detail">
		<div id="movie_poster">
			<img src="images/movie_poster/더_마블스.jpg" alt="더_마블스.jpg">
		</div>
		<div id="movie_info">
			<div id="movie_info_title">
				<h1>더 마블스</h1>
			</div>
			<div id="movie_info_synopsis">
				<p>
				</p>
			</div>
			<div id="movie_info_ticketing">
				<a href="./timetable_movie.html?movie=">
					<div>예매하기</div>
				</a>
			</div>
		</div>
	</div>
	<div id="contents_movie_comments">
		<h2>한줄평</h2>
		<div id="comments_sort_btn">
			<button class = "sort_btn" id="sort_date_btn">날짜 별로 정렬</button><button class = "sort_btn" id="sort_like_btn">좋아요 순으로 정렬</button>
		</div>
		<div id="write_comments">
			<input type="text" placeholder="최대 50글자를 입력해주세요" maxlength="50">평점<select><option>0</option><option>0.5</option><option>1</option><option>1.5</option><option>2.0</option><option>2.5</option><option>3.0</option><option>3.5</option><option>4.0</option><option>4.5</option><option>5.0</option></select>
			<button id="write_btn">쓰기</button>
		</div>
		<div id="movie_comments_list">
	<!--		<div class="comments" id=${my_comments}>
					<div class="comments_id">
						${comments_obj_parameter.id}
					</div>
					<div class="comments_date">
						${comments_obj_parameter.date.toLocaleString()}
					</div>
					<div>
						<span>
							평점${comments_obj_parameter.score}
						</span>
						<span>
							좋아요<img src="images/like.png" class='like_btn' id='${idx}' title='${comments_obj_parameter.serial_num}'> ${comments_obj_parameter.like}
						</span>
						<span style="${hideOrNot}" id="${my_comments_modify}">
							<button id="${my_comments_modify_btn}">수정</button>
							<span style='visibility: hidden'>
								<input type='text' id='${my_modified_comments}' placeholder='수정할 내용을 입력해주세요' maxlength="50">
								평점<select><option>0</option><option>0.5</option><option>1</option>
									<option>1.5</option><option>2.0</option><option>2.5</option><option>3.0</option>
									<option>3.5</option><option>4.0</option><option>4.5</option><option>5.0</option>
								</select>
								<button id='${modify_confirm}'>확인</button><button id='modify_cancel'>취소</button>
							</span>
						</span>
						<button style="${hideOrNot}" id="${my_comments_delete_btn}">삭제</button>
					</div>
					<div class="comments_contents">
						${comments_obj_parameter.comments}
					</div>
				</div>
				-->
		</div>
		<button id="more_comments_btn"></button>
	</div>


</div>


<!-- body end -->
<div id="footerInput"></div>
</body>
<script>
	onload = function() {
		fetch('signoutheader.html')
		.then(response => response.text())
		.then(data => {
			document.getElementById('headerInput').innerHTML = data;
		}).catch(error => {
			console.error('Header could not be loaded', error);
		});
		window.sleep
	}
</script>
<script>
	
onload = function() {
	
	let movie_poster_frame = document.querySelector("#movie_poster > img");
	let movie_info_title = document.querySelector("#movie_info_title > h1");
	let movie_info_synopsis = document.querySelector("#movie_info_synopsis > p");
	let movie_info_ticketing_url = document.querySelector("#movie_info_ticketing > a");
	
	let receive_data = decodeURI(location.href.split("?")[1].split("=")[1]);
	
	function _ToSpace(str){
		let result = str.replace("_", " ");
		while(result.indexOf("_") != -1){
			let tmp = result.replace("_", " ");
			result = tmp;
		}
		return result;
	}
	
	function spaceTo_(str){
		let result = str.replace(" ", "_");
		while(result.indexOf(" ") != -1){
			let tmp = result.replace(" ", "_");
			result = tmp;
		}
		return result;
	}
	
	
	let movie_arr = [{title:"더 마블스", score:90, grade:15, synopsis:`<b>2023년, 캡틴 마블이 돌아온다!</b>
					<br>강력한 힘으로 은하계를 수호하는 최강 히어로 캡틴 마블 ‘캐럴 댄버스’
					<br>캡틴 마블의 오랜 친구의 딸이자, 빛의 파장을 조작하는 히어로 ‘모니카 램보’
					<br>최애 히어로 캡틴 마블의 열렬한 팬인 미즈 마블 ‘카말라 칸’
					<br><br>캡틴 마블에 대한 복수를 꿈꾸는 냉혹한 크리족 리더 ‘다르-벤’의 영향으로
					<br>세 명의 히어로는 능력을 사용할 때마다 서로의 위치가 뒤바뀌게 된다.
					<br><br>뜻하지 않게 우주와 지구를 넘나들게 되는 예측 불가하고 통제 불가한 상황 속,
					<br>‘다르-벤’은 지구를 포함해 캡틴 마블이 고향이라고 부르는
					<br>수많은 행성을 모두 파멸시키려 하고,
					<br>이를 저지하기 위해 모인 팀 ‘마블스’는 하나로 힘을 모으는데…
					<br><br><b> 함께, 더 높이! 더 멀리! 더 빨리!<br>역대급 파장을 일으킬 마블의 NEW 팀업이 시작된다! </b>` },
					
					{title:"이웃집 토토로", score:80, grade:18, synopsis:`사츠키와 메이는 어머니의 병으로 인해 아버지와 
					도시에서 시골로 이사를 오게 된다.<br>
					언니인 사츠키가 학교에 간 사이, 혼자 숲속에서 놀던 메이는 우연히 도토리를 지고 가던 토토로를 발견해 따라간다.<br>
					이후 사츠키와 메이는 토토로와 함께 숲속에서 즐거운 시간을 보낸다.<br>
					시간이 지난 어느 날, 병원에서 위급한 소식이 들려 오자 아버지는 급히 버스를 타고 어머니 병원으로 향하는 한편, 
					자신도 엄마한테 가겠다고 떼쓰던 메이가 행방불명된다.<br>`},
					
					{title:"암살", score:85, grade:12, synopsis:`<b>1933년, 조국이 사라진 시대</b><br><br>
					대한민국 임시정부는 일본 측에 노출되지 않은 세 명을 암살 작전에 지목한다. <br>
					독립군 저격수 안옥윤, 신흥무관학교 출신 속사포, 폭탄 전문가 황덕삼! <br>
					김구의 두터운 신임을 받는 임시정부 경무국 대장 염석진은 이들을 찾아 나서기 시작한다. <br>
					암살단의 타겟은 조선주둔군 사령관 카와구치 마모루와 친일파 강인국.<br>
					 한편, 누군가에게 거액의 의뢰를 받은 청부살인업자 하와이 피스톨이 암살단의 뒤를 쫓는데...<br><br>
					<b>친일파 암살작전을 둘러싼 이들의 예측할 수 없는 운명이 펼쳐진다!</b>`},
					
					{title:"범죄도시2", score:65, grade:"ALL", synopsis: `<b>“느낌 오지? 이 놈 잡아야 하는 거”</b><br><br>
					가리봉동 소탕작전 후 4년 뒤,
					금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.<br><br>
					괴물형사 ‘마석도’(마동석)와 ‘전일만’(최귀화) 반장은 현지 용의자에게서 수상함을 느끼고,
					그의 뒤에 무자비한 악행을 벌이는 ‘강해상’(손석구)이 있음을 알게 된다.<br><br>
					‘마석도’와 금천서 강력반은 한국과 베트남을 오가며
					역대급 범죄를 저지르는 ‘강해상’을 본격적으로 쫓기 시작하는데...<br><br>
					<b>나쁜 놈들 잡는 데 국경 없다!<br>
					통쾌하고 화끈한 범죄 소탕 작전이 다시 펼쳐진다!</b>`},
					
					{title:"1917", score:75, grade:"ALL" ,
					 synopsis:`<b>두 명의 병사, 하나의 임무!<br>
						그들이 싸워야 할 것은 적이 아니라 시간이었다!</b><br><br>
						제1차 세계대전이 한창인 1917년.<br>
						독일군에 의해 모든 통신망이 파괴된 상황 속에서
						영국군 병사 '스코필드'(조지 맥케이)와 '블레이크'(딘-찰스 채프먼)에게 하나의 미션이 주어졌다.<br>
						<br>
						함정에 빠진 영국군 부대의 수장 '매켄지' 중령(베네딕트 컴버배치)에게
						'에린무어' 장군(콜린 퍼스)의 공격 중지 명령을 전하는 것!<br><br>
						
						둘은 1,600명의 아군과 '블레이크'의 형(리차드 매든)을 구하기 위해
						전쟁터 한복판을 가로지르며 사투를 이어가는데…`}];
	
	
	
	(function() {
		let movie_index;
		for (let i = 0; i < movie_arr.length; i++) {
			if (_ToSpace(receive_data) == movie_arr[i].title) {
				movie_index = i;
			}
		}
		movie_poster_frame.src = "images/movie_poster/" + spaceTo_(movie_arr[movie_index].title) + ".jpg";
		movie_info_title.innerHTML = movie_arr[movie_index].title;
		movie_info_synopsis.innerHTML = movie_arr[movie_index].synopsis;
		movie_info_ticketing_url.href += spaceTo_(movie_arr[movie_index].title);
		})();
	
//**********************************구분선**********************************************//
//**********************************구분선**********************************************//

	let login_user = {
		id: "Test_ID",
		comments_like:[],
		my_idx: -1
	}
	
	var serial_num = 0; // Comments 각 객체들의 고유한 번호
	
	function Comments(id, comments, movie_title, score){
		
		this.serial_num = serial_num++;
		this.id = id;
		this.date = new Date();
		this.like = 0;
		this.comments = comments;
		this.movie_title = movie_title;
		this.score = score;
	}
	
	let comments_obj_arr=[];
	
	function dummy_comments_create(num){
		for(let i = 0; i<num; i++){
			comments_obj_arr.push(new Comments("랜덤아이디"+i,"랜덤코멘트"+"랜덤코멘트"+"랜덤코멘트"+"랜덤코멘트"+i,"영화제목", parseInt(Math.random()*5)));
		}
		
	}
	dummy_comments_create(20);
	
	//하나의 한줄평 게시물 생성
	let movie_comments_list = document.getElementById("movie_comments_list");
	function comments_list_create(comments_obj_parameter, idx) {

		let hideOrNot = "visibility: hidden";
		let my_comments_modify = "";
		let my_comments_modify_btn = "";
		let my_comments = ""
		let my_comments_delete_btn = "";
		let my_modified_comments = "";
		let modify_confirm = "";

		//한줄평 게시물이 가진 유저아이디가 로그인한 유저의 아이디와 일치하는 경우
		//그 게시물에만 수정 삭제 태그들을 넣어주고 숨김처리
		//좋아요 id엔 게시물의 객체배열의 인덱스, title엔 고유번호 넣어줌으로써
		//수정 삭제시엔 객체배열의 인덱스 사용해서 빠르게 삭제
		//좋아요 클릭시 고유번호와 로그인 유저의 프로퍼티에 존재하는 좋아요 누른 게시물의 고유번호 대조
		//인덱스는 삭제 생성등의 일이 있을 때 재랜더링하면서 다시 설정
		if (comments_obj_parameter.id == login_user.id) {
			hideOrNot = "visibility: visible";
			my_comments_modify = "my_comments_modify";
			my_comments_modify_btn = "my_comments_modify_btn";
			my_comments = "my_comments";
			my_comments_delete_btn = "my_comments_delete";
			my_modified_comments = "my_modified_comments";
			modify_confirm = "modify_confirm";
			login_user.my_idx = idx;
			movie_comments_list.innerHTML += `
				<div class="comments" id=${my_comments}>
					<div class="comments_id">
						${comments_obj_parameter.id}
					</div>
					<div class="comments_date">
						${comments_obj_parameter.date.toLocaleString()}
					</div>
					<div>
						<span>
							평점${comments_obj_parameter.score}
						</span>
						<span>	
							좋아요<img src="images/like.png" class='like_btn' id='${idx}' title='${comments_obj_parameter.serial_num}'> ${comments_obj_parameter.like}
						</span>
						<span style="${hideOrNot}" id="${my_comments_modify}">
							<button id="${my_comments_modify_btn}">수정</button>
							<span style='visibility: hidden'>
								<input type='text' id='${my_modified_comments}' placeholder='수정할 내용을 입력해주세요' maxlength="50">
								평점<select><option>0</option><option>0.5</option><option>1</option>
									<option>1.5</option><option>2.0</option><option>2.5</option><option>3.0</option>
									<option>3.5</option><option>4.0</option><option>4.5</option><option>5.0</option>
								</select>
								<button id='${modify_confirm}'>확인</button><button id='modify_cancel'>취소</button>
							</span>
						</span>
						<button style="${hideOrNot}" id="${my_comments_delete_btn}">삭제</button>
					</div>
					<div class="comments_contents">
						${comments_obj_parameter.comments}
					</div>
				</div>`;
			
		} else {
			movie_comments_list.innerHTML += `
				<div class="comments" >
					<div class="comments_id">
						${comments_obj_parameter.id}
					</div>
					<div class="comments_date">
						${comments_obj_parameter.date.toLocaleString()}
					</div>
					<div>
						<span>
							평점${comments_obj_parameter.score}
						</span>
						<span>
							좋아요<img src="images/like.png" class="like_btn" id='${idx}' title='${comments_obj_parameter.serial_num}'>${comments_obj_parameter.like}
						</span>
					</div>
					<div class="comments_contents">
						${comments_obj_parameter.comments}
					</div>
				</div>`;
			
			
		}
	}
	//리뷰 게시물 하나 만드는 메서드를 코멘트 객체 배열의 크기만큼 반복문
	function render_comments_list(){
		for(let i = 0; i < comments_obj_arr.length; i++){
			comments_list_create(comments_obj_arr[i], i);
		}
	}
	
	//수정 삭제 추가 등의 이벤트가 생길 때 모두 지우고 다시 랜더링+이벤트등록
	function re_render_comments_list(){
		//리스트 전부 지우고 새로 불러오기
		movie_comments_list.innerHTML = "";
		render_comments_list();
		//좋아요 이벤트 코멘트 읽고쓰는 이벤트 다시 등록해주기
		like_add_event();
		//my_idx 값이 -1인데도 쓰려고하면 오류가 나옴 => if
		if(login_user.my_idx != -1){
			comments_CD();
		}
		
	}
	
	//최초 게시물의 생성 및 이벤트 등록
	render_comments_list();
	like_add_event();
	if(login_user.my_idx != -1){
			comments_CD();
		}
		
	//글쓰기
	let comments_score = document.querySelector("#write_comments > select");
	let write_btn = document.getElementById("write_btn");
	write_btn.addEventListener("click",function () {
		console.log("write_btn 동작")
		if(login_user.my_idx >= 0){
			alert("한줄평을 이미 작성하셨습니다");
		}else{
			alert("완료되었습니다");
			comments_obj_arr.push(
				new Comments(login_user.id,
				document.querySelector("#write_comments > input").value,
				receive_data, comments_score.value));
				//receive_data: 이 페이지로 받아온 영화제목
			re_render_comments_list();
			//글쓰기 후 코멘트 객체 배열의 마지막 인덱스를 my_idx로 설정
			login_user.my_idx = comments_obj_arr.length - 1;
		}
	});
	
	//수정 및 삭제 버튼의 이벤트 처리
	function comments_CD(){
		let my_comments_modify_score = document.querySelector("#my_comments_modify select");
		let my_comments_modify_btn = document.getElementById("my_comments_modify_btn");
		let modify_onoff = document.querySelector("#my_comments_modify > span");
		let my_modified_comments = document.getElementById("my_modified_comments")
		
		my_comments_modify_btn.addEventListener("click", function () {
			//숨겨져 있던 input 드러내기 및 수정버튼 숨기기
			my_comments_modify_btn.style = 'visibility: hidden';
			modify_onoff.style = 'visibility: visible';
			//수정내용 입력 후 버튼클릭시 이벤트 처리
			my_comments_modify_score.value
			my_modified_comments.value
		});
		
		document.getElementById("modify_confirm").onclick = () => {
				alert("수정되었습니다")
				//다시 숨기기
				modify_onoff.style = 'visibility: collapse'
				//코멘트객체의 코멘트 값 및 점수 변경
				comments_obj_arr[login_user.my_idx].comments = my_modified_comments.value;
				comments_obj_arr[login_user.my_idx].score = my_comments_modify_score.value;
				re_render_comments_list();
				
			}
			//수정 취소 버튼 이벤트 처리
			document.getElementById("modify_cancel").onclick = () => {
				modify_onoff.style = 'visibility: hidden';
				my_comments_modify_btn.style = 'visibility: visible';
			}
			//삭제 버튼의 이벤트 처리
		document.getElementById("my_comments_delete").addEventListener("click", () => {

			if (confirm("삭제하시겠습니까?") == true) {
				alert("삭제되었습니다");
				comments_obj_arr.splice(login_user.my_idx, 1);
				login_user.my_idx = -1;
				re_render_comments_list();
			}
		});
	}
	
	//좋아요 +1 한 사람당 한번씩만 줄 수 있게
	function like_add_event(){
		let like_btn = document.querySelectorAll(".like_btn");
		for(let i = 0; i < like_btn.length; i++){
			like_btn[i].addEventListener("click", function(e){
				let target_serial_num = e.target.getAttribute("title");
				let target_idx_num = e.target.getAttribute("id");
				let flg = true;
				
				//내가 준 코멘트의 고유번호와 이벤트가 발생한 코멘트 객체의 고유번호 대조
				for(let j =0; j < login_user.comments_like.length; j++){
					if(target_serial_num == login_user.comments_like[j]){
						flg = false;
						alert("좋아요는 게시물 당 한번만 가능합니다");
						break;
					}
				}
				
				if(flg == true){
					comments_obj_arr[target_idx_num].like += 1;
					login_user.comments_like.push(comments_obj_arr[target_idx_num].serial_num);
					re_render_comments_list()
				}
			
			});
		}
	}
	
	//정렬
	let sort_date_btn = document.getElementById("sort_date_btn");
	let sort_like_btn = document.getElementById("sort_like_btn");
			
	let sort_date_swicth = true;
	let sort_like_swicth = true;
	
	//시간 순으로 정렬
	function sort_date(){
		if(sort_date_swicth){
			comments_obj_arr.sort((a,b) => a.date - b.date);
			sort_date_swicth = !sort_date_swicth;
		}else{
			comments_obj_arr.sort((a,b) => b.date - a.date);
			sort_date_swicth = !sort_date_swicth;
		}	
	}
	
	function sort_like(){
		if(sort_date_swicth){
			comments_obj_arr.sort((a,b) => a.like - b.like);
			sort_date_swicth = !sort_date_swicth;
		}else{
			comments_obj_arr.sort((a,b) => b.like - a.like);
			sort_date_swicth = !sort_date_swicth;
		}	
	}
	sort_date_btn.onclick = ()=>{
		sort_date();
		re_render_comments_list();
		console.log("작동");
	}
	sort_like_btn.onclick = ()=>{
		sort_like();
		re_render_comments_list();
		console.log("작동");
	}
			
			
			
}
</script>

</html>