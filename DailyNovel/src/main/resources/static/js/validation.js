//Javascript

let loginBoxId = document.querySelector(".outBox-id");
let loginBoxPass = document.querySelector(".outBox-pass");
let loginInputBoxId = document.querySelector(".sample-id");
let loginInputBoxPass = document.querySelector(".sample-pass");
const id= document.querySelector("#id");
const password = document.querySelector("#passwd");
const loginbtn = document.querySelector("#loginbtn");
const idmiss = document.getElementById("idmiss");
const passwordmiss = document.getElementById("passwordmiss");

loginbtn.addEventListener('click', ()=>{
    if (id.value == '0000') {
        if (password.value == '0000') {
        
            loginbtn.type ="submit";

        }
        else {
        
            loginbtn.type ="reset";
            passwordmiss.classList.remove('blind');
            idmiss.classList.add('blind');
            loginBoxId.classList.remove('existence');   
            loginBoxPass.classList.remove('existence'); 
        }
    }
    else {
      
            loginbtn.type ="reset";
            idmiss.classList.remove('blind');
            passwordmiss.classList.add('blind');
            loginBoxId.classList.remove('existence');   
            loginBoxPass.classList.remove('existence'); 
    }

})

loginInputBoxId.addEventListener('keyup', function(){
    console.log("adsf");
    if(!loginInputBoxId.value == ''){
        //빈 값이 아닌 경우
        loginBoxId.classList.add('existence');   
    }else{
        //빈 값인 경우
        loginBoxId.classList.remove('existence');   
        
    }
});

loginInputBoxPass.addEventListener('keyup', function(){
    if(!loginInputBoxPass.value == ''){
        //빈 값이 아닌 경우
        loginBoxPass.classList.add('existence');   
    }else{
        //빈 값인 경우
        loginBoxPass.classList.remove('existence');   
    }
});



class inputForm{
    constructor(selector) {
        this.doc = document.querySelector(selector);


    this.doc.addEventListener('keyup', function(){
        if(!loginInputBoxPass.value == ''){
            //빈 값이 아닌 경우
            loginBoxPass.classList.add('existence');   
        }else{
            //빈 값인 경우
            loginBoxPass.classList.remove('existence');   
        }
    });
    }

    
}
////////////스크롤 이벤트/////////////////////
let html = document.querySelector("html");
var page = 1;
var lastPage = document.querySelectorAll(".content");

window.addEventListener('wheel', function(e) {
    // 만약 html이 애니메이션 중인 경우 함수 실행 중지
    if (html.classList.contains('is-animated')) return;
    
    // 마우스 휠의 deltaY 값에 따라 page 변수 값 변경
    if (e.deltaY > 0) {
        if (page === lastPage) return;
        page++;
    } else if (e.deltaY < 0) {
        if (page === 1) return;
        page--;
    }
    
    // 새롭게 계산된 위치를 기준으로 scrollTop 애니메이션 실행
    var posTop = (page-1) * window.innerHeight;
    html.classList.add('is-animated');
    scrollTo(html, posTop, 500, function() {
    html.classList.remove('is-animated');
    });
});



  // 스크롤 애니메이션 함수
function scrollTo(element, to, duration, callback) {
    if (duration <= 0) {
        callback();
        return;
    }
    var difference = to - element.scrollTop;
    var perTick = difference / duration * 10;
    
    setTimeout(function() {
        element.scrollTop = element.scrollTop + perTick;
        if (element.scrollTop === to) {
        callback();
        return;
        }
    scrollTo(element, to, duration - 10, callback);
    }, 10);
}
