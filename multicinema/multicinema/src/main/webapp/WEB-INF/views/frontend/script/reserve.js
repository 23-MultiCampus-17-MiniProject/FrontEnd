let payType=document.getElementsByName("paymentTypeCard");
payType.addEventListener('click',(event)=>{
    alert(payType.length);
    alert(payType.values);
});

let paymentForm=document.getElementById("paymentForm");
