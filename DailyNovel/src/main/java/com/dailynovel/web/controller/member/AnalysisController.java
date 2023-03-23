package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailynovel.web.entity.FeelingCountView;
import com.dailynovel.web.service.FeelingService;

@Controller
@RequestMapping("/analysis")
public class  AnalysisController {

	@Autowired
	private FeelingService service;
	
	
//	@GetMapping("feeling")
//	public String feeling(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/feeling";
//	}
	
//	@GetMapping("feeling-chart")
//	public String feeling-chart(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/feeling-chart";
//	}
//	
	@GetMapping("feeling-view-detail")
	public String feelingViewDetail(Model model) {
		List<FeelingCountView> list = service.getViewCount();
		
		model.addAttribute("list", list);
		return "analysis/looking-back/feeling-view-details";
	}
//	
//	@GetMapping("honesty")
//	public String honesty(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/honesty";
//	}
//	
//	@GetMapping("How")
//	public String How(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/How";
//	}
//	
//	@GetMapping("main")
//	public String main(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/main";
//	}
	


}
