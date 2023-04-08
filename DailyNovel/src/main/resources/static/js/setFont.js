// 폰트크기 및 폰트사이즈----------------------------------------------------
window.addEventListener("load", function() {
	let fontAdjuster = document.querySelector(".font-adjuster");
	let content = document.querySelector(".content");
	let fontApply = document.querySelector("input[type=submit]");
	let fontInit = document.querySelector("input[type=reset]");

	content.style.fontSize = fontAdjuster.value + "px";

	fontAdjuster.oninput = function(e) {
		console.log(fontAdjuster.value);
		content.style.fontSize = fontAdjuster.value + "px";
	};

	fontApply.onclick = function() {

		content.style.fontSize = fontAdjuster.value + "px";
		console.log("tlqk")
	}

	fontInit.onclick = function() {

		content.style.fontSize = 16 + "px";
		console.log("초기화")
	}
});


