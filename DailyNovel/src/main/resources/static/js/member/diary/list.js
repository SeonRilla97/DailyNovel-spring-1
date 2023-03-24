//일기 검색 창 스크립트 코드입니다.

//선유진


const open = () => {
    console.log("클릭됨");
  document.querySelector(".list-modal").classList.remove("hidden");
  console.log(document.querySelector(".list-modal"));
}

const close = () => {
  document.querySelector(".list-modal").classList.add("hidden");
}

document.querySelector("#openBtn").addEventListener("click", open);
let a = document.querySelector("#openBtn")
console.log(a);
// document.querySelector(".list-modal .modalBox .closeBtn").addEventListener("click", close);
document.querySelector(".list-modal .bg").addEventListener("click", close);
