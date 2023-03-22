
// 프로필-------------------------------------------

window.addEventListener("load",function(){
    let s1 = document.querySelector("section");
    let profileBtn = s1.querySelector(".upload-btn");
    let profileTrigerBtn = s1.querySelector(".pro-img");

    profileTrigerBtn.onclick = function(){       // 프로필 이미지를 누르면 input type="file"이 실행되는 트리거
        let event = new MouseEvent("click", {
            'view':window,
            'bubbles': true,
            'cancelable':true
        });
        profileBtn.dispatchEvent(event)
    }
});

function updateImg(){
    let proImg = document.querySelector(".pro-img")
    let imageBG = document.querySelector("section");
    let file = document.querySelector(".upload-btn").files[0];
    let reader = new FileReader();
    reader.onloadend = function () {
        proImg.style.backgroundImage = "url(" + reader.result + ")";
        
    };

    //if (file) reader.readAsDataURL(file);
    if (file) {
        reader.readAsDataURL(file);
        console.log("파일 선택");
      }
    else{ 
        proImg.style.backgroundImage = "";
        //proImg.style.backgroundImage = "url()";
        //proImg.style.backgroundColor = "red";
        console.log("파일 미 선택");
}
};


// 모달-----------------------------------------------------
window.addEventListener("load", function() {
    // 모달창 열기
    const modalBtns = document.querySelectorAll(".modalBtn");
    const modal = document.querySelector(".modal");
    const closeBtn = document.querySelector(".close");

    modalBtns.forEach(function(btn) {
      btn.onclick = function() {
        modal.style.display = "block";
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

// 폰트크기 및 폰트사이즈----------------------------------------------------
window.addEventListener("load", function() {
  let fontAdjuster = document.querySelector(".font-adjuster");
  let content = document.querySelector(".content");
  let fontApply = document.querySelector("input[type=submit]");
  let fontInit = document.querySelector("input[type=reset]");

  fontAdjuster.oninput = function(e){
    console.log(fontAdjuster.value);
    content.style.fontSize=fontAdjuster.value+"px";
  };

  fontApply.onclick=function(){

    content.style.fontSize=fontAdjuster.value+"px";
    console.log("tlqk")
  }

  fontInit.onclick=function(){

    content.style.fontSize=16+"px";
    console.log("초기화")
  }
});









