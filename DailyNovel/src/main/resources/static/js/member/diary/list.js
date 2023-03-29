//일기 검색 창 스크립트 코드입니다.

//선유진



// 정렬 방식 JS
const btns = document.querySelectorAll(".option-box");
    
for(let btn of btns){
btn.addEventListener('click',(e) => {

    let tag = e.target.tagName;
    if(!(tag =='DIV')) return;
    
    const cate = btn.querySelector(".select");
    cate.classList.toggle('hidden');

    });
}
// 정렬방식 JS 끝!




// 모달창 JS
const open = () => {
    console.log("클릭됨");
  document.querySelector(".list-modal").classList.remove("hidden");
  console.log(document.querySelector(".list-modal"));
}

const close = () => {
  document.querySelector(".list-modal").classList.add("hidden");
}

document.querySelector("#openBtn").addEventListener("click", open);
// document.querySelector(".list-modal .modalBox .closeBtn").addEventListener("click", close);
document.querySelector(".list-modal .bg").addEventListener("click", close);
//모달창 js 끝!