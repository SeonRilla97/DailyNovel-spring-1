const email=document.querySelector("#email");
const emailCheck=document.querySelector("#email-check");
const pwd=document.querySelector("#pwd");
const pwdCheck=document.querySelector("#pwd-check");
const nicName=document.querySelector("#nic-name");
const phoneNum=document.querySelector("#phone-num");
const phoneCheck=document.querySelector("#phone-check");



email.addEventListener('change',()=>{
    var pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; 
    let input = email.value;
    if(input.match(pattern))
    {
        console.log("Ok!");
        email.insertAdjacentHTML("afterend","<p>내놔</p>")
    }
    else
    {
        console.log("오류!");
        return false;
    }
});

// Form 태그의 Input Tag에 커서를 주고 Enter 누르면 제출되는 문제 해결
const signUpForm = document.querySelector("#sign-up-form");
signUpForm.addEventListener('keydown', (e) => {
    if(e.key ==="Enter"){  
        e.preventDefault();
    }
});


