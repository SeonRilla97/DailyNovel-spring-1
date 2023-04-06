window.addEventListener("load", function(){
	
	


let weatherValue;
let tmpValue;
let feelingValue;
let titleValue;
let contentValue;
let dateValue;
let honestyValue;

let diaryObj = {
	date: null,
	title: null,
	content: null,
	tmp: null,
	weather: null,
	feeling: null, 
	honesty: null	
};

viewObj();

const submitBtn = document.querySelector('#register-btn');


let feelDiv = document.querySelector("#reg-feel-modal");
let tmpDiv = document.querySelector("#reg-tmp-modal");
let weatherDiv = document.querySelector("#reg-weather-modal");
let honestyDiv = document.querySelector("#reg-honesty-modal");
let 

function viewObj() {
	console.log(diaryObj);
}


//기분 옵션을 눌렀을때
feelDiv.onclick = function (e){
	
	// 리스트 태그가 아니면 돌아가
	if(e.target.tagName != "LI")
		return;			
	
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

honestyDiv.onclick = function(e){
	if(e.target.tagName != "INPUT")
		return;	
				
	console.log("되고있는것인가");
//	diaryObj.honesty = e.target.getAttribute('value');
	viewObj();
}

submitBtn.addEventListener('click',()=>{
	console.log(diaryObj);
})


}); //로드했을 때 더해준다. end



