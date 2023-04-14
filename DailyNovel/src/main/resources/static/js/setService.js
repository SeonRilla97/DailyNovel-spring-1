let submitBtn = document.querySelector(".flex-jfy-center .btn3");
let santance = document.querySelector(".input-boder-none");
let radioInit = document.getElementsByName("kind");

submitBtn.onclick = function(){
    alert("문의가 전송되었습니다.");
    setTimeout(xdxd=>santance.value="",10);
    radioInit[2].checked=true
    
    
}