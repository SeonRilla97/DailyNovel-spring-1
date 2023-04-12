	const email = document.querySelector("#email");
	const emailCheckNum = document.querySelector("#email-check");
	const emailCheckBtn = document.querySelector("#email-check-btn"); //인증번호 전송
	const emailLabel = document.querySelector("label[for='email']");

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

if(emailCheckBtn)
		emailCheckBtn.disabled = true;
	// 이메일 유효성 검사
	let isEamilValidate = false;
	function ValidateEmail() {
		const checkMail = email.value;
		const emailReg = new RegExp(/^[a-zA-Z0-9+-_.]+@[a-zA-Z-]+\.[a-zA-Z-.]+$/);
		if (emailReg.test(checkMail)) {
			emailLabel.style.color = "#69BC80";
			isEamilValidate = true;
			emailCheckBtn.disabled = false;
			return (true);
		}

		emailLabel.style.color = "red";
		isEamilValidate = true;
		emailCheckBtn.disabled = true;
		return (false)
	}
	

if(emailCheckBtn)
	emailCheckBtn.addEventListener('click', function() {

		let emailCheck = email.value;
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/account-recovery/mailCheck?email=' + emailCheck);
		xhr.onload = function() {
			if (xhr.status === 200) {
				console.log('data: ' + xhr.responseText);
				code = xhr.responseText;
				if(code=='false'){
					isEmailCheck = false;
					emailLabel.style.color = "red";
					alert("가입되어 있지 않는 이메일 입니다. ");
				}
				else{
					emailLabel.style.color = "#69BC80";
					isEmailCheck = true;
				alert('임시 비밀번호가 발급되었습니다.');
				}
			}

		};
		xhr.send();
	});
	
	
if(emailCheckNum)	emailCheckNum.addEventListener('change',ValidateEmailNumber);
if(email)			email.addEventListener('change', ValidateEmail);
	