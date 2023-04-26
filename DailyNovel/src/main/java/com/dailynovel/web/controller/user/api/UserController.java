package com.dailynovel.web.controller.user.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.dailynovel.web.service.MemberService;

import com.dailynovel.web.service.SignupService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@RequestMapping("/user/")
@RestController("apiUserController")
public class UserController {
	

	@Autowired
	private MemberService service;
	@Autowired
	private SignupService signupService;
		
//	@PostMapping("login")
//	public void loginCheck(@RequestParam(required = true) String username,
//	@RequestParam(required = true) String password,
//	 Model model ,HttpSession session
//	 ,HttpServletResponse res
//			) throws IOException {
//		boolean logincheck= service.loginCheck(username,password);
//		if(logincheck) {
//			int id = service.getIdByEmail(username);
//			session.setAttribute("id", id);
//			String redirect_url ="/member/main";
//			res.sendRedirect(redirect_url);
//			System.out.println("여기오니?");
//		}
//		else {
//		String redirect_url ="login?error=error";
//		res.sendRedirect(redirect_url);
//		}
//	}
	
	@PostMapping(value = "/signup")
	public String PostsignUp(
			@RequestParam(required = true) String id,
			@RequestParam(required = true) String pwd,
			@RequestParam(required = true) String nickname,
			@RequestParam(required = true) String phoneNum
			) {
		signupService.signup(id,pwd,nickname,phoneNum);
		return "/user/login";
	}
	
	@RequestMapping("mailCheck")
	public String mailCheck(String email , HttpSession session) throws Exception{
		
		int authCode = service.randNum();
		boolean mailCheck= service.mailCheck(email, authCode, "회원가입 인증메일 입니다.", "이메일 인증번호:");
		if(mailCheck)
			return "true";		
		return "false";
	  }
	
	@RequestMapping("nicknameCheck")
	public String nicknameCheck(String nickname) {
		
		int samenicknameNumber=  service.FindSameNickname(nickname);
		if(samenicknameNumber==0) {
		return "success";
		}		
		return "false";
	}
	
	@RequestMapping("emailCheckNum")
	public String emailCheckNum(int emailCheckNum , HttpSession session){

		int passwordChangeAuthCode =(int) session.getAttribute("authCode");
		if(emailCheckNum==passwordChangeAuthCode) {	
			int checkNum = service.randNum();
		    session.setAttribute("passwordChangeauthCode", checkNum);
			return "true";
		}

		return "false";
	};
	

	
}
