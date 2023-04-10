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
	
	function viewObj() {
		console.log(diaryObj);
	}
	
	
	//기분 옵션을 눌렀을때
	feelDiv.onclick = function (e){
		
		// 리스트 태그가 아니면 돌아가
		if(e.target.tagName != "LI")
			return;			
	
		let valueArr = ['angry','awkward','calm','disappointed','anxiety','happy','sad','tocuhed','excited'];	
		let value = e.target.getAttribute('value');
	
		console.log(`선택한 리스트 : ${value}`);
		
		for(let i=0; i< valueArr.length; i++){
			
			if(valueArr[i] === value){
				diaryObj.feelingId = i+1;
				break;
			}		
		}
		
		// getValueIndex(value, valueArr, diaryObj.feelingId);
		viewObj();
	};
	
	tmpDiv.onclick = function (e){
		if(e.target.tagName != "LI")
			return;			
		let valueArr = ['free-form','thanks-form','meat-form', 'question-form', 'movie-form','trip-form'];
		let value = e.target.getAttribute('value');
		
		for(let i=0; i< valueArr.length; i++){
			
			if(valueArr[i] === value){
				diaryObj.templateId = i+1;
				break;
			}		
		}
			
		// getValueIndex(value, valueArr, id);		
		viewObj();	
	}	
	

	weatherDiv.onclick = function(e){
		if(e.target.tagName != "LI")
			return;			
		
		let valueArr = ['sunny','cloudy','snow','rain','dust'];
		let value = e.target.getAttribute('value');
		
		for(let i=0; i< valueArr.length; i++){
			
			if(valueArr[i] === value){
				diaryObj.weatherId = i+1;
				break;
			}		
		}
		
		// getValueIndex(value, valueArr, weatherId);		
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
	function getValueIndex(value, arr, id){
		for(let i=0; i < arr.length; i++){
			if(arr[i] === value){
				id = i+1;
				break;
			}
		}
	};
	
	
}); //로드했을 때 더해준다. end
	
	
	
	