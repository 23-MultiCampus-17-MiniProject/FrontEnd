let button=document.querySelector("button");

button.addEventListener("click",(e)=>{
	let cardNumber=document.querySelector("input[name='card_number']");
	const regCardNumber=/^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{3,4}$/

	if(regCardNumber.test(cardNumber.value)){
		location.href="./reserve_result.html";
	}else{
		alert("올바르지 않은 카드 번호 입니다.");
	}
//	alert(e.target.textContent);
//	alert(cardNumber.value);
//	alert(regCardNumber.test(cardNumber.value));
});