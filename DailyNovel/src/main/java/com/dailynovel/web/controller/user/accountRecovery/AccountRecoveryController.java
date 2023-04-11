package com.dailynovel.web.controller.user.accountRecovery;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dailynovel.web.service.MemberService;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user/account-recovery")
@Controller
public class  AccountRecoveryController {
	
	
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	
	@Autowired
	private MemberService service;

	@RequestMapping("email")
	public String login() {
		return "/user/account-recovery/email";
	}
	@RequestMapping("password")
	public String password() {
		return "/user/account-recovery/password";
	}
	@RequestMapping("mailCheck")
	@ResponseBody
	public String mailCheck(String email , HttpSession session) throws Exception{
		
		int checkEmail = service.FindSameEmail(email);
		if(checkEmail != 1) {
		Random rand = new Random();
		int authCode = rand.nextInt(999999);
		session.setAttribute("authCode",authCode);
	    MimeMessage message = sender.createMimeMessage();
	    // use the true flag to indicate you need a multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, false);
	    helper.setTo(email);
	    helper.setSubject("DailyNovel 회원가입 인증 메일입니다.");
	    // use the true flag to indicate the text included is HTML
	    helper.setText("<html><body>비밀번호 변경 인증번호:"+authCode+"</body></html>",true);
	    // let's include the infamous windows Sample file (this time copied to c:/)
	    sender.send(message);
	    return "true";
		}
		return "false";
	  }

		
		@RequestMapping("nicknameCheck")
		@ResponseBody
		public String nicknameCheck(String nickname) {
		
		String email=  service.findEmailByNickname(nickname);
		if(email!=null) {
		System.out.println(email);
		return "success";
		}		
		return "false";
	}
	
		@RequestMapping("emailCheckNum")
		@ResponseBody
		public String emailCheckNum(int emailCheckNum , HttpSession session){

			int passwordChangeAuthCode =(int) session.getAttribute("authCode");
			System.out.println(passwordChangeAuthCode);
			System.out.println(emailCheckNum);
			if(emailCheckNum==passwordChangeAuthCode) {	
				  Random rand = new Random();
			      int  checkNum = rand.nextInt(999999);
			    session.setAttribute("passwordChangeauthCode", checkNum);
				return "true";
			}

			return "false";
		};
		
		
		@RequestMapping("passwordchange")
		@ResponseBody
		public String passwordChage(String password, String email) {
			
			int	passwordChangeCheck = service.passwordChange(password, email);
			if(passwordChangeCheck==1) {
				return "success";
			}
			
			return "false";
		}
		
		

	@RequestMapping("update-password")
	public String renew() {
		return "/user/account-recovery/update-password";
	}
	

	
}
