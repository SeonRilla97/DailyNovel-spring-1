package com.dailynovel.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class  MemberController {

	
	
	@RequestMapping("main")
	public String main(){

		return "/WEB-INF/view/member/main.jsp";
	}	

	@RequestMapping("setting")
	public String setting(){
		return "/member/settings/main.html";
	}
	
	@RequestMapping("register")
	public String register() {
		return "/member/diary/register";
	}

	
}
