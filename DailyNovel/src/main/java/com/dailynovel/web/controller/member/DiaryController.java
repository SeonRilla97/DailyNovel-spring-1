package com.dailynovel.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
public class  DiaryController {

	
	
	@RequestMapping("guide")
	public String guide(){
		return "/WEB-INF/view/member/diary/guide.jsp";
	}
	
	@RequestMapping("list")
	public String list(){
		return "/WEB-INF/view/member/diary/list.jsp";
	}
	
	
	@RequestMapping("register")
	public String register(){
		return "/WEB-INF/view/member/diary/register.jsp";
	}
	
	@RequestMapping("selectTmp")
	public String selectTmp(){
		return "/WEB-INF/view/member/diary/selectTmp.jsp";
	}
	@RequestMapping("update")
	public String update(){
		return "/WEB-INF/view/member/diary/update.jsp";
	}
	@RequestMapping("view")
	public String view(){
		return "/WEB-INF/view/member/diary/view.jsp";
	}
	
	
}
