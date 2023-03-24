package com.dailynovel.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class  MemberController {

	
	
	@RequestMapping("main")
	public String main(){

		return "/member/main";
	}
	

	@RequestMapping("setting")
	public String setting(){
		return "/member/settings/main";
	}
	
	

	
}
