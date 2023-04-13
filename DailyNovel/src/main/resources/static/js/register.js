window.addEventListener("load", function(){
	let diaryObj = {
		memberId: 1,
		regDate: "",
		title: null,
		content: null,
		templateId: null,
		weatherId: null,
		feelingId: null, 
		honesty: 100	
	};	
	
	const queryString = this.window.location.search;
	const params = new URLSearchParams(queryString);
	const tmpName = params.get('tmp');

	let tmpValueArr = ['free-form','thanks-form', 'meat-form', 'question-form', 'movie-form','trip-form'];
	let tmpValueKrArr = ['자유', '감사', '밥', '질문', '영화', '여행'];
	let tmpTxt = document.querySelector(".reg-tmp-txt");

	for(let i=0; i < tmpValueArr.length; i++){
		if(tmpName == tmpValueArr[i]){
			tmpTxt.innerText = tmpValueKrArr[i];				
			break;
		}
	}	
	diaryObj.templateId = getValueIndex(tmpName,tmpValueArr);


	//let diaryObj = {
	//	"member": null,
	//	"date": null,
	//	"title": null,
	//	"content": null,
	//	"tmp": null,
	//	"weather": null,
	//	"feeling": null, 
	//	"honesty": null	
	//};
	
	viewObj();

	// 날짜 관련 부분
	const date = new Date();
	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const day = String(date.getDate()).padStart(2, '0');
	const hour = String(date.getHours()).padStart(2, '0');
	const minute = String(date.getMinutes()).padStart(2, '0');
	const second = String(date.getSeconds()).padStart(2, '0');
	
	// let month = Sdate.getMonth() + 1;
	// let day = date.getDate();
	// let hour = date.getHours();
	// let minute = date.getMinutes();
	// let second = date.getSeconds();	
	// const year = date.getFullYear();

	let dateTxt = document.querySelector("#date");
	console.log(`${year}년 ${month}월 ${day}일 ${hour}시 ${minute}분 ${second}초`);
	
	console.log("iso" + date.toISOString());
	console.log("localedate" + date.toLocaleDateString());

	diaryObj.regDate = `${year}/${month}/${day} ${hour}:${minute}:${second}`;
	console.log(diaryObj.regDate);
	dateTxt.innerText = `${year}년 ${month}월 ${day}일`;
	


	const submitBtn = document.querySelector('#submit-test');	
	let honestyRange = document.querySelector(".reg-honesty-test");
	let titleEditor = document.querySelector(".editor-title");
	let contentEditor = document.querySelector("#content-editor");
	
	// 모달들
	let feelDiv = document.querySelector("#reg-feel-modal");
	let tmpDiv = document.querySelector("#reg-tmp-modal");
	let weatherDiv = document.querySelector("#reg-weather-modal");
	let honestyDiv = document.querySelector("#reg-honesty-modal");
	
	// 아이콘 나오는 상자들
	let feelBox = this.document.querySelector("#feel-value");
	let weatherBox = this.document.querySelector("#weather-value");
	let feelArr = ['null','angry','awkward','calm','disappointed','anxiety','happy','sad','tocuhed','excited'];	
	let weatherArr = ['null','sunny','cloudy','snow','rain','dust'];

	// 작성 방법 변경 버튼
	let chgTmpBtn = this.document.querySelector("#chg-tmp-btn");
	let chgTmpValue = "free-form";

	if((diaryObj.feelingId == null && diaryObj.weatherId == null)){
		feelBox.classList.add("null-circle-img");
		weatherBox.classList.add("null-circle-img");
	}

	chgTmpBtn.addEventListener('click',()=>{
		chgTmpBtn.href = `/member/diary/register?tmp=${chgTmpValue}`;
	})


	// json 콘솔로 확인용
	function viewObj() {
		console.log(diaryObj);
	}	
	

	//기분 옵션을 눌렀을때
	feelDiv.onclick = function (e){
		
		// 리스트 태그가 아니면 돌아가
		if(e.target.tagName != "LI")
			return;			
	
		let valueArr = ['angry','awkward','calm','disappointed','anxiety','happy','sad','touched','excited'];	
		let value = e.target.getAttribute('value');
		
		// li를 선택했다면 닷트 원 없어지도록
		if(diaryObj.feelingId === null){
			feelBox.classList.remove("null-circle-img");
		}

		for(let i=0; i < valueArr.length; i++){
			if(value == valueArr[i]){
				let classNames = feelBox.classList;
				feelBox.classList.remove(classNames[1]);
				feelBox.classList.add(`${value}-img`);
				// feelBox.classList.replace(classNames[1],`${value}-img`);
				break;
			}
		}
		

		console.log(`선택한 리스트 : ${value}`);		
		diaryObj.feelingId = getValueIndex(value, valueArr);
		

		viewObj();
	};
	tmpDiv.onclick = function (e){
		if(e.target.tagName != "LI")
			return;

		chgTmpValue = e.target.getAttribute('value');
	}

	// tmpDiv.onclick = function (e){
	// 	if(e.target.tagName != "LI")
	// 		return;			
	// 	let valueArr = ['free-form','thanks-form','meat-form', 'question-form', 'movie-form','trip-form'];
	// 	let valueKrArr = ['자유', '감사', '밥', '질문', '영화', '여행'];

	// 	let value = e.target.getAttribute('value');
	// 	let txt = document.querySelector(".reg-tmp-txt");
	// 	for(let i=0; i < valueArr.length; i++){
	// 		if(value == valueArr[i]){
	// 			txt.innerText = valueKrArr[i];				
	// 			break;
	// 		}
	// 	}	
	// 	diaryObj.templateId = getValueIndex(value,valueArr);
		
	// 	viewObj();	
	// }	
	

	weatherDiv.onclick = function(e){
		
		// if(e.target.tagName != "LI")
		// 	return;			
		
		let valueArr = ['sunny','cloudy','snow','rain','dust'];
		let value = e.target.parentElement.getAttribute('value');
		
		// li를 선택했다면 닷트 원 없어지도록
		if(diaryObj.weatherId === null){
			weatherBox.classList.remove("null-circle-img");
		}

		for(let i=0; i < valueArr.length; i++){
			if(value == valueArr[i]){
				let classNames = weatherBox.classList;
				weatherBox.classList.remove(classNames[1]);
				weatherBox.classList.add(`${value}-img`);
				// feelBox.classList.replace(classNames[1],`${value}-img`);
				break;
			}
		}

		diaryObj.weatherId = getValueIndex(value,valueArr);
		viewObj();
	}
	
	
	titleEditor.addEventListener('change',()=>{
		diaryObj.title = titleEditor.value;
		
		viewObj();	
	})
	
	contentEditor.addEventListener('change',()=>{
		diaryObj.content = contentEditor.value;
		viewObj();	
	})	
	
	submitBtn.addEventListener('click',()=>{
		diaryObj.honesty = honestyRange.value;
		console.log(diaryObj);
	
	// 객체 json 파싱
	//let diaryJSON = JSON.parse(diaryObj);
	let diaryJSON = diaryObj;
	
	// post 전송 부분
	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
	
	var raw = JSON.stringify(diaryJSON);
	
	var requestOptions = {
	  method: 'POST',
	  headers: myHeaders,
	  body: raw,
	  redirect: 'follow'
	};
	
	fetch("http://localhost:8080/diarys", requestOptions)
	  .then(response => response.text())
	  .then(result => console.log("성공"))
	  .catch(error => console.log('error', error));
	
	
	})
	
	// db 인덱스 구하는 메서드. 
	function getValueIndex(value, arr){
		let id = 0;
		for(let i=0; i < arr.length; i++){
			if(arr[i] === value){
				id = i+1;
				return id;
			}
		}
	};
	
	
}); //로드했을 때 더해준다. end
	
	
	
	