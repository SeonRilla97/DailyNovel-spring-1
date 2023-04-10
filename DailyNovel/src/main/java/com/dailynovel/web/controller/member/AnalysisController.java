package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;
import com.dailynovel.web.service.AnalysisService;

@Controller
@RequestMapping("/")
public class  AnalysisController {

	@Autowired
	private AnalysisService service;
	
	
	
	@GetMapping("member/analysis/feeling")
	public String feeling(Model model) {
		List<Feeling> rank = service.getFeelingRank();
		Feeling Toprank = service.getFeelingTopRank().get(0); // 첫 번째 요소만 가져오기
		System.out.println("Rank");
		model.addAttribute("rank", rank);
		model.addAttribute("Toprank", Toprank);
		return "member/diary/analysis/looking-back/feeling";
	}
	
	
	@GetMapping("member/analysis/feeling-chart")
		public String feelingChart(Model model) {
		List<Feeling> Value = service.getValue();
		model.addAttribute("Value", Value);
		return "member/diary/analysis/looking-back/feeling-chart";
	}
	
	@GetMapping("member/analysis/feeling-view-detail")
	public String feelingViewDetail(Model model) {
		List<Feeling> list = service.getCount();
		System.out.println(list);
		model.addAttribute("list", list);
		return "member/diary/analysis/looking-back/feeling-view-details";
	}
	
		@GetMapping("member/analysis/honesty")
		public String honesty(Model model) {
			List<Honesty> list = service.getHonesty();
			model.addAttribute("list", list);
			return "member/diary/analysis/looking-back/honesty";
		}
//	
	@GetMapping("member/analysis/how")
	public String How(Model model) {
		List<How> list = service.getHow();
		How Tophow = service.getHowTop().get(0); // 첫 번째 요소만 가져오기
		model.addAttribute("list", list);
		model.addAttribute("Tophow", Tophow);
		return "member/diary/analysis/looking-back/how";
	}
//	
		@GetMapping("member/analysis/main")
		public String main() {
			
			return "member/diary/analysis/main";
		}
	


}
