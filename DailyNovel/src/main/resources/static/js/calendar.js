
    // =========== 달력을 그리기 위해 DOM으로 접근할 태그들 ===========
let calHeader = document.querySelector("#calendar-header"), //헤더 담당
calDate = document.querySelector("#calendar-date");//날짜 그리기 담당

// =========== 달력에 오늘을 넣기 위해 값을 삽입 ===========
let curdate = new Date();
    let year = curdate.getFullYear();//년
    let month = curdate.getMonth();//월
    let date = curdate.getDate();//일
    let day = curdate.getDay();//요일


    // =========== 달력 Header 부분 Tag 생성 ===========

    // =========== 달력 넘기기 버튼 리스너들 ===========
    const prevMonthBtn= document.querySelector("#prev-btn");
    prevMonthBtn.addEventListener('click',()=>{
        console.log("동작");
        month--;
        drawDate();
    });

    const nextMonthBtn= document.querySelector("#next-btn")
    nextMonthBtn.addEventListener('click',()=>{
        month++;
        drawDate();
        console.log("동작");
    });
const yearMonthTag = document.querySelector("#date-config")

function drawDate() {
    let dateCount = 0;


    // =========== 달력에 표시할 날 세팅 ===========        
    curdate = new Date(year, month, date, day)


    // =========== 날짜 그리기 위해 필요한 변수들 ===========    
    year = curdate.getFullYear();//년
    month = curdate.getMonth();//월
    date = curdate.getDate();//일
    day = curdate.getDay();//요일


    // =========== 날짜 그리기 위해 필요한 변수들 ===========
    let prevLastDay = new Date(year, month, 0).getDay(); //전달 끝 요일
    let prevLastDate = new Date(year, month, 0).getDate(); // 전달 말일
    let curDay = new Date(year,month,1).getDay(); //이달 첫 요일
    let curLastDay = new Date(year,month+1,0).getDate(); //이달 말일
    let nextFirstDay = new Date(year, month+1, 1).getDay(); //다음달 첫 요일

    let dateList = ""; //날짜 표시할 태그 
    yearMonthTag.innerText=`${year}년 ${month+1}월`;
    //현재 달(전달, 다음달 넘어가기 버튼)
   
    // =========== 날짜 그리기 ===========
    let tmpPrevDate = prevLastDate;
    for(let i=0 ; i<=prevLastDay;i++){
        // console.log(tmpPrevDate+i-prevLastDay); //전 달 채우기
        dateList+= `<li class ="inactive mgt-3 lc-center">${tmpPrevDate+i-prevLastDay}</li>`; //전 달 말일까지 표시
        dateCount++;
    }
    for(let i =0 ;i < curLastDay;i++){
        // console.log(i+1);//이달 채우기(스타일 바꾸려면 아마 여기에다 if 써서 추가해야함)
        //나중에 일기 쓴 날 표시, 오늘 표시 같은것들
        dateList+= `<li class ="active mgt-3 lc-center">${i+1}</li>`; //1일부터 차례대로 
        dateCount++;
    }
    let nextDay = 1;
    for(let i=nextFirstDay;i<=6;i++){
        // console.log(nextDay++); //다음달 채우기 이거 다시생각
        dateList += `<li class ="inactive mgt-3 lc-center">${nextDay++}</li>`;
        dateCount++;
    }
    if(dateCount<42){
        for(let i = 0 ; i < 7; i++){
        dateList += `<li class ="inactive mgt-3 lc-center">${nextDay++}</li>`;
        }
    }
    // =========== 날짜 삽입 코드(실제로 날짜는 여기서 HTML에 삽입됨) ===========
    calDate.innerHTML = dateList ;
}  //달력 그리기 함수 끝!





//최초 달력 동작 (오늘을 기준으로 날짜가 뜰거임)
drawDate();







// 달력의 이번달 날짜를 클릭하면 밑에 미리보기, 작성버튼가 뜨는 코드 작성
// 스타일만 잡아두고, 나중에 DB연동 하고 데이터 쌓일때 부터 동작 확인 가능함