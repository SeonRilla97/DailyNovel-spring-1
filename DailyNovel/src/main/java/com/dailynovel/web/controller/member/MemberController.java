package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.service.ListService;

@Controller
@RequestMapping("/member/")
public class  MemberController {

	//검색 리스트
	@Autowired
	private ListService listservice;
	
	
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
	public String diarylist(Model model,
			@RequestParam(required = true, defaultValue = "1") Integer id){
		//선유진-검색
		
		List<Diary> list =  listservice.getDiarys(id);
		System.out.println(list);
//		model.addAttribute("list",list);
		return "/member/diary/list";
	}
	@RequestMapping("/diary/selecttmp")
	public String diarySelectView(){
		return "/member/diary/select-tmp";
	}
}
