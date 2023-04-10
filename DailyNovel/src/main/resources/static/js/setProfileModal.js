// 모달-----------------------------------------------------
window.addEventListener("load", function() {
	// 모달창 열기
	const testBtn = document.querySelector("#test-btn");
	const modal = document.querySelector(".modal");
	const closeBtn = document.querySelector(".close");

	let setTime =  testBtn.onclick= function(e){
		modal.style.display = "flex";
		setTimeout(function(){
			modal.style.display = "none";
			console.log("없으면 어떻게 됩니까?");
		//cleanclearInterval(setTime);   // 셋타임아웃 반복 끄기, 근데 없어도 그냥 꺼지는 거 같다.
		},5000);
};
		
//	closeBtn.onclick = function() {
//		modal.style.display = "none";
//	}
});