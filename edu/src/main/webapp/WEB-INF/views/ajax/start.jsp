<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn1").on('click', function(){
		$.ajax({
			url: "ajaxlogin",
			data:{'memberid': $("#memberid").val() , 'pw': $("#pw").val()},
			type: 'get',
			dataType: 'json',
			success: function(response){
				//alert(JSON.stringify(response));
				//response 객체형태 -> 출력 -> 문자열형태변경메서드
				if(response.loginresult == "로그인성공"){
					$("#result").css("color", "green");	
				}else{
					$("#result").css("color", "red");
				}
				$("#result").html("<h3>" + response.loginresult + "</h3>")
			},
			error: function(request, e){
				alert("코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	});
	
	$("#ajaxbtn2").on('click', function(){
		$.ajax({
			url: "ajaxmypage",
			data:{'memberid': $("#memberid").val() , 'pw': $("#pw").val()},
			type: 'post',
			dataType: 'json', //xml도 있지만 옛날 방식
			success: function(response){
				//alert(JSON.stringify(response));
				if(response.membername == null){
					$("#result").html("회원정보가 없습니다").css("color", "red");
				}else{
					$("#result").html("<h3>"+response.memberid+"</h3>")
					.append("<h3>"+response.membername+"</h3>")
					.append("<h3>"+response.phone+"</h3>")
					.append("<h3>"+response.email+"</h3>")
					.append("<h3>"+response.regdate+"</h3>")
					.css("color", "green");
				}
			}, 
			error: function(request, e){
				alert("코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	});
	
	$("#ajaxbtn3").on('click', function(){
		$.ajax({
			url: "ajaxlist",
			data:{'memberid': $("#memberid").val() , 'pw': $("#pw").val()},
			type: 'post',
			dataType: 'json', //xml도 있지만 옛날 방식
			success: function(response){
				//alert(JSON.stringify(response));
				if(response == null){
					$("#result").html("<h3>관리자가 아닙니다</h3>").css("color", "red");
				}else{
					$("#result").html("")
					for(let i = 0; i <= response.length; i++){
						$("#result")
						.append("<h3><a href=''>" + response[i].memberid + "</a>/")
						.append(response[i].membername + "/")
						.append(response[i].phone + "/")
						.append(response[i].email + "<br>")
						.css("color", "green")
					}
				}
			}, 
			error: function(request, e){
				alert("코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	});
	
	$("#result a").on('click', "a", function(e){ //새로생긴 a태그에 대해서만
		e.preventDefault();
		$.ajax({
			url: "ajaxgetpw/" + $(this).text(), //클릭한 a태그
			//data:{'memberid': $("#memberid").val() , 'pw': $("#pw").val()},
			type: 'post',
			dataType: 'json', //xml도 있지만 옛날 방식
			success: function(response){
				//alert(JSON.stringify(response));
				$("#result").html(response.pw);
			}, 
			error: function(request, e){
				alert("오류 났다 코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	})
	
	
	
	
	
	
	$("#ajaxbtn4").on('click', function(){
		$.ajax({
			url: "ajaxgetpw/" + $("#memberid").val(),
			//data:{'memberid': $("#memberid").val() , 'pw': $("#pw").val()},
			type: 'post',
			dataType: 'json', //xml도 있지만 옛날 방식
			success: function(response){
				//alert(JSON.stringify(response));
				$("#result").html(response.pw);
			}, 
			error: function(request, e){
				alert("오류 났다 코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	});
	
	$("#uploadbtn").on('click', function(){
		new FormData($("#uploadform").get(0))//html form태그에 입력된 태그 정보를 갖고있는 객체
											//$("#uploadform").get(0) jquery객체를 자바스크립 객체로
		$.ajax({
			url: "ajaxupload",
			data: data,
			encType: "multipart/form-data", //파일업로드시 필요함
			processData: false, //name = value 전송 x
			contentType: false, //request.setContentType("text/html")이 기본 설정을 안쓰겠다 스트림으로 받아라
			type: 'post',
			dataType: 'json', //xml도 있지만 옛날 방식
			success: function(response){
				alert(JSON.stringify(response));
				$("#uploadresult").html(response.uploadresult);
			}, 
			error: function(request, e){
				alert("오류 났다 코드=" + request.status + " 메세지=" + request.responseText + " 오류=" + e);
			}
		});
	});
	
	
	
	
	
})
</script>
</head>
<body>
<h1>ajax 테스트</h1>
<form action="nonajaxlogin">
아이디<input type=text name="memberid" id="memberid"><br>
암호<input type=password name="pw" id="pw"><br>
<input type="submit" value="nonajax로그인">
<input type="button" id="ajaxbtn1" value="ajax로그인">
<input type="button" id="ajaxbtn2" value="ajax내정보조회">
<input type="button" id="ajaxbtn3" value="ajax모든회원정보조회">
<input type="button" id="ajaxbtn4" value="ajax암호">
</form>
<div id="result">회원정보</div>
<hr>
<form id="upload">
파일선택: <input type="file" name="uploadfile">
<input type="button" id="uploadbtn" value="파일업로드">
</form>
<div id="uploadresult">파일 업로드 결과</div>
</body>
</html>