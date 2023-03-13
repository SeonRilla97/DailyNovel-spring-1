package com.dailynovel.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/analysis")
public class  AnalysisController {


	@RequestMapping("/main")
	public String main(){
		return "/WEB-INF/view/member/diary/analysis/main.jsp";
	}
	
	@RequestMapping("/feeling")
	public String setting(){
		return "/WEB-INF/view/member/diary/analysis/component/feeling.jsp";
	}
	
	@RequestMapping("/honesty")
	public String honesty(){
		return "/WEB-INF/view/member/diary/analysis/component/honesty.jsp";
	}
	

}
