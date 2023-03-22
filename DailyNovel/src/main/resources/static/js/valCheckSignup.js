const email=document.querySelector("#email");
const emailCheck=document.querySelector("#email-check");
const emailCheckBtn = document.querySelector("email-check-btn");
const pwd=document.querySelector("#pwd");
const pwdCheck=document.querySelector("#pwd-check");
const nickName=document.querySelector("#nickname");
const phoneNum=document.querySelector("#phone");
const phoneCheck=document.querySelector("#phone-check");

// Form 태그의 Input Tag에 커서를 주고 Enter 누르면 제출되는 문제 해결
const signUpForm = document.querySelector("#sign-up-form");
signUpForm.addEventListener('keydown', (e) => {
    if(e.key ==="Enter"){  
        e.preventDefault();
    }
});

// 이메일 유효성 검사
let isEamilValidate = false;
function ValidateEmail() 
{
    const checkMail = email.value;
    const emailReg = new RegExp(/^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/);
 if (emailReg.test(checkMail))
  {
      console.log("이메일 완료!");
      isEamilValidate=true;
    return (true)
  }
    console.log("이메일 실패!");
    isEamilValidate=false;
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



function ValidatePwd() 
{
    const checkPwd = pwd.value;
    const PwdReg = new RegExp(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d!@#$%^&*]{8,}$/);
 if (PwdReg.test(checkPwd))
  {
      console.log("비밀번호 완료!");
    return (true)
  }
  console.log("비밀번호 실패!");
    return (false)
}

function checkPwd() {
    const confirm = pwdCheck.value; //비밀번호 확인인데, 비밀번호 유효성검사와 변수명 겹침
    
    if(confirm == pwd.value){
        console.log("비밀번호 같다!!");
        return true;
    }
    console.log("비밀번호 일치하지 않음");
    return false;
}

function nicknameCheck() {
    //중복확인 -> DB와 통신 필요함
}

function ValidatePhone() 
{
    const checkphone = phoneNum.value;
    const phoneReg = new RegExp(/^\d{11}$/);
    if (phoneReg.test(checkphone))
    {
        console.log("저나버노 완료!");
        return true
    }
    console.log("저나버노 실패!");
        return false
}


email.addEventListener('change',ValidateEmail);
pwd.addEventListener('change',ValidatePwd);
pwdCheck.addEventListener('change',checkPwd);
phoneNum.addEventListener('change',ValidatePhone);