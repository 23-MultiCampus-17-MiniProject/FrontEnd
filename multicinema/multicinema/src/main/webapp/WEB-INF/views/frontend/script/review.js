// 페이지 전체에서 쓸 더미 리뷰 전역 변수 선언
let dummyReviews = [];
let temReviews = [];
// 출력할 div 및 테이블 헤더
let board = document.getElementById("reviewBoard");
// 사용할 임시 사용자 아이디
let userId = "";
let reviewMax = 30;
let userMax = 5;
let movieMax = 5;
let reviewCommentMax = 5;
let currentBoardPage = 1;
let displayReviewsPerPage = 10;
let temReviewsLength;

// url parameter로 가져온 userId 활용 없다면 임시 생성
/*function getQueryParam(name) {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    return urlParams.get(name);
}*/

let listRefresh = () => {
	displayReviewsPerPage = document.getElementById("viewListOption").value;
	if(displayReviewsPerPage == 0)
		return ;
	currentBoardPage = 1;
	displayBoardList();
}

let createListOption = () => {
	let div = createDiv("listOption");
	
	let options = [];
	let viewListOption = [10, 20, 50];
	options[0] = createOption("0", "======="); 
	for(let i = 0; i < viewListOption.length; i++)
		options.push(createOption(viewListOption[i], viewListOption[i]+"개씩 보기"));
	let select = createSelect("viewListOption", options);
	select.addEventListener("change", listRefresh);
	
	div.append(select);
	div.style.textAlign = "right";
	return div;
}

let createListTable = (reviews) => {
	console.log(reviews);
	let table = createTable("boardListTable");
	table.style.textAlign = "center";
	let tr = createTr();
	
	let thTextList = ["글번호", "영화", "작성자", "글제목", "추천", "댓글", "작성일"];
	let thIdList = ["thBno", "thMovieTitle", "thWriter", "thBoardTitle", "thLikeCount", "thCommentCount", "thWriteDay"];
	for(let i = 0; i < thTextList.length; i++) {tr.append(createTh(thTextList[i], thIdList[i]))} 
	
	table.append(tr);
	if(reviews.length > 0) {
		let trs = createReviewAllList(reviews);
		trs.forEach(i => table.append(i));
	}
	return table;
}

let plusLikeCount = (bno) => {
	let review = dummyReviews[bno];
	for(let i = 0; i < review.likePerson.length; i++) {
		if(review.likePerson[i] == userId) {
			alert("이미 좋아요를 누르셨습니다.");
			return ;
		}
	}
	review.likePerson.push(userId);
	review.likeCount++;
	displayReviewDetail(review.bno);
}

let updateReviewToDummyReviews = (bno, bTitle, mTitle, bContent) => {
	for(let i = 0; i < dummyReviews.length; i++) {
		if(dummyReviews[i].bno == bno) {
			dummyReviews[i].reviewTitle = bTitle;
			dummyReviews[i].movieTitle = mTitle;
			dummyReviews[i].reviewContent = bContent;
			dummyReviews[i].writeDay = new Date().toLocaleDateString();
			return ;
		}
	}
}

let completeUpdateReview = (bno) => {
	// writeTitle, selectMovieTitleBoard, writeContent
	let boardTitle = document.getElementById("writeTitle");
	let movieTitle = document.getElementById("selectMovieTitleBoard");
	let boardContent = document.getElementById("writeContent");
	
	if(boardTitle.value.length < 5) {
		alert("제목은 5글자 이상을 작성해주세요.");
		boardTitle.focus();
	} else if(movieTitle.value == -1) {
		alert("영화를 골라주세요.");
		movieTitle.focus();
	} else if(boardContent.value.length < 5) {
		alert("내용을 5글자 이상을 작성해주세요.");
		boardContent.focus();
	} else {
		updateReviewToDummyReviews(bno, boardTitle.value, movieTitle.value, boardContent.value);
		displayBoardList();
	}
}



let updateReviewDetail = (bno) => {
	writeBoard();
	let updateReview;
	
	for(let i = 0; i < dummyReviews.length; i++)
		if(dummyReviews[i].bno == bno)
			updateReview = dummyReviews[i];

	//let updateReview = dummyReviews.filter((review) => review.bno == bno)
	console.log(updateReview.reviewContent);
	console.log(updateReview.reviewTitle);
	
	let boardTitle = document.getElementById("writeTitle");
	let boardContent = document.getElementById("writeContent");
	
	boardTitle.innerHTML = updateReview.reviewTitle;
	boardContent.innerHTML = updateReview.reviewContent;
	
	let pTagUpdate = document.getElementById("pComplete");
	pTagUpdate.textContent = "수정 완료";
	pTagUpdate.onclick = completeUpdateReview.bind(null, bno);
}

let deleteReviewDetail = (bno) => {
	dummyReviews[bno].isDeleted = true;
	displayBoardList();
}

let displayListReviewComment = (bno) => {
	let divListComment = document.getElementById("listReviewComment");
	console.log(divListComment);
	let comments = dummyReviews[bno].reviewComment;

	for(let i = 0; i < comments.length; i++) {
		let comment = comments[i];
		console.log(comment);
		console.log(divListComment);
		if(comment.isDeleted)
			continue;
		divListComment.innerHTML += `
			<p style="font-weight: bold; font-size:18px;">${comment.writer}</p>
			<p>${comment.comment}</p>
			<hr>
		`;
	}	
}

let completeWriteReviewComment = (bno) => {
	let commentText = document.getElementById("taWriteReviewComment");
	if(commentText.value.length < 3) {
		alert("3글자 이상을 입력해 주세요.")
		return ;
	} else {
		dummyReviews[bno].reviewComment.push({
			cno: dummyReviews[bno].reviewComment.length,
			writer: userId,
			comment: commentText.value,
			isDeleted: false
		});
		
		displayReviewDetail(bno);
	}
	
}

let displayReviewComment = (bno) => {
	let divComment = document.getElementById("divReviewComment");
	
	/*cno: i,
			writer: Math.ceil(Math.random() * userMax),
			comment: "comment"+Math.ceil(Math.random() * userMax),
			isDeleted: false*/
	let divWriteComment = `<div id ="writeReviewComment">
		<textarea id="taWriteReviewComment"></textarea>
		<button id="btnWriteReviewComment" onclick="completeWriteReviewComment(${bno})">작성완료</button>
		</div>
	`;
	
	
	divComment.innerHTML = divWriteComment + "<hr>";
	let divListComment = createDiv("listReviewComment");
	divComment.append(divListComment);
	displayListReviewComment(bno);
	divComment.append(divListComment);
}

let displayReviewDetail = (bno) => {
	board.innerHTML = "";
	
	let div = createDiv("board");
	let review = dummyReviews[bno];
	dummyReviews[bno].visitorCount++;
	
	board.appendChild(div);
	div.innerHTML = `<hr><table><tr>
	<td style="text-align: left; width: 80px">${review.writer}</td>
	<td style="text-align: center; width: 700px"><h1>${review.reviewTitle}</h1></td>
	<td style="text-align: right; width: 80px">조회: ${review.visitorCount}</td>
	<td style="text-align: right; width: 80px">댓글: ${review.reviewComment.length}</td>
	</tr></table><hr>
	<div id="reviewContent">
	<p style="margin-top: 50px; margin-bottom: 50px; text-align: left;">${review.reviewContent}</p>
	</div>
	<div id="likeControl">
	<p><img src="images/like.png" id="likeReviewImg" onclick="plusLikeCount(${review.bno})"></p>
	<p>${review.likeCount}</p>
	</div>
	<hr>
	`;
	
	
	div.innerHTML += `
		<div style="display:inline-block; text-align: left;">
		<p onclick="displayBoardList()" style="display:inline-block; text-align: left;">목록 보기</p>
		</div>
	`;
	
	if(review.writer == userId)
		div.innerHTML += `<div style="display:inline-block;">
		<p onclick="updateReviewDetail(${review.bno})" style="display:inline-block; text-align: right;">수정하기</p>
		<p onclick="deleteReviewDetail(${review.bno})" style="display:inline-block; text-align: right;">삭제하기</p>
		</div>
		`;
	div.innerHTML += `<hr><div id=divReviewComment></div>`;
	displayReviewComment(bno);
}

let createReviewAllList = (reviews) => {
	let trs = [];
	let count = 0;
	let i;
	
	for(i = 0; count < displayReviewsPerPage * (currentBoardPage - 1) && i < temReviews.length; i++) {
		if(!reviews[i].isDeleted)
			count++;
	}
		
	for(; count < displayReviewsPerPage * currentBoardPage && i < temReviews.length; i++) {
		let review = reviews[i];
		
		if(review.isDeleted)
			continue ;
		
		let tr = createTr();
		tr.onmouseenter = function() {this.style.backgroundColor = "rgb(238, 238, 238)";}
		tr.onmouseleave = function() {this.style.backgroundColor = "";}
		if(review.likeCount >= 5)
			tr.style.fontWeight = "bold";
		tr.onclick = displayReviewDetail.bind(null, review.bno);
		
		let tdList = [review.bno, review.movieTitle, review.writer, 
		review.reviewTitle, review.likeCount, review.reviewComment.length, review.writeDay];
		
		count++;
		tdList.forEach(i => tr.append(createTd(i)));
		trs[i] = tr;
	}
	return trs;
}

let changeBoardChange = (page) => {
	currentBoardPage = page;
	displayBoardList();
}

let getTemReviewsLength = () => {
	let length = 0;
	for(let i = 0; i < temReviews.length; i++) {
		if(!temReviews.isDeleted)
			length++;
	}
	return length;
}

let createPageOption = () => {
	let div = createDiv("pageOption");
	let ul = document.createElement("ul");
	temReviewsLength = getTemReviewsLength();
	
	for(let i = 1; i < temReviewsLength / displayReviewsPerPage + 1; i++) {
		let li = document.createElement("li");
		li.style.display = "inline-block";
		li.style.marginRight = "10px";
		li.style.listStyleType = "none";
		if(i == currentBoardPage)
			li.style.fontWeight = "bold";
		
		li.id = "page"+i;
		li.textContent = i;
		li.onclick = changeBoardChange.bind(null, i);
		ul.append(li);
	}
	div.append(ul);
	return div;
}

let inputReviewToDummyReviews = (bTitle, mTitle, bContent) => {
	let newReview = {
		bno: dummyReviews.length,
		movieTitle: mTitle,
		writer: userId,
		password: dummyReviews.length,
		reviewTitle: bTitle,
		reviewContent: bContent,
		reviewComment: [],
		visitorCount: 0,
		likeCount: 0,
		likePerson: [],
		writeDay: new Date().toLocaleDateString(),
		isDeleted: false
	}
	
	dummyReviews.push(newReview);
	reviewMax++;
	currentBoardPage=1;
	alert("작성완료되었습니다.");
}

let completeWriteBoard = () => {
	// writeTitle, selectMovieTitleBoard, writeContent
	let boardTitle = document.getElementById("writeTitle");
	let movieTitle = document.getElementById("selectMovieTitleBoard");
	let boardContent = document.getElementById("writeContent");
	
	if(boardTitle.value.length < 5) {
		alert("제목은 5글자 이상을 작성해주세요.");
		boardTitle.focus();
	} else if(movieTitle.value == -1) {
		alert("영화를 골라주세요.");
		movieTitle.focus();
	} else if(boardContent.value.length < 5) {
		alert("내용을 5글자 이상을 작성해주세요.");
		boardContent.focus();
	} else {
		inputReviewToDummyReviews(boardTitle.value, movieTitle.value, boardContent.value);
		displayBoardList();
	}
}

let writeBoard = () => {
	let div = createDiv("writeBoard");
	
	board.innerHTML = "";
	board.append(div);
	div.innerHTML = `
		<table style="width: 1000px;">
		<tr style="height: 20px;">
			<td style="width: 70px;">글제목</td>
			<td><textarea id="writeTitle" style="width: 800px; height: 18px; resize: none; margin: 0 auto;"></textarea></td>
		</tr>
		<tr>
			<td>영화제목</td>
			<td>
				<select id="selectMovieTitleBoard">
					<option value="-1">==============</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><textarea id="writeContent" style="width: 800px; height: 600px; resize: none; margin: 0 auto; font-size:14px;"></textarea></td>
		</tr>
		<tr>
		<td style="text-align:center;" colspan="2">
		<p id="pComplete" onclick="completeWriteBoard()">작성 완료</p>
		<p onclick="displayBoardList()">취소</p></td>
		</tr>
		</table>
	`;
	
	let select = document.getElementById("selectMovieTitleBoard");
	for(let i = 0; i < movieMax; i++) {
		let option = createOption(i, i)
		select.append(option);
	}
		
}

let searchByMovieTitle = (text) => {
	temReviews = [];
	
	for(let i = 0; i < dummyReviews.length; i++) {
		if(dummyReviews[i].movieTitle.includes(text) && !dummyReviews[i].isDeleted)
			temReviews.push(dummyReviews[i]);
	}
}

let searchByTitle = (text) => {
	temReviews = [];
	
	for(let i = 0; i < dummyReviews.length; i++) {
		if(dummyReviews[i].reviewTitle.includes(text) && !dummyReviews[i].isDeleted)
			temReviews.push(dummyReviews[i]);
	}
}

let searchByUserId = (text) => {
	temReviews = [];
	
	for(let i = 0; i < dummyReviews.length; i++) {
		if(dummyReviews[i].writer.includes(text) && !dummyReviews[i].isDeleted)
			temReviews.push(dummyReviews[i]);
	}
}

let searchBoardWithText = () => {
	let text = document.getElementById("searchText");
	if(text.value.length < 1) {
		alert("1글자 이상으로 검색이 가능합니다.");
		text.focus();
		return ;
	}
	
	let searchMethod = document.getElementById("searchMethod");
	if(searchMethod.value == "searchByTitle") {
		searchByTitle(text.value);
	} else if(searchMethod.value == "searchByName") {
		searchByUserId(text.value);
	} else if(searchMethod.value == "searchByMovieTitle") {
		searchByMovieTitle(text.value);
	}
	
	displayBoardList();
} 

let refreshBoard = () => {
	temReviews = dummyReviews;
	displayBoardList();
}

let createFootOption = () => {
	let div = createDiv("footOption");
	
	div.innerHTML = `
		<button onclick="writeBoard()" style="text-align: center;">리뷰 쓰기</button>
		<div id="searchOption" style="text-align: center; display:inline-block;">
			<select id="searchMethod">
				<option value="searchByTitle">게시글 제목으로 검색</option>
				<option value="searchByName">작성자 이름으로 검색</option>
				<option value="searchByMovieTitle">영화 제목으로 검색</option>
			</select>
			<textarea id="searchText" style="resize:none; height:20px;"></textarea>
			<button onclick="searchBoardWithText()">검색</button>
			<button onclick="refreshBoard()">전체글보기</button>
		</div>
	`;
	
	return div;
}



let displayBoardList = () => {
	//if(reviews ==)
	//	reviews = temReviews;
	board.innerHTML = "";
	board.append(createListOption());
	board.append(createListTable(temReviews));
	board.append(createPageOption(temReviews));
	board.append(createFootOption());
}


let generateDummyComment = () => {
	let comments = [];
	
	for(let i = 0; i < Math.ceil(Math.random() * reviewCommentMax); i++)
		comments.push({
			cno: i,
			writer: Math.ceil(Math.random() * userMax),
			comment: "comment"+Math.ceil(Math.random() * userMax),
			isDeleted: false
		});
	
	return comments;
}

let generateDummyReviews = () => {
	//reviewMax, userMax, movieMax, userId
	//"글번호", "영화", "작성자", "글제목", "추천수", "댓글수", "작성일"
	let today = new Date();
	today.setMonth(8);
	today.setDate(Math.ceil(Math.random() * 29));
	
	for(let i = 0; i < reviewMax; i++) {
		today.setDate(Math.ceil(Math.random() * 29));
		dummyReviews.push({
			bno: i,
			movieTitle: ""+Math.ceil(Math.random() * movieMax),
			writer: ""+Math.ceil(Math.random() * userMax),
			password: i,
			reviewTitle: "dummyTitle"+Math.ceil(Math.random() * movieMax),
			reviewContent: "dummyContent"+Math.ceil(Math.random() * reviewMax),
			reviewComment: generateDummyComment(),
			visitorCount: Math.ceil(Math.random() * 100),
			likeCount: Math.ceil(Math.random() * 6),
			likePerson: [],
			writeDay: today.toLocaleDateString(),
			isDeleted: false
		});
	}
}

onload = () => {
	userId = Math.ceil(Math.random() * userMax);
	console.log(userId + "님 환영합니다.");
	generateDummyReviews();
	
	temReviews = dummyReviews;
	displayBoardList();
}


// 기본요소들 생성
let createDiv = (id) => {
	let div = document.createElement("div");
	if(id !== undefined)
		div.id = id;
	return div;
}

let createSelect = (id, options) => {
	let select = document.createElement("select");
	select.id = id;
	
	for(let i = 0; i < options.length; i++)
		select.append(options[i]);
	return select;
}

let createOption = (value, text) => {
	let option = document.createElement("option");
	option.value = value;
	option.textContent = text;
	return option;
}

let createTable = (id) => {
	let table = document.createElement("table"); 
	if(id !== undefined)
		table.id = id;
	return table;
}

let createTbody = (id) => {
	let tbody = document.createElement("tbody");
	if(id !== undefined)
		tbody.id = id;
	return tbody;
}

let createTh = (text, id) => {
	let th = document.createElement("th");
	th.textContent = text;
	if(id !== undefined)
		th.id = id;
	return th;
}

let createTr = (id) => {
	let tr = document.createElement("tr");
	if(id !== undefined)
		tr.id = id;
	return tr;
}

let createTd = (text, id) => {
	let td = document.createElement("td");
	td.textContent = text;
	if(id !== undefined)
		td.id = id;
	return td;
}