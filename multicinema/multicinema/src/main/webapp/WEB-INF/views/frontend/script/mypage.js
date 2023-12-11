/**
 * 
 */
import{movie_list,user_list,history_list,review_history_list,User,Movie,Movie_watched_history,Review_history} from "./dummyObject.js";

 window.addEventListener('DOMContentLoaded', function()
	{
	// 저는 마이페이지 화면을 보여드려야해서, 현재 로그인 된 유저가 dummyObject.js에 있는 user_list의 첫번째 user로 가정했습니다.
	let user = user_list[0];
	// 나중에 회원 정보 수정시 새 창을 띄우기 위한 변수. 미리 전역변수 선언
	let authentication;
	// 예매내역/ 리뷰내역을 다섯개씩 끊은 table을 만드는 html 선언문을 담은 리스트. 미리 전역변수 선언
	let divided_history_table_list = [];
	let divided_review_table_list = []
	
	
	let reserv_detail = document.querySelector("#myPage_navigater > #reserve_detail");
	let info_change = document.querySelector("#myPage_navigater > #info_change");
	let my_review = document.querySelector("#myPage_navigater > #my_review");
	// 내용들이 담길 부분
	let main_page = document.querySelector("#myPage_main");
	
	// 예매 내역 누른 후
	reserv_detail.addEventListener("click", show_reserv_detail);

	// 회원 정보 수정 누른경우
	info_change.addEventListener("click",show_info_change);	
	
	// 작성 리뷰 게시물 누른 경우
	my_review.addEventListener("click", show_myReview);
	
	// 아직 미구현한 부분
	// 1. 영화 제목을 누르면 해당 영화 정보로 가는것

	function show_reserv_detail(){
	main_page.innerHTML = `<div class=\"myPage_main_header\">내 예매 내역</div> <div id=\"my_reserve_table\"></div>
	<div id=\"table_link\"></div>`;
	// 예매 내역 테이블을 담을 곳
	let my_reserve_table = document.querySelector("#my_reserve_table");
	//  테이블 밑에 1) 2) 이런식으로 다음 목록으로 가는 링크 담을곳
	let table_link = document.querySelector("#table_link");
	// 모든 사용자들의 영화 시청 기록이 있는 history_list에서 지금 user가 본 history를 뽑아오는것
	let my_history_list = [];
	// for 1
	for(let i = 0; i<history_list.length ;i++ ) {
		// if 1
		if(history_list[i].user == user){
			my_history_list.push(history_list[i]);
		} // if 1
	}// for 1
	
	// 사실 db에서 오름차순 관리해주면 그냥 가져와도 될것 같기는 한데...
	// 혹시모르니 date순으로 내림차순 정렬 (최신이 위로)
	function sort_by_date(list){
		const sorted_list = list.sort(function(a,b) {
			return new Date(a.watched_date).getTime()- new Date(b.watched_date).getTime();
		}).reverse();// sort
		return sorted_list;
	} // sort_by_date()
	my_history_list = sort_by_date(my_history_list);
	make_history_table(my_history_list);
	
	// 처음 기본화면은 맨위에꺼 보여주기
	my_reserve_table.innerHTML = divided_history_table_list[0];
	
	let table_links_lists = document.querySelectorAll(".table_link");
	
	// 각각의 밑에있는 숫자에 테이블로 가는 링크 걸어주기
	// for4
	for (let i = 0; i <table_links_lists.length; i++){
		table_links_lists[i].onclick = function(){
			my_reserve_table.innerHTML = divided_history_table_list[i];
		}
	}// for4
	
	
	// 예매내역 리스트를 가지고 화면상에 테이블을 구성해주는 html문을 divided_history_table_list에 담아주는 함수.
	// 예매내역 리스트 안에는 Movie_watched_history객체가 담겨있고
	// 프로퍼티:  user (User 객체) / movie (Movie 객체) / watched_date (Date 객체)
	function make_history_table(list){
		// table에 예매 내역을 5개씩 보여줄꺼고 넘어가는것은 다음 table에서 보여줄 것임
		let num_per_table = 5;
		let history_table_page_count = Math.floor(list.length / num_per_table) + 1;
	
		// table link 에 history_table_page_count 개 만큼 이동할수 있는만큼 span 만들어 주기
		for(let i = 0; i < history_table_page_count; i++){
			table_link.innerHTML += `<span class="table_link" id = "to_${i}_history_table">${(i+1)}<span>`;
		}
		
		// for2
		for(let j = 0 ; j < history_table_page_count; j++){
			let history_table ="";
			history_table += "<table id=\"history_table\">";
			// 반복문 사용해서 테이블 만들어주기
			// for 3
			for (let i = 0; i < Math.min(num_per_table,list.length) ;i++){
				history_table+="<tr><td><img src =\""+list[i].movie.url+"\"width =70px, height = 70px></td><td>"
				+list[i].movie.name+"</td><td>"+list[i].watched_date.toLocaleDateString()+"</td></tr>";	
			}// for 3
			history_table += "</table>";
			divided_history_table_list.push(history_table);
			list.splice(0,5);
		}// for 2
	} // make_history_table()
	} //  show_reserv_detail()
	
	// 아직 미구현 부분
	// 1) 회원정보수정 여러번 누르면 안된다..
	function show_info_change(){
		// 새로운 로그인 창 열기
		main_page.innerHTML = "";
		
		if(!authentication || authentication.closed){
			authentication = window.open("authentication.html","정보확인","width=600, height=600, top=200, left=200");
		}
		else{
			authentication.close();
			authentication = window.open("authentication.html","정보확인","width=600, height=600, top=200, left=200");
		}
		
		authentication.onload = function(){
			let login_button = authentication.document.querySelector("#login_button");
			
			// 새로 뜬 로그인 창의 로그인 버튼 누르면 지금 사용중인 유저의 정보와 같은지 확인
			login_button.addEventListener("click", check_authentication);
			
			function check_authentication(){
				// 로그인 창에 기입된 정보가 틀렸을시 맞을때까지 반복
				
				// 로그인 창에 기입한 아이디
				let input_userid = authentication.document.getElementById("userid").value;
				// 로그인 창에 기입한 비밀번호
				let input_password = authentication.document.getElementById("password").value;
				// 로그인 창에서 에러 메세지가 뜰 위치
				let errmsg_login = authentication.document.getElementById("errmsg_login");
				// 기입한 id와 password가 현재 로그인 한 user의 id, password와 같으면, 로그인 창을 닫고,  다음 정보 보여주기
				//if 1
				if (input_userid == user.id && input_password == user.password) {
					authentication.close();
					info_change_after_authentication();
					
					function info_change_after_authentication(){
						
						// 마이페이지에 이메일 변경할지 비밀번호 변경할지 선택하는 화면 띄우기
						main_page.innerHTML = "<div class=\"myPage_main_header\"> 회원정보 변경 </div>";
						main_page.innerHTML += `<div class="change_button" id="change_email"> 이메일변경 </div>
						<div class="change_button" id="change_password"> 비밀번호 변경 </div>`;

						let change_email_box = document.querySelector("#change_email");
						let change_password_box = document.querySelector("#change_password")
						
						// 이메일 변경하기 누른경우
						change_email_box.addEventListener("click", change_email);
						// 비밀번호 변경하기 누른경우
						change_password_box.addEventListener("click", change_password);
						
						function change_email() {
							main_page.innerHTML = `<form> 변경할 이메일 <input class="change_button" id="change_email"> <br>
							이메일 재입력 <input class="change_button" id="retype_email"> <br>
							<input type ="button" value="변경" id="change_email_button"> </form> <br>
							<p class="error_message" id="myPage_email_error"  style="visibility: hidden"></p>`
							
							let change_email_button = document.querySelector("#change_email_button");
							let email_reg = /^[A-Za-z0-9]{4,12}@[A-Za-z0-9]{1,}.(co\.kr|com|net)$/;

							change_email_button.onclick = function() {
								let change_email = document.getElementById("change_email").value;
								let retype_email = document.getElementById("retype_email").value;
								let errmsg_change_email = document.getElementById("myPage_email_error");
								// 이메일 양식과 다른 경우
								// if2
								if (!email_reg.test(change_email) ) {
									errmsg_change_email .setAttribute("style", "visibility: block");
									errmsg_change_email .innerHTML = "올바른 양식을 기입해주세요";
								} // if 2
								else {
									//if 3
									if (change_email == retype_email) {
										alert("이메일이 변경되었습니다. 메인페이지로 이동합니다");
										//이제 유저의 이메일 값을 새롭게 넣어주기
										user.email = change_email
										window.location.href = "main_signin.html";
									}// if 3
									else {
										// 변경할 이메일과 이매일 재입력 값이 다른 경우
										errmsg_change_email .setAttribute("style", "visibility: block");
										errmsg_change_email .innerHTML = "같은 값을 기입해주세요";
									}//else 3
								} //else 2
							} // onclick
						}// change_email()
						
						function change_password() {
							main_page.innerHTML = `<form> 변경할 비밀번호 <input class="change_button" id="change_password"> <br>
					비밀번호 재입력 <input class="change_button" id="retype_password"> <br>
					<input type ="button" value="변경" id="change_password_button"> </form>
					<p class="error_message" id="myPage_password_error"  style="visibility: hidden"></p>`
							let change_password_button = document.querySelector("#change_password_button");
							change_password_button.onclick = function() {
								let change_password = document.getElementById("change_password").value;
								let retype_password = document.getElementById("retype_password").value;
								let errmsg_change_password = document.getElementById("myPage_password_error");
								// if 4
								if (change_password == retype_password) {
									// 유저의 비밀번호값을 새롭게 넣어주기
									// 잠깐 주석처리 해두겠습니다. 계속바꾸면 꼬일까봐..
									// user.password = change_password;
									alert("비밀번호가 변경되었습니다. 메인페이지로 이동합니다");
									window.location.href = "main_signin.html"
								}// if 4
								// else 4
								else {
									errmsg_change_password.setAttribute("style", "visibility: block");
									errmsg_change_password.innerHTML = "같은 값을 기입해주세요";
								}//else 4
							} // onclick
						}// change_password()
						
					}// info_change_after_authentication()
				}// if 1
				// else 1
				else{
					errmsg_login.setAttribute("style", "visibility: block");
					errmsg_login.innerHTML = "올바른 아이디와 비밀번호를 입력해주세요";
				}// else 1
			
			}// check_authentication() 
		}// onload (authentication)
	} //show_info_change()
	
	// 아직 미구현 부분
	// 1. 리뷰 누르면 리뷰 작성 화면으로 가는 것 or 수정 버튼
	function show_myReview(){
	main_page.innerHTML = `<div class=\"myPage_main_header\">리뷰 게시글 내역</div> <div id=\"my_review_table\"></div>
	<div id=\"table_link\"></div>`
	// 리뷰 내역 테이블을 담을 곳
	let my_review_table = document.querySelector("#my_review_table");
	//  테이블 밑에 1) 2) 이런식으로 다음 목록으로 가는 링크 담을곳
	let table_link = document.querySelector("#table_link");
	
	
	
	// 모든 사용자들의 리뷰작성 기록이 있는 review_history_list에서 지금 user가 남긴 것을 뽑아오는것
	let my_review_history_list = [];
	// for 1
	for(let i = 0; i<review_history_list.length ;i++ ) {
		// if 1
		if(review_history_list[i].user == user){
			my_review_history_list.push(review_history_list[i]);
		} // if 1
	}// for 1
	
	// 사실 db에서 오름차순 관리해주면 그냥 가져와도 될것 같기는 한데...
	// 혹시모르니 date순으로 내림차순 정렬
	function sort_by_date(list){
		const sorted_list = list.sort(function(a,b) {
			return new Date(a.write_date).getTime()- new Date(b.write_date).getTime();
		}).reverse();// sort
		return sorted_list;
	} // sort_by_date()
	my_review_history_list = sort_by_date(my_review_history_list);
	make_review_table(my_review_history_list);
	
	// 처음 기본화면은 맨위에꺼 보여주기
	my_review_table.innerHTML = divided_review_table_list[0];
	
	let table_links_lists = document.querySelectorAll(".table_link");
	
	// 각각의 밑에있는 숫자에 테이블로 가는 링크 걸어주기
	// for2
	for (let i = 0; i <table_links_lists.length; i++){
		table_links_lists[i].onclick = function(){
			my_review_table.innerHTML = divided_review_table_list[i];
		}
	}// for2
	
	function make_review_table(list){
		// table에 리뷰 내역을 5개씩 보여줄꺼고 넘어가는것은 다음 table에서 보여줄 것임
		let num_per_table = 5;
		let review_history_table_page_count = Math.floor(list.length / num_per_table) + 1;
		
		// table link 에 history_table_page_count 개 만큼 이동할수 있는만큼 span 만들어 주기
		// for 3
		for(let i = 0; i < review_history_table_page_count; i++){
			table_link.innerHTML += `<span class="table_link" id = "to_${i}_review_table">${(i+1)}<span>`;
		}// for 3
		
		// for 4
		for(let j = 0 ; j < review_history_table_page_count; j++){
			let myReview_table ="";
			myReview_table += "<table id=\"myReview_table\">";
				// for 5
				for (let i = 0; i < Math.min(num_per_table,list.length) ;i++){
				myReview_table+="<tr><td><img src =\""+my_review_history_list[i].movie.url+"\"width =70px, height = 70px></td><td>"
				+my_review_history_list[i].movie.name+"</td><td>"+my_review_history_list[i].write_date.toLocaleDateString()+"</td></tr>";
			}// for 5
			myReview_table += "</table>";
			divided_review_table_list.push(myReview_table);
			list.splice(0,5);
			}// for 4
		}// make_review_table()
	}// show_my_review()
});







