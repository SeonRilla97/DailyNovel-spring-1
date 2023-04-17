
// 프로필-------------------------------------------

window.addEventListener("load", function() {
	let s1 = document.querySelector("section");
	let profileBtn = s1.querySelector(".upload-btn");
	let profileTrigerBtn = s1.querySelector(".pro-img");

	profileTrigerBtn.onclick = function() {       // 프로필 이미지를 누르면 input type="file"이 실행되는 트리거
		let event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});
		profileBtn.dispatchEvent(event)
	}
});

function updateImg() {
	let proImg = document.querySelector(".pro-img")
	let imageBG = document.querySelector("section");
	let file = document.querySelector(".upload-btn").files[0];
	let reader = new FileReader();
	reader.onloadend = function() {
		proImg.style.backgroundImage = "url(" + reader.result + ")";

	};

	//if (file) reader.readAsDataURL(file);
	if (file) {
		reader.readAsDataURL(file);
	}
	else {
		proImg.style.backgroundImage = "";
		//proImg.style.backgroundImage = "url()";
		//proImg.style.backgroundColor = "red";
	}
};
