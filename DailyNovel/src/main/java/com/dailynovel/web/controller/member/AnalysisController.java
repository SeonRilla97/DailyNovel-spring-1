package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailynovel.web.entity.FeelingRank;
import com.dailynovel.web.service.FeelingService;

@Controller
@RequestMapping("/analysis")
public class  AnalysisController {

	@Autowired
	private FeelingService service;
	
	
	
	@GetMapping("feeling")
	public String feeling(Model model) {
		List<FeelingRank> rank = service.getRank();
		FeelingRank Toprank = service.getTopRank().get(0); // 첫 번째 요소만 가져오기
		System.out.println("Rank");
		model.addAttribute("rank", rank);
		model.addAttribute("Toprank", Toprank);
		return "member/diary/analysis/looking-back/feeling";
	}
	
	
	@GetMapping("feeling-chart")
		public String feelingChart() {
		
		return "member/diary/analysis/looking-back/feeling-chart";
	}
	
	@GetMapping("feeling-view-detail")
	public String feelingViewDetail(Model model) {
		List<FeelingRank> list = service.getCount();
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
