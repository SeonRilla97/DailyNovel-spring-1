// 폰트크기 및 폰트사이즈----------------------------------------------------
/* 폰트관련 */

let fontRadios = document.querySelectorAll(".flex-jfy-center input[type=radio]");

const dbFont = document.querySelector('.dbFont').textContent;
//console.log(dbFont);

fontRadios.forEach(radio => {
  radio.onchange = () => {
    // 선택된 체크박스의 값을 가져옵니다.
    var selectedFontId = radio.value;

    // 폰트 변경 함수 호출
    changeFont(selectedFontId);
  };
});


function changeFont(selectedFontId) {
  // 선택된 체크박스에 맞는 클래스 이름을 생성합니다.
  var selectedFontClass = "";
  switch(selectedFontId) {
    case "1":
      selectedFontClass = "noto-sans-k";
      break;
    case "2":
      selectedFontClass = "nanum-pen-s";
      break;
    case "3":
      selectedFontClass = "sunflower";
      break;
    case "4":
      selectedFontClass = "dongle";
      break;
  }

  // "content" 요소에 선택된 폰트 클래스를 추가합니다.
  var contentElem = document.querySelector(".content");
  contentElem.classList.remove("noto-sans-k", "nanum-pen-s", "sunflower", "dongle"); // 기존 클래스 제거
  contentElem.classList.add(selectedFontClass); // 선택한 폰트 클래스 추가
}

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
		/* 폰트사이즈 db값으로 변경 */
		content.style.fontSize = existSize + "px";
		/* 폰트 db값으로 변경 */
   		changeFont(dbFont);
		contentElem.classList.remove("noto-sans-k", "nanum-pen-s", "sunflower", "dongle"); // 기존 클래스 제거
		contentElem.classList.add(selectedFontClass);
		console.log("초기화");
	}