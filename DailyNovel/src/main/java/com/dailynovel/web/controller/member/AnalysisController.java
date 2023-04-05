package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.service.FeelingService;
import com.dailynovel.web.service.AnalysisService;

@Controller
@RequestMapping("/analysis")
public class  AnalysisController {

	@Autowired
	private AnalysisService service;
	
	
	
	@GetMapping("feeling")
	public String feeling(Model model) {
		List<Feeling> rank = service.getFeelingRank();
		Feeling Toprank = service.getFeelingTopRank().get(0); // 첫 번째 요소만 가져오기
		System.out.println("Rank");
		model.addAttribute("rank", rank);
		model.addAttribute("Toprank", Toprank);
		return "member/diary/analysis/looking-back/feeling";
	}
	
	
	@GetMapping("feeling-chart")
		public String feelingChart(Model model) {
		List<Feeling> labels = service.getLabel();
		List<Feeling> Value = service.getValue();
		model.addAttribute("Name", labels);
		model.addAttribute("Value", Value);
		return "member/diary/analysis/looking-back/feeling-chart";
	}
	
	@GetMapping("feeling-view-detail")
	public String feelingViewDetail(Model model) {
		List<Feeling> list = service.getCount();
		System.out.println(list);
		model.addAttribute("list", list);
		return "member/diary/analysis/looking-back/feeling-view-details";
	}
	
//		@GetMapping("honesty")
//		public String honesty(Model model) {
//			List<Feeling> list = service.getList();
//			model.addAttribute("list", list);
//			return "analysis/honesty";
//		}
//	
//	@GetMapping("How")
//	public String How(Model model) {
//		List<Feeling> list = service.getList();
//		model.addAttribute("list", list);
//		return "analysis/How";
//	}
//	
		@GetMapping("main")
		public String main() {
			
			return "member/diary/analysis/main";
		}
	


}
