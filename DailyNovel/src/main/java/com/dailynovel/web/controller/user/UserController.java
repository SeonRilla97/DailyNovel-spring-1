package com.dailynovel.web.controller.user;

import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import com.dailynovel.web.service.MemberService;

import com.dailynovel.web.service.SignupService;

import ch.qos.logback.core.model.Model;
import io.micrometer.core.ipc.http.HttpSender.Request;
import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;


@RequestMapping("/user/")
@Controller
public class UserController {
	

	
	@Autowired
	private JavaMailSenderImpl sender;
	
	@Autowired
	private MemberService service;
	

	@Autowired
	private SignupService signupService;
	
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("login")
	public String loginCheck(@RequestParam(required = true) String email,
	@RequestParam(required = true) String password,
	 Model model ,HttpSession session) {
		boolean logincheck= service.loginCheck(email,password);
		if(logincheck) {
			int id = service.getIdByEmail(email);
			session.setAttribute("id", "id");
			System.out.println(id);
			return "redirect:/member/main";
		}
		return "redirect:login?error=error";
	}
	
	@GetMapping("signup")
	public String GetsignUp() {
		System.out.println("이건 get");
		return "/user/sign-up";
		
	}
	@PostMapping(value = "/signup")
	public String PostsignUp(
			@RequestParam(required = true) String id,
			@RequestParam(required = true) String pwd,
			@RequestParam(required = true) String nickname,
			@RequestParam(required = true) String phoneNum
			) {
		System.out.println("이건 post");
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(nickname);
		System.out.println(phoneNum);
		signupService.signup(id,pwd,nickname,phoneNum);
//		signupService.createUser();
		System.out.println("전송완료!");
		return "/user/login";
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
	    helper.setText("<html><body>회원가입 인증번호:"+authCode+"</body></html>",true);
	    // let's include the infamous windows Sample file (this time copied to c:/)
	    sender.send(message);
	    return "true";
		}
		return "false";
	  }
	
	@RequestMapping("nicknameCheck")
	@ResponseBody
	public String nicknameCheck(String nickname) {
		
		int samenicknameNumber=  service.FindSameNickname(nickname);
		if(samenicknameNumber==0) {
		System.out.println(samenicknameNumber);
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
	

	
}
