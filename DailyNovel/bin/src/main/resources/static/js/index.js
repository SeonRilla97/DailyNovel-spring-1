//자바스크립트로 이벤트 주기위한 변수들 설정
let words=document.querySelectorAll(".index-text-fade");
let sections = document.querySelectorAll(".index-div")
let currentNum =0;
let beforeNum =0;
let wordArray = [];




let observer = new IntersectionObserver((e)=>{
    e.forEach((박스)=>{
        if(박스.isIntersecting){
            박스.target.classList.remove("opacity-0");
            박스.target.classList.add("fade-in");
            박스.target.classList.remove("fade-out");
    }
        else{
            박스.target.classList.add("opacity-0");
            박스.target.classList.add("fade-out");
            박스.target.classList.remove("fade-in");
            
        }
    })
});

for(let  i=0; i<sections.length; i++){
        observer.observe(sections[i]);

}


fadeFunction=setInterval(function(){
    setTimeout(function(){
        if (currentNum==words.length-1) {
            beforeNum=currentNum;
            currentNum=0;
        }
        else{
            beforeNum=currentNum;
            currentNum+=1;
        }
    },3000);
    words[currentNum].classList.remove("d-none");
    words[currentNum].classList.add("fade-in");    
    words[beforeNum].classList.remove("fade-in");
    words[beforeNum].classList.add("d-none");


},3000);


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
