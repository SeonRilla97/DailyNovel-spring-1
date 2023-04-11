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
	
	//유효성 검사를 통과하면 초록색 실패하면 빨간색에 유효성 검사 보여주기
	const emailLabel = document.querySelector("label[for='email']");
	const pwdLabel = document.querySelector("label[for='pwd']");
	const pwdCheckLabel = document.querySelector("label[for='id-check']");
	const nicknameLabel = document.querySelector("label[for='nickname']");
	const phoneCheckLabel = document.querySelector("label[for='phone']");
	
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
		emailCheckBtn.disabled = true;

	signUpForm.addEventListener('keydown', (e) => {
		if (e.key === "Enter") {
			e.preventDefault();
		}
	});
	signUpForm.addEventListener('submit', (e)=>{
		if(	
		isValidatePhone &&
			 isEamilValidate &&
			 isValidatePwd &&
			 ischeckPwd&&
			 isNicknameCheck&&
		 	 isValidatePhone &&
		 	 isemailCheckNum
			
		){
			console.log("성공!")
			
		}
		else{
			e.preventDefault();
			console.log("실패!")
		}
		
	});
	


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


	

  	let isEmailCheck = false;

if(emailCheckBtn)
	emailCheckBtn.addEventListener('click', function() {

		let emailCheck = email.value;
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/mailCheck?email=' + emailCheck);
		xhr.onload = function() {
			if (xhr.status === 200) {
				console.log('data: ' + xhr.responseText);
				code = xhr.responseText;
				if(code=='false'){
					isEmailCheck = false;
					emailLabel.style.color = "red";
					alert("중복된 이메일 입니다. ");
				}
				else{
					emailLabel.style.color = "#69BC80";
					isEmailCheck = true;
				alert('인증번호가 전송되었습니다.');
				}
			}

		};
		xhr.send();
	});


	let 	isemailCheckNum =false;
	function ValidateEmailNumber(){
		emailCheckNumber = emailCheckNum.value;
		
		console.log(emailCheckNumber);
		
		const ValidateEmailNum ={
			method:"get"
		};
		fetch("http://localhost:8080/user/emailCheckNum?emailCheckNum="+emailCheckNumber)
		.then(response =>response.text())
		.then(data=>{
			if(data=="true"){
				isemailCheckNum = true;
			}
			else{
					isemailCheckNum = false;
			}
		});

	};



if(emailCheckNum)	emailCheckNum.addEventListener('change',ValidateEmailNumber);
if(email)			email.addEventListener('change', ValidateEmail);
if(pwd)				pwd.addEventListener('input', ValidatePwd);
if(pwdCheck)		pwdCheck.addEventListener('input', updatecheckPwd);
if(phoneNum)		phoneNum.addEventListener('input', ValidatePhone);
if(nickName)		nickName.addEventListener('input',nicknameCheck);

};