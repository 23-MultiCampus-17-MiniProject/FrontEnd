// 페이지 전체에서 쓸 더미 리뷰 전역 변수 선언
let dummy_comments = [];
// 출력할 div 및 테이블 헤더
let board = document.getElementById("commentBoard");
// 사용할 임시 사용자 아이디
let temUser = "";
let commentMax = 30;
let userMax = 5;
let movieMax = 5;
let orderDesc = true; // 기본값 desc 날짜 내림차순
let viewCommentsCountPerPage = 10;

let reverseOrder = () => {
	orderDesc = !orderDesc;
	displayComments(selectCommentById(temUser));
};

let commentHeader = `<table id="myComment">
			<tbody id="tbody"><tr>
				<th id="username">닉네임</th>
				<th id="movietitle">영화제목</th>
				<th id="comment">한줄평</th>
				<th id="rating">평점</th>
				<th id="day" onclick="reverseOrder">날짜</th>
				<th id="like">좋아요</th>
				<th id="update">변경</th>
			</tr><tbody></table>`;

onload = () => {
	// 더미 리뷰 생성 데이터베이스 역할. 생성 개수, 유저 명수, 영화 개수를 매개변수로 받음
	dummy_comments = generateDummyComments(commentMax, userMax, movieMax);
	
	temUser = Math.ceil(Math.random() * userMax);
	let displayCurrentUser = document.getElementById("temUserId");
	displayCurrentUser.innerHTML = "현재 설정된 유저 " + temUser;
	
	// 자신의 한줄평 조회 및 출력
	displayComments(selectCommentById(temUser));
}

let sortDescDate = (a, b) => new Date(b.writeTime) - new Date(a.writeTime);
let sortAscDate = (a, b) => new Date(a.writeTime) - new Date(b.writeTime);
let sortDescLike = (a, b) => new Date(b.likeCount) - new Date(a.likeCount);
let sortAscLike = (a, b) => new Date(a.likeCount) - new Date(b.likeCount);


let selectCommentById = userId => dummy_comments.filter(comment => {
	if(comment.username == userId) {
		if(!comment.isDeleted)
			return true;
	}
	return false;
});

let selectCommentByMovieTitle = mno => dummy_comments.filter(comment => {
	if(comment.movieTitle == mno) {
		if(!comment.isDeleted)
			return true;
	}
	return false;
});

// 더미 생성 함수 매개변수로 리뷰 총 개수와 유저 전체 수, 영화 개수를 입력받음
function generateDummyComments(commentMax, userCount, movieCount) {
	let today = new Date();
	today.setMonth(9);
	let comments = [];
	for(let i = 0; i < commentMax; i++) {
		today.setDate(Math.ceil(Math.random() * 31));
		comments.push({
			bno: i,
			username: Math.ceil(Math.random() * userCount),
			movieTitle: Math.ceil(Math.random() * movieCount),
			comment: 'random comment '+i,
			rating: Math.ceil(Math.random() * 5),
			writeTime: today.toLocaleDateString(),
			likeCount: Math.ceil(Math.random() * 3),
			likePerson: [],
			isDeleted: false
		});
	}
	// 날짜별 정렬
	return comments;
}

let updateComment = (bno) => {
	// 태그 찾아오기
	let updateComment = document.getElementById("comment"+bno);
	let updateRating = document.getElementById("rating"+bno)
	let btns = document.getElementById("btns"+bno);
	
	// 코멘트 수정
	let updateCommentTextArea = document.createElement("textarea");
	updateCommentTextArea.id = "updateCommentText";
	updateCommentTextArea.maxLength = 50;
	updateCommentTextArea.style.resize = "none";
	
	updateCommentTextArea.innerHTML = updateComment.innerHTML;
	updateComment.innerHTML = "";
	updateComment.appendChild(updateCommentTextArea);
	
	// 평점 수정
	let updateRatingSelect = document.createElement("select");
	updateRatingSelect.id = "updateRatingSelect";
	for(let i = 1; i <= 5; i++) {
		let option = document.createElement("option");
		option.value = i;
		option.textContent = i;
		updateRatingSelect.appendChild(option);
	}
	
	updateRating.innerHTML = "";
	updateRating.appendChild(updateRatingSelect);
	
	// 버튼 
	let btnCommentComplete = document.createElement("button");
	btnCommentComplete.innerHTML = "완료";
	btnCommentComplete.value = bno;
	// 할당된 함수에 바인딩으로 인자값 넘겨주기.(인자가 필요한경우)
	btnCommentComplete.onclick = completeUpdateComment.bind(null, bno);
	
	let btnCommentCancle = document.createElement("button");
	btnCommentCancle.innerHTML = "취소";
	btnCommentCancle.value = bno;
	// 익명함수로 함수 할당하기, 취소니 다시 재출력
	btnCommentCancle.onclick = function() {displayComments(selectCommentById(temUser))};
	
	// 초기화 후 재할당
	btns.innerHTML = "";
	btns.appendChild(btnCommentComplete);
	btns.appendChild(btnCommentCancle);
};


let completeUpdateComment = (bno) => {
	//let review = dummy_reviews.filter(data => data.bno == bno);
	dummy_comments[bno].comment = document.getElementById("updateCommentText").value;
	dummy_comments[bno].rating = document.getElementById("updateRatingSelect").value;
	dummy_comments[bno].writeTime = new Date().toLocaleDateString();
	
	displayComments(selectCommentById(temUser));
}

let deleteComment = (bno) => {
	dummy_comments[bno].isDeleted = true;
	let tem = selectCommentById(temUser);
	displayComments(tem);
};

let makeWriteButton = () => {
	let btn = document.createElement("button");
	btn.onclick = writeComment;
	btn.id = "writeButton";
	btn.textContent = "한줄평 남기기";
	
	return btn;
}

let pulsLikeCount = (comment) => {
	for(let i = 0; i < comment.likePerson.length; i++) {
		if(comment.likePerson[i] == temUser) {
			alert("이미 좋아요를 누르셨습니다.");
			return ;
		}
	}
	comment.likePerson.push(temUser);
	comment.likeCount++;
	displayComments(selectCommentById(temUser));
}

// 리뷰 객체 리스트를 받아서 출력해주는 함수
// 날짜를 누르면 정렬을 바꿀 수 있음.
let displayComments = function(comments) {
	let comment;
	board.innerHTML = `<button class="writeCommentBtn" onclick="writeComment()">한줄평 남기기</button>`;
	
	console.log(orderDesc);
	//<button onclick="writeComment()">한줄평 남기기</button>
	board.innerHTML += commentHeader;
	document.getElementById('day').addEventListener('click', reverseOrder);
	let tableBody = document.getElementById("tbody");
	orderDesc ? comments.sort(sortDescDate) : comments.sort(sortAscDate);
	
	// reviews 객체가 없을 때 출력
	if(comments.length == 0)
		board.innerHTML += "<h3>한줄평을 남겨보세요!</h3>"
	
	// reviews 객체 출력
	for(let i = 0; i < comments.length; i++) {
		comment = comments[i];
		if(!comment.isDeleted) {
			const tr = document.createElement("tr");
			tr.id = "tr"+comment.bno;
			
			const tdUserName = document.createElement("td");
			tdUserName.innerHTML = comment.username;
			tr.appendChild(tdUserName);
			
			const tdMovieTitle = document.createElement("td");
			tdMovieTitle.innerHTML = comment.movieTitle;
			tdMovieTitle.id = "movie"+comment.movieTitle;
			tr.appendChild(tdMovieTitle);
			
			const tdComment = document.createElement("td");
			tdComment.innerHTML = comment.comment;
			tdComment.id = "comment"+comment.bno;
			tr.appendChild(tdComment);
			
			const tdRating = document.createElement("td");
			tdRating.innerHTML = comment.rating
			tdRating.id = "rating"+comment.bno;
			tr.appendChild(tdRating);
			
			const tdWriteTime = document.createElement("td");
			tdWriteTime.innerHTML = comment.writeTime;
			tr.appendChild(tdWriteTime);
			
			const tdLikeButton = document.createElement("td");
			const likeImage = document.createElement("img");
			likeImage.src = "images/like.png";
			likeImage.onclick = pulsLikeCount.bind(null, comment);
			tdLikeButton.append(likeImage, comment.likeCount);
			tr.appendChild(tdLikeButton);
			
			const tdButtons = document.createElement("td");
			tdButtons.innerHTML = `
			<button class="updateCommentBtn" onclick="updateComment(${comment.bno})">수정</button>
	        <button class="deleteCommentBtn" onclick="deleteComment(${comment.bno})">삭제</button>`;
	        tdButtons.id = "btns"+comment.bno;
			tr.appendChild(tdButtons);
			
			tableBody.appendChild(tr);
		}
	}
}

let completeWriteComment = () => {
	// 검증 로직 영화제목 선택과 한줄평 5자 이상 남기기
	let movieTitle = document.getElementById("selectMovieTitle");
	let comment = document.getElementById("writeCommentText");
	let rating = document.getElementById("writeRatingSelect");
	
	if(movieTitle.value == 0) {
		movieTitle.focus();
		alert("영화를 선택해주세요.");
	} else if(comment.value.length < 5) {
		alert("한줄평을 5글자 이상 남겨주세요.");
		comment.focus();
	} else {
		dummy_comments.push({
			bno: dummy_comments.length,
			username: temUser,
			movieTitle: movieTitle.value,
			comment: comment.value,
			rating: rating.value,
			writeTime: new Date().toLocaleDateString(),
			likeCount: 0,
			likePerson: [],
			isDeleted: false
		});
		
		displayComments(selectCommentById(temUser));
	}
}

function writeComment() {
	// board
	console.log("writeComment called");
	
	let table = document.createElement("table");
	table.style.textAlign = "center";
	
	let tbody = document.createElement("tbody");
	
	let trHeader = document.createElement("tr");
	trHeader.style.height = "50px";
	
	let thMovieTitle = document.createElement("th");
	thMovieTitle.textContent = "영화제목";
	thMovieTitle.style.width = "100px";
	
	let thComment = document.createElement("th");
	thComment.textContent = "한줄평";
	thComment.style.width = "400px";
	
	let thRating = document.createElement("th");
	thRating.textContent = "평점";
	thRating.style.width = "50px";
	
	trHeader.append(thMovieTitle, thComment, thRating);
	
	
	let trInput = document.createElement("tr");
	trInput.style.height = "50px";
	
	let tdMovieTitle = document.createElement("td");
	let selectMovieTitle = document.createElement("select");
	selectMovieTitle.id = "selectMovieTitle";
	// 추후 유저아이디로 본 영화 리스트에서 isReviewed 값 참조해서 리스트 불러올 예정
	let noOption = document.createElement("option");
	noOption.value = "0";
	noOption.textContent = "===";
	selectMovieTitle.append(noOption);
	for(let i = 1; i <= movieMax; i++) {
		let option = document.createElement("option");
		option.textContent = i;
		option.value = i;
		selectMovieTitle.appendChild(option);
	}
	tdMovieTitle.appendChild(selectMovieTitle);
	
	let tdComment = document.createElement("td");
	let writeCommentTextArea = document.createElement("textarea");
	writeCommentTextArea.id = "writeCommentText";
	writeCommentTextArea.maxLength = 50;
	writeCommentTextArea.style.width = "400px";
	writeCommentTextArea.style.height = "50px";
	writeCommentTextArea.style.resize = "none";
	tdComment.append(writeCommentTextArea);
	
	let tdRating = document.createElement("td");
	let writeRatingSelect = document.createElement("select");
	writeRatingSelect.id = "writeRatingSelect";
	for(let i = 5; i >= 1; i--) {
		let option = document.createElement("option");
		option.value = i;
		option.textContent = i;
		writeRatingSelect.appendChild(option);
	}
	tdRating.append(writeRatingSelect);
	
	trInput.append(tdMovieTitle, tdComment, tdRating);
	
	tbody.append(trHeader, trInput);
	table.appendChild(tbody);
	board.innerHTML = "";
	board.appendChild(table);
	// 한줄평 폼 테이블 끝
	
	// 제출 폼 작성 시작
	let buttonsDiv = document.createElement("div");
	
	let btnWriteComplete = document.createElement("button");
	btnWriteComplete.innerHTML = "작성 완료";
	btnWriteComplete.onclick = completeWriteComment;
	
	let btnWriteCancle = document.createElement("button");
	btnWriteCancle.innerHTML = "취소";
	btnWriteCancle.onclick = function() {displayComments(selectCommentById(temUser))};
	
	buttonsDiv.append(btnWriteComplete, btnWriteCancle);
	
	board.append(buttonsDiv);
}