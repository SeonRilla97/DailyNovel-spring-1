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
	
	@RequestMapping("/diary/guide")
	public String diaryguide(){
		return "/member/diary/guide";
	}	
	@RequestMapping("/diary/list")
	public String diarylist(){
		return "/member/diary/list";
	}
	@RequestMapping("/diary/selecttmp")
	public String diarySelectView(){
		return "/member/diary/select-tmp";
	}
}
