// 가이드 페이지 가이드 컨텐츠중 마지막 컨텐츠에 버튼 붙이기
// 선유진

const guides = document.querySelectorAll(".item-guide");
const addBtn = guides[guides.length-1]


//마지막 인삿말에 버튼 추가
addBtn.insertAdjacentHTML('beforeend',' <div  class="btn3 color-bg-green-2 color-white-1 mgt-6" id="write-diary">글 쓰러 가기</div>');

const getRegDiary = document.querySelector("#write-diary");

getRegDiary.addEventListener("click",()=>{
    window.location.href = './select-tmp.html';
})


//x 표시 누르면 뒤로가기