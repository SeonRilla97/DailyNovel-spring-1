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
			console.log(textInput.value)
		}
	});

	closeBtn.onclick = function() {
		modal.style.display = "none";
	}

	// 입력된 텍스트 가져오기
	const submitBtn = document.querySelector("#submitBtn");
	// const textInput = document.querySelector("#textInput");
	const textInput = document.querySelector(".textInput");
	let targetP;

	submitBtn.onclick = function() {
		const inputText = textInput.value;
		// 모달창을 띄운 버튼에 해당하는 p 요소에 입력된 값 할당
		targetP.innerText = inputText;
		modal.style.display = "none";
	}

	const cancelBtn = document.querySelector("#cancelBtn");
	cancelBtn.onclick = function() {
		modal.style.display = "none";
		//   textInput.value = "";
	}

	// 추가: 모달창 열어서 텍스트 변경하기
	modal.addEventListener("click", function(e) {
		// 모달창 바깥을 클릭했을 때 모달창 닫기
		if (e.target == this) {
			modal.style.display = "none";
		}
	});
	targetP.onclick = function() {
		textInput.value = targetP.innerText;
		modal.style.display = "block";
	}
});