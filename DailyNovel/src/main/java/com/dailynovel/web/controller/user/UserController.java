package com.dailynovel.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dailynovel.web.service.SignupService;

@RequestMapping("/user/")
@Controller
public class UserController {

	@Autowired
	private SignupService signupService;
	
	@RequestMapping("login")
	public String login() {
		return "/user/login";
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
		return "/user/sign-up";
	}
}
