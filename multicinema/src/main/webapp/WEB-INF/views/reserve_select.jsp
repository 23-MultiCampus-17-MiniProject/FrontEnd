<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
	<link rel="stylesheet" href="./css/index.css">
	<link rel="stylesheet" href="./css/reserve.css">
    <style>
	#people_select{
		text-align:center;
	}
        #seat_list{
            text-align:center;
        }
        #select_seat_price{
            text-align:right;
        }
	.info{
		width:350px;
	}
	.people{
		width:33px;
		height:33px;
		background-color:ghostwhite;
	}
	.people:active{
		backgroud-color:gray;
	}
	.people_select{
		background-color:lightgreen;
	}
        .non-select_seat{
            background-color:white;
            border:0px;
            width:35px;
            height:35px;
        }
        .non-select_seat:hover{
            background-color:lightgray;
        }
        .non-select_seat:active{
            background-color:gray;
        }
        .non-select_seat:disabled{
            background-color:gray;
        }
        .select_seat{
            background-color:lightgreen;
        }
        .result{
            display:inline-block;
            width:250px;
        }
    </style>
    <script src="script/reserve.js"></script>
</head>
<body>
<!-- 공통 UI 삽입 부분 -->
<%@ include file="/WEB-INF/views/header/mainheader.jsp" %>

<!-- 기능별 구현 부분 -->
<div id="body">
  <div>
      <table class="table">
          <tr><td>영화명<td>:<td class="info">이웃집 토토로</td></tr>
          <tr><td>일시<td>:<td class="info">2023.10.10 오전11:00</td></tr>
      </table>
  </div>
  <div id="people_select">
      인원 : <button class="people" value="1">1</button><button class="people" value="2">2</button><button class="people" value="3">3</button><button class="people" value="4">4</button><button class="people" value="5">5</button>
  </div>
  <div>
    <table id="seat_list" class="table" border="1">
        <tr><td colspan="10">SCREEN</td></tr>
        <tr><td><button class="non-select_seat" value="A1">A1</button><td><button class="non-select_seat" value="A2">A2</button><td><button class="non-select_seat" value="A3">A3</button><td><button class="non-select_seat" value="A4">A4</button><td><button class="non-select_seat" value="A5">A5</button><td><button class="non-select_seat" value="A6">A6</button><td><button class="non-select_seat" value="A7">A7</button><td><button class="non-select_seat" value="A8">A8</button><td><button class="non-select_seat" value="A9">A9</button><td><button class="non-select_seat" value="A10">A10</button></td></tr>
        <tr><td><button class="non-select_seat" value="B1">B1</button><td><button class="non-select_seat" value="B2">B2</button><td><button class="non-select_seat" value="B3">B3</button><td><button class="non-select_seat" value="B4">B4</button><td><button class="non-select_seat" value="B5">B5</button><td><button class="non-select_seat" value="B6">B6</button><td><button class="non-select_seat" value="B7">B7</button><td><button class="non-select_seat" value="B8">B8</button><td><button class="non-select_seat" value="B9">B9</button><td><button class="non-select_seat" value="B10">B10</button></td></tr>
        <tr><td><button class="non-select_seat" value="C1">C1</button><td><button class="non-select_seat" value="C2">C2</button><td><button class="non-select_seat" value="C3">C3</button><td><button class="non-select_seat" value="C4">C4</button><td><button class="non-select_seat" value="C5">C5</button><td><button class="non-select_seat" value="C6">C6</button><td><button class="non-select_seat" value="C7">C7</button><td><button class="non-select_seat" value="C8">C8</button><td><button class="non-select_seat" value="C9">C9</button><td><button class="non-select_seat" value="C10">C10</button></td></tr>
        <tr><td><button class="non-select_seat" value="D1">D1</button><td><button class="non-select_seat" value="D2">D2</button><td><button class="non-select_seat" value="D3">D3</button><td><button class="non-select_seat" value="D4">D4</button><td><button class="non-select_seat" value="D5">D5</button><td><button class="non-select_seat" value="D6">D6</button><td><button class="non-select_seat" value="D7">D7</button><td><button class="non-select_seat" value="D8">D8</button><td><button class="non-select_seat" value="D9">D9</button><td><button class="non-select_seat" value="D10">D10</button></td></tr>
       <tr><td><button class="non-select_seat" value="E1">E1</button><td><button class="non-select_seat" value="E2">E2</button><td><button class="non-select_seat" value="E3">E3</button><td><button class="non-select_seat" value="E4">E4</button><td><button class="non-select_seat" value="E5">E5</button><td><button class="non-select_seat" value="E6">E6</button><td><button class="non-select_seat" value="E7">E7</button><td><button class="non-select_seat" value="E8">E8</button><td><button class="non-select_seat" value="E9">E9</button><td><button class="non-select_seat" value="E10">E10</button></td></tr>
        <tr><td><button class="non-select_seat" value="F1">F1</button><td><button class="non-select_seat" value="F2">F2</button><td><button class="non-select_seat" value="F3">F3</button><td><button class="non-select_seat" value="F4">F4</button><td><button class="non-select_seat" value="F5">F5</button><td><button class="non-select_seat" value="F6">F6</button><td><button class="non-select_seat" value="F7">F7</button><td><button class="non-select_seat" value="F8">F8</button><td><button class="non-select_seat" value="F9">F9</button><td><button class="non-select_seat" value="F10">F10</button></td></tr>
        <tr><td><button class="non-select_seat" value="G1">G1</button><td><button class="non-select_seat" value="G2">G2</button><td><button class="non-select_seat" value="G3">G3</button><td><button class="non-select_seat" value="G4">G4</button><td><button class="non-select_seat" value="G5">G5</button><td><button class="non-select_seat" value="G6">G6</button><td><button class="non-select_seat" value="G7">G7</button><td><button class="non-select_seat" value="G8">G8</button><td><button class="non-select_seat" value="G9">G9</button><td><button class="non-select_seat" value="G10">G10</button></td></tr>
        <tr><td><button class="non-select_seat" value="H1">H1</button><td><button class="non-select_seat" value="H2">H2</button><td><button class="non-select_seat" value="H3">H3</button><td><button class="non-select_seat" value="H4">H4</button><td><button class="non-select_seat" value="H5">H5</button><td><button class="non-select_seat" value="H6">H6</button><td><button class="non-select_seat" value="H7">H7</button><td><button class="non-select_seat" value="H8">H8</button><td><button class="non-select_seat" value="H9">H9</button><td><button class="non-select_seat" value="H10">H10</button></td></tr>
        <tr><td><button class="non-select_seat" value="I1">I1</button><td><button class="non-select_seat" value="I2">I2</button><td><button class="non-select_seat" value="I3">I3</button><td><button class="non-select_seat" value="I4">I4</button><td><button class="non-select_seat" value="I5">I5</button><td><button class="non-select_seat" value="I6">I6</button><td><button class="non-select_seat" value="I7">I7</button><td><button class="non-select_seat" value="I8">I8</button><td><button class="non-select_seat" value="I9">I9</button><td><button class="non-select_seat" value="I10">I10</button></td></tr>
        <tr><td><button class="non-select_seat" value="J1">J1</button><td><button class="non-select_seat" value="J2">J2</button><td><button class="non-select_seat" value="J3">J3</button><td><button class="non-select_seat" value="J4">J4</button><td><button class="non-select_seat" value="J5">J5</button><td><button class="non-select_seat" value="J6">J6</button><td><button class="non-select_seat" value="J7">J7</button><td><button class="non-select_seat" value="J8">J8</button><td><button class="non-select_seat" value="J9">J9</button><td><button class="non-select_seat" value="J10">J10</button></td></tr>
    </table>
  </div>
  <div>
    <table border="1" class="table">
        <tr><td>선택된 좌석<td><span id="select_seat_info" class="result"></span><td rowspan="2"><button id="payment_btn" class="btn">결제</td></tr>
        <tr><td>총 결제 금액<td><span id="select_seat_price" class="result">0원</span></td></tr>
    </table>
  </div>
</div>
<script>
    // 인원
    let people_count=0;
    let people_limit=0;
    const people=document.querySelectorAll(".people");
    people.forEach((event) => {
        event.addEventListener("click",function(event){
            people.forEach((e) => {
                e.classList.remove("people_select");
            });
            event.target.classList.add("people_select");
            people_limit=parseInt(this.value);
        });
    });

    let selected_seat=[];
    let price=0;
    const seat=document.querySelectorAll(".non-select_seat");
    const select_seat_info=document.getElementById("select_seat_info");
    const select_seat_price=document.getElementById("select_seat_price");
    // seat.forEach((e) => { console.log(e); e.classList.add("test_seat"); } );
    function select_seat(event){
        // seat.forEach((e) => {
        //     e.classList.remove("select_seat");
        // });
        if (selected_seat.includes(event.target.value)) {
            selected_seat.splice(selected_seat.indexOf(event.target.value), 1);
            event.target.classList.remove("select_seat");
            people_count--;
            price-=12000;
        } 
        else if(people_count >= people_limit) {
            alert("이미 최대 선택 가능한 좌석을 선택하셨습니다.");
        }
        else{
            selected_seat.push(event.target.value);
            event.target.classList.add("select_seat");
            people_count++;
            price+=12000;
            // alert(event.target.value);
        }

        select_seat_info.innerHTML=selected_seat.toString();
        select_seat_price.innerHTML=price+"원";
    }

    seat.forEach((e) => {
        e.addEventListener("click",select_seat);
    });

	let paymentBtn=document.getElementById("payment_btn");
	paymentBtn.addEventListener("click",(e) => {
		if(people_count<=0){
			alert("좌석을 먼저 선택해주세요.");
			return;
		}
		let paymentForm=document.createElement("form");
		paymentForm.setAttribute("method","post");
		paymentForm.setAttribute("action","./reserve_payment.html");

		//let sendSeat=document.createElement("input");
		//sendSeat.setAttribute("type","hidden");
		//sendSeat.setAttribute("name","seat");
		//sendSeat.setAttribute("value",select_seat_info.toString());

		let sendPrice=document.createElement("input");
		sendPrice.setAttribute("type","hidden")
		sendPrice.setAttribute("name","price")
		sendPrice.setAttribute("value",price)
		paymentForm.appendChild(sendPrice);

		document.body.appendChild(paymentForm);
		paymentForm.submit();
	});
</script>
</body>
</html>