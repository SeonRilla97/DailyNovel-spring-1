//메인 인삿말 랜덤

const HITEXT = ["당신의 하루를 들려주세요","어쩌라고!","소소한 일상과 나만의 이야기","마음먹은 대로 잘 될거에요"
,"내일은 영화보러 갈까요","나만의 여행을 계획하기","나는 더 나은 미래를 위해 싸운다","두려움이 가장 큰 적이다."]

let addHello = document.querySelector("#add-hello");
// console.log(Math.floor(Math.random() * HITEXT.length))
addHello.insertAdjacentHTML('beforeend',`<div class="h2 mgt-2">${HITEXT[Math.floor(Math.random() * HITEXT.length)]}`)





//메인 사진 랜덤
const header = document.querySelector("header");//header 
const bg = document.querySelector("#background"); //배경
//
let bgHeight = ((header.offsetHeight)+(addHello.offsetHeight)); //인삿말 + 헤더
bg.style.height= `${bgHeight}px`; //스타일 적용 (크기 변경)
const BACKGROUNDLIST  = ["/img/DiaryMainPage/Spring.png","/img/DiaryMainPage/Summer.png","/img/DiaryMainPage/autumn.png","/img/DiaryMainPage/winter.png"]
bg.src = BACKGROUNDLIST[Math.floor(Math.random() * BACKGROUNDLIST.length)];



function callbackforDiaryPreview(result) {
    const diaryData = result;
    // console.log(diaryData);
    let activedDate =document.querySelectorAll(".calender .date .circle-li");
    let sliderAboutDate = document.querySelector("#previewSlider")
    // console.log(diaryData);
    let htmlText = "";
//    console.log(activedDate);
    for(let acDate of activedDate){
        //클릭 이벤트 달기
        acDate.onclick = function() {
//            console.log(acDate.textContent);
            let curDate = acDate.textContent;
            htmlText = "";

            // let firstDiaryPreviewContent;
            //미리보기에 값 넣기
            if(diaryData[curDate]){ 
                // for(let diary of diaryData[curDate]){
                for (let index = 0 ; index < diaryData[curDate].length ; index++){
                    diary = diaryData[curDate][index];
                    // if(index ==0 ){폐기 - 1 조장님이 꺼지랭}
                    //     //미리보기의 첫번째 텍스트 컨텐츠를 효과를 주기 위해 뺀다.
                    //     firstDiaryPreviewContent = diary.content;
                    //     console.log(diary.content);
                    //     htmlText += `<div class="item item-diary" onClick ="location.href='/member/diary/detail?diaryId=${diary.diaryId}'">
                    //     <div class="h2">${diary.title}</div>
                    //     <div class ="active" id="preview-content">
                    //     </div>
                    //    </div>`;
                    //    continue;
                    // }
                    htmlText += `<div class="item item-diary" onClick ="location.href='/member/diary/detail?diaryId=${diary.id}'">
                    <div class="h2">${diary.title}</div>
                    <div>
                        ${diary.content}
                    </div>
                   </div>`;
                }
            }   
            htmlText+= `<div class="item lc-center" >
            <div class="icon-plus" onClick="location.href='/member/diary/guide'"></div>
            <!-- <div class="ic-add-diary"></div> -->
           </div>`
            // 페이지 네이션 달기
            htmlText+=` <div class="prev-btn btn">◀</div>
            <div class="next-btn btn">▶</div>
            <ul class="pagination pagination-main"></ul>`
            //미리보기 그리기
            sliderAboutDate.innerHTML=htmlText;
            //미리보기에 슬라이더 (페이지네이션) 붙이기
            new slide(
                ".slider", //
                ".slider .prev-btn",
                ".slider .next-btn",
                ".slider .item",
                ".slider .pagination",
                ".slider .pagination > li" 
                );

                //미리보기 첫 데이터 transition 발생
            let PreviewOne = sliderAboutDate.querySelector(".slider .item-diary:nth-child(1) div:nth-child(1)");
            let PreviewTwo = sliderAboutDate.querySelector(".slider .item-diary:nth-child(1) div:nth-child(2)");
            if(PreviewOne){
                PreviewOne.classList.add("active");
                PreviewTwo.classList.add("active");
            }
                //첫번째 미리보기 글쓰기 위한 코드(폐기-1 조장님이 꺼지랭)
            // if(diaryData[curDate]){
            //     //그릴곳 지정
            //     let firstPreview = sliderAboutDate.querySelector("#preview-content");
            //     //그릴 텍스트 받아오기
            //     let content = firstDiaryPreviewContent;
            //     //텍스트가 null이라면 안그리고 return
            //     if(content == null) return;
            //     //글자 하나씩 setTimeout에 각자의 지연시간을 줘서 서서히 나타나게 동작
            //     /* 사실 글씨 다 지우고 새로 그리는 방식이라서 안하고 싶지만,
            //     이게 아니면  appendChild 이용해서 태그를 추가하는 방식으로 span태그가 마구마구 생기는 방식인데
            //     그건 또 하기싫어서 그냥 지우고 새로 그리는 방식으로 합니다.*/
            //     for(let tIdx = 0 ; tIdx <content.length; tIdx++){
            //         setTimeout(function(){
            //         firstPreview.innerHTML += content[tIdx];
            //         },tIdx*50);
            //     }
            // }
        }
    }//클릭이벤트 달기 끝


    //오늘 날짜 그리기
    let today = new Date().getDate();
    // console.log(diaryData[today]);
    for (let index = 0 ; index < diaryData[today].length ; index++){
            diary = diaryData[today][index];
            // if(index ==0 ){폐기 - 1 조장님이 꺼지랭}
            //     //미리보기의 첫번째 텍스트 컨텐츠를 효과를 주기 위해 뺀다.
            //     firstDiaryPreviewContent = diary.content;
            //     console.log(diary.content);
            //     htmlText += `<div class="item item-diary" onClick ="location.href='/member/diary/detail?diaryId=${diary.diaryId}'">
            //     <div class="h2">${diary.title}</div>
            //     <div class ="active" id="preview-content">
            //     </div>
            //    </div>`;
            //    continue;
            // }
            htmlText += `<div class="item item-diary" onClick ="location.href='/member/diary/detail?diaryId=${diary.id}'">
            <div class="h2">${diary.title}</div>
            <div>
                ${diary.content}
            </div>
        </div>`;
        }   
    htmlText+= `<div class="item lc-center" >
    <div class="icon-plus" onClick="location.href='/member/diary/guide'"></div>
    <!-- <div class="ic-add-diary"></div> -->
    </div>`
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
    let PreviewOne = sliderAboutDate.querySelector(".slider .item-diary:nth-child(1) div:nth-child(1)");
    let PreviewTwo = sliderAboutDate.querySelector(".slider .item-diary:nth-child(1) div:nth-child(2)");
    if(PreviewOne){
        PreviewOne.classList.add("active");
        PreviewTwo.classList.add("active");
    }
}


//Main 배경화면 그리기

// console.log(bg);
// console.log(bg.style);
// console.log(bg.style.height);

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



//=========== 태그가  변화될때 이벤트 붙는거 =======
// let mutationCounter = 0;
// let sliderAboutDate = document.querySelector("#previewSlider")
// var observer = new MutationObserver(function(mutations) {
//     mutations.forEach(function(mutation) {
//     mutationCounter++;
//     console.log('태그 구성요소가 변경되었습니다.');

//     if(mutationCounter==2){
//         console.log("2번째 태그 변화 발생(태그생성)");
//         mutationCounter=0;
//     }
//     });
//   });
  
//   var target = document.querySelector('div');
//   var config = { childList: true, subtree: true };
  
//   observer.observe(sliderAboutDate, config);