package com.dailynovel.web.controller.user;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.internet.MimeMessage;



@RequestMapping("/user/")
@Controller
public class UserController {
	@Autowired
	private JavaMailSenderImpl sender;

	@RequestMapping("login")
	public String login() {
		return "/user/login";
	}

	@RequestMapping("signup")
	public String signUp() {
		return "/user/sign-up";
	}
	
	@RequestMapping("mailCheck")
	@ResponseBody
	public String mailCheck(String email) throws Exception{
		
		Random rand = new Random();
		int checkNum = rand.nextInt(999999);
	    MimeMessage message = sender.createMimeMessage();
	    // use the true flag to indicate you need a multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, false);
	    helper.setTo(email);
	    helper.setSubject("DailyNovel 회원가입 인증 메일입니다.");
	    // use the true flag to indicate the text included is HTML
	    helper.setText("<html><body>인증번호:"+checkNum+"</body></html>",true);
	    // let's include the infamous windows Sample file (this time copied to c:/)
	    sender.send(message);
	    return "success";
	  }
}
