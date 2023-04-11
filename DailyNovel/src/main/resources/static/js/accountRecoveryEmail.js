const emailShow = document.querySelector("#emailShow");
const nickanme	= document.querySelector("#emailShow");
const emailFindFrom = 	document.querySelector("#emailFindFrom");

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
					alert("존재하지 않는 이메일 입니다. ");
				}
				else{

					isEmailCheck = true;
				alert('인증번호가 전송되었습니다.');
				}
			}

		};
		xhr.send();
	});
