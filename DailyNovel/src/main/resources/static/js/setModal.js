// 모달-----------------------------------------------------
window.addEventListener("load", function() {
	// 모달창 열기
	const modalBtns = document.querySelectorAll(".modalBtn");
	const modal = document.querySelector(".modal");
	const closeBtn = document.querySelector(".close");

	modalBtns.forEach(function(btn) {
		btn.onclick = function() {
			modal.style.display = "flex";
			// 모달창을 띄운 버튼에 해당하는 p 요소를 찾아서 targetP 변수에 할당
			targetP = this.querySelector("p");
		}
	});

	closeBtn.onclick = function() {
		modal.style.display = "none";
	}

	const cancelBtn = document.querySelector("#cancelBtn");
	cancelBtn.onclick = function() {
		modal.style.display = "none";
		//   textInput.value = "";
	}
});