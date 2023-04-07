window.addEventListener("load", function(){
	
	


let weatherValue;
let tmpValue;
let feelingValue;
let titleValue;
let contentValue;
let dateValue;
let honestyValue;

let diaryObj = {
	member_id: 1,
	date: null,
	title: null,
	content: null,
	tmp: null,
	weather: null,
	feeling: null, 
	honesty: null	
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

const submitBtn = document.querySelector('#submit-test');


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
	let valueArr = ['happy','sad','excited','비','먼지'];
	
	let value = e.target.getAttribute('value');
	
	for(let e in valueArr){
		if(e == value){
			console.log(`${value}나온다아아아ㅏ`);
			break;
		}		
	}
	
	diaryObj.feeling = e.target.getAttribute('value');
	
	console.log("볼까: ", e.target.getAttribute('value'));
	viewObj();
};

tmpDiv.onclick = function (e){
	if(e.target.tagName != "LI")
		return;			
	
	diaryObj.tmp = e.target.getAttribute('value');
	viewObj();	
}

weatherDiv.onclick = function(e){
	if(e.target.tagName != "LI")
		return;			
	
	diaryObj.weather = e.target.getAttribute('value');
	viewObj();
}

let honestyRange = document.querySelector(".reg-honesty-test");

let titleEditor = document.querySelector(".editor-title");
let contentEditor = document.querySelector("#content-editor");

titleEditor.addEventListener('change',()=>{
	diaryObj.title = titleEditor.value;
	
	viewObj();	
})

contentEditor.addEventListener('change',()=>{
	diaryObj.content = contentEditor.value;
	viewObj();	
})

//honestyDiv.onclick = function(e){
//	
//	if(e.target.tagName != "INPUT")
//		return;		
//	
//	console.log("되고있는것인가");
//	diaryObj.honesty = honestyRange.value;
//	viewObj();
//}

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



}); //로드했을 때 더해준다. end



