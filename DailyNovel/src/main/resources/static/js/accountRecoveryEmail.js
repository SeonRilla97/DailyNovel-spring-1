
window.onload = function() {
	const email = document.querySelector("#email");
	const emailCheckNum = document.querySelector("#email-check");
	const emailCheckBtn = document.querySelector("#email-check-btn"); //인증번호 전송
	const pwd = document.querySelector("#pwd");
	const pwdCheck = document.querySelector("#pwd-check");
	const nickName = document.querySelector("#nickname");
	const phoneNum = document.querySelector("#phone");
	const phoneCheck = document.querySelector("#phone-check");
	const submitBtn = document.querySelector("#submit-Btn");
	// Form 태그의 Input Tag에 커서를 주고 Enter 누르면 제출되는 문제 해결
	const signUpForm = document.querySelector("#sign-up-form");
	const nickname = document.querySelector("#nickname"); 
	//유효성 검사를 통과하면 초록색 실패하면 빨간색에 유효성 검사 보여주기
	const emailLabel = document.querySelector("label[for='email']");
	const pwdLabel = document.querySelector("label[for='pwd']");
	const pwdCheckLabel = document.querySelector("label[for='id-check']");
	const nicknameLabel = document.querySelector("label[for='nickname']");
	const phoneCheckLabel = document.querySelector("label[for='phone']");
	
	
	
	   signUpForm.addEventListener('keydown', (e) => {
      if (e.key === "Enter") {
         e.preventDefault();
      }
   });
   
	
	// ===============회원가입 css 스타일==========
	const outBox = document.querySelectorAll(".outBox");
	//여기에 유효성검사 까지 들어간다면 어떻게 되는거지???
	//이거 쓸 경우, outbox 내부에는 input이 하나만 있어야 합니다.
	outBox.forEach(e => {
		e.addEventListener("keyup", ()=>{
			let value = e.querySelector("input").value

			if(!value== ''){
				//빈 값이 아닌 경우
				e.classList.add('existence');   
			}else{
				//빈 값인 경우
				e.classList.remove('existence');   
			}
		});
	});


//==============================================


if(emailCheckBtn)
	emailCheckBtn.addEventListener('click', function() {

		let emailCheck = email.value;
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/account-recovery/nicknameCheck?nickname=' + emailCheck);
		xhr.onload = function() {
			if (xhr.status === 200) {
				console.log('data: ' + xhr.responseText);
				code = xhr.responseText;
				if(code=='false'){
				
					emailLabel.style.color = "red";
					nickname.innerHTML +=  "존재하지 않습니다.";
				}
				else{

					emailLabel.style.color = "#69BC80";		
				nickname.innerHTML = maskEmail(code, 4)+" 입니다.";
				}
			}

		};
		xhr.send();
	});



function maskEmail(email, visibleLength) {
  let atIndex = email.indexOf('@')+6;
  let username = email.substring(0, atIndex);
  let domain = email.substring(atIndex);

  let visibleUsername = username.substring(0, visibleLength);
  let maskedUsername = 'x'.repeat(username.length - visibleLength);

  return visibleUsername + maskedUsername + domain;
}


};