// 폰트크기 및 폰트사이즈----------------------------------------------------
window.addEventListener("load", function() {
/* 폰트관련 */

	
/* 폰트사이즈 관련 */	
	let fontAdjuster = document.querySelector(".font-adjuster");
	let content = document.querySelector(".content");
	let fontApply = document.querySelector("input[type=submit]");
	let fontInit = document.querySelector("input[type=reset]");
	
	let existSize = fontAdjuster.value;
	content.style.fontSize = fontAdjuster.value + "px";

	fontAdjuster.oninput = function(e) {
		console.log(fontAdjuster.value);
		content.style.fontSize = fontAdjuster.value + "px";
	};

	fontApply.onclick = function() {
		alert("변경되었습니다.");
		content.style.fontSize = fontAdjuster.value + "px";
		console.log("tlqk")
	}

	fontInit.onclick = function() {

		content.style.fontSize = existSize + "px";

		console.log("초기화");
	}
});


