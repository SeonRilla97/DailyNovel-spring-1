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
			emailLabel.textContent = "이메일";
			emailLabel.style.color = "#69BC80";
			isEamilValidate = true;
			emailCheckBtn.disabled = false;
			return (true);
		}
		emailLabel.textContent = "이메일";
		emailLabel.style.color = "red";
		isEamilValidate = true;
		emailCheckBtn.disabled = true;
		return (false)
	}



	//이메일 인증번호 눌렀을때, 서버로 인증번호 전송해달라고 확인하는 이메일을 보내야함
	function CheckEmailVerify() {
		//서버로부터 확인받아야 하는것
		//0. 이메일 형식이 맞는지 페이지에서 확인해야함 (이때부터는 이메일 변경 하면 안됨)

		//1. 내가 쓴 이메일이 DB에 저장되어 있는 이메일인지 확인해야함 (중복확인)

		//2. 서버는 인증번호를 가지고 있으며 이를 사용자 에게 보내줘야함 (서버도 가지고 있어야함)

		//3. 인증확인은 input 태그가 변화할 시 마다 서버로 확인을 받게 할 예정

	}
	let isValidatePwd =false;
	
	function ValidatePwd() {
		
		const validatePwd = pwd.value;
		checkPwd();
		const PwdReg = new RegExp(/^(?=.*[A-Za-z0-9])(?=.*\d)[A-Za-z0-9\d!@#$%^&*]{8,25}$/);		
		if (PwdReg.test(validatePwd)) {
			console.log("비밀번호 완료!");
			pwdLabel.style.color = "#69BC80";
			pwd.style.color = "#69BC80";
			isValidatePwd=true;
			return (true)
		}
		console.log("비밀번호 실패!");
			isValidatePwd=false;
		pwdLabel.style.color = "red";
		pwd.style.color = "red";
		return (false)
	}
	
	function updatecheckPwd(){
		checkPwd();
		
	}
	
	let ischeckPwd= false;
	function checkPwd() {
		const confirm = pwdCheck.value; //비밀번호 확인인데, 비밀번호 유효성검사와 변수명 겹침
		
		if (confirm == pwd.value) {
			ischeckPwd= true;
			pwdCheck.style.color = "#69BC80";
			pwdCheckLabel.style.color = "#69BC80";
			return true;
		}
		ischeckPwd= false;
		pwdCheck.style.color = "red";
		pwdCheckLabel.style.color = "red";
		return false;
	}
	

	
	let isNicknameCheck =false;
	function nicknameCheck() {
		//중복확인 -> DB와 통신 필요함
		
	const NicknameReg = new RegExp(/^\S{1,6}$/);		
	
	if(NicknameReg.test(nickName.value)){
	const nickCheck={
		method:"get"
	};
	fetch("http://localhost:8080/user/nicknameCheck?nickname="+nickName.value)
	.then(response => response.text())	
	.then(data=>{
		if(nickName.value==""){
			nicknameLabel.style.color ="red";
		}
		else if(data==="success"){
			nicknameLabel.style.color = "#69BC80";	
			isNicknameCheck =true;
		}
		else{
			nicknameLabel.style.color ="red";
		}
		
		});	
	}
	else
			nicknameLabel.style.color ="red";
	}
	let isValidatePhone =false;
	
function ValidatePhone() {
  const checkphone = phoneNum.value.replace(/\D/g, "");
  const phoneReg = /^(\d{3})(\d{3,4})(\d{4})$/;
  const formattedPhone = checkphone.replace(phoneReg, "$1-$2-$3");

  if (phoneReg.test(checkphone)) {
    isValidatePhone = true;
    phoneCheckLabel.style.color = "#69BC80";
    return formattedPhone; // format된 번호를 반환
  }

  isValidatePhone = false;
  phoneCheckLabel.style.color = "red";
  return false;
}

phoneNum.addEventListener('input', () => {
  const formattedPhone = ValidatePhone(); // format된 번호를 변수에 할당
  if (formattedPhone) {
    phoneNum.value = formattedPhone;
  }
});


	emailCheckBtn.addEventListener('click', function() {

		let emailCheck = email.value;
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/mailCheck?email=' + emailCheck);
		xhr.onload = function() {
			if (xhr.status === 200) {
				console.log('data: ' + xhr.responseText);
				code = xhr.responseText;
			}

		};
		xhr.send();
		alert('인증번호가 전송되었습니다.');
	});
	const 	isemailCheckNum =false;
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



	emailCheckNum.addEventListener('change',ValidateEmailNumber);
	email.addEventListener('change', ValidateEmail);
	pwd.addEventListener('input', ValidatePwd);
	pwdCheck.addEventListener('input', updatecheckPwd);
	phoneNum.addEventListener('input', ValidatePhone);
	nickName.addEventListener('input',nicknameCheck);

};