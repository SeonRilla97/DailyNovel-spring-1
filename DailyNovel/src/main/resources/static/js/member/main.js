console.log("메인 스크립트 연결!")

// let a =document.querySelectorAll(".calendar .date .circle-li");
// console.log(a);


function callbackforDiaryPreview(result) {
    const diaryData = result;
    let activedDate =document.querySelectorAll(".calender .date .circle-li");
    let sliderAboutDate = document.querySelector("#previewSlider")
    console.log(activedDate);
    for(let acDate of activedDate){
        
        acDate.onclick = function() {
            console.log(acDate.textContent);
            let curDate = acDate.textContent;
            htmlText = "";
            //미리보기에 값 넣기
            if(diaryData[curDate]){
                
                for(let diary of diaryData[curDate]){
                    htmlText += `<div class="item item-diary">
                    <div class="h2">${diary.title}</div>
                    <div>
                        ${diary.content}
                    </div>
                   </div>`;
                }
                htmlText+= `<div class="item lc-center" >
                <div class="icon-plus" onClick="location.href='/diary/guide'"></div>
                <!-- <div class="ic-add-diary"></div> -->
               </div>`
               console.log(htmlText);
            }   
            else{
                htmlText+= `<div class="item lc-center" >
                <div class="icon-plus" onClick="location.href='/diary/guide'"></div>
                <!-- <div class="ic-add-diary"></div> -->
               </div>`
               console.log(htmlText);
            }
            // 페이지 네이션 달기
            htmlText+=` <div class="prev-btn btn">◀</div>
            <div class="next-btn btn">▶</div>
            <ul class="pagination pagination-main"></ul>`
            sliderAboutDate.innerHTML=htmlText;
            new slide(
                ".slider", //
                ".slider .prev-btn",
                ".slider .next-btn",
                ".slider .item",
                ".slider .pagination",
                ".slider .pagination > li" 
                );
        }
    }
}

new Date()
/*
 //일기 미리보기
 <div class="item item-diary">
 <div class="h2">2023년 3월 9일</div>
 <div>
     이거 진짜 3줄 이후로 안나옴?? 이거 진짜 3줄 이후로 안나옴?? 이거 진짜 3줄 이후로 안나옴?? 이거 진짜 3줄
     이후로 안나옴?? 이거 진짜 3줄 이후로 안나옴?? 이거 진짜 3줄 이후로 안나옴??
 </div>
</div>


//마지막 + 버튼 장착
<div class="item lc-center" >
 <div class="icon-plus" onClick="location.href='/diary/guide'"></div>
 <!-- <div class="ic-add-diary"></div> -->
</div>
*/