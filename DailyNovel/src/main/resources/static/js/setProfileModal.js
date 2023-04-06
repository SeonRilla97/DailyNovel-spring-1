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
		cleanclearInterval(setTime);
		},5000);
};
		
	closeBtn.onclick = function() {
		modal.style.display = "none";
	}


/*	// 추가: 모달창 열어서 텍스트 변경하기
	modal.addEventListener("click", function(e) {
		// 모달창 바깥을 클릭했을 때 모달창 닫기
		if (e.target == this) {
			modal.style.display = "none";
		}
	});*/
});