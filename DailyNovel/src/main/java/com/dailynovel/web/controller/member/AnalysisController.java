package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingPercent;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;
import com.dailynovel.web.service.AnalysisService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class  AnalysisController {

	@Autowired
	private AnalysisService service;
	

	
	
	@GetMapping("member/analysis/feeling")
	public String feeling(Model model, HttpSession session) {
	    Integer id = (Integer) session.getAttribute("id");    
	    List<Feeling> rank = service.getFeelingRank(id);
	    List<Feeling> topRankCom = service.getFeelingTopRank(id);
	    Feeling topRank = null;  // topRank 변수를 초기화
	    if(!topRankCom.isEmpty()) {  // topRankList가 비어있지 않은 경우
	        topRank = topRankCom.get(0);  // 첫 번째 요소를 가져옴
	    }
	    System.out.println("Rank");
	    model.addAttribute("rank", rank);
	    model.addAttribute("Toprank", topRank);  // topRank 변수를 모델에 추가
	    return "member/diary/analysis/looking-back/feeling";
	}
	
	
	@GetMapping("member/analysis/feeling-chart")
	public String feelingChart(Model model, HttpSession session) {
	    Integer id = (Integer) session.getAttribute("id");    
	    List<Feeling> Value = service.getValue(null, null, id);
	    List<FeelingPercent> TopPercent = service.getPercent(id); // 첫 번째 요소만 가져오기
	    List<FeelingPercent> Percent = service.getPercent(id);
	    FeelingPercent TopPcnt = null;
	    FeelingPercent Pcnt = null;
	    if(!TopPercent.isEmpty()) {
	        TopPcnt = TopPercent.get(0);
	    }
	    if(!Percent.isEmpty()) {
	        Pcnt = Percent.get(0);
	    }
	    model.addAttribute("TopPercent", TopPcnt);
	    model.addAttribute("Percent", Pcnt);
	    model.addAttribute("Value", Value);
	    return "member/diary/analysis/looking-back/feeling-chart";
	}
	
	@GetMapping("member/analysis/feeling-view-detail")
	public String feelingViewDetail(Model model, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");	
		List<Feeling> list = service.getCount(id);
		System.out.println(list);
		model.addAttribute("list", list);
		return "member/diary/analysis/looking-back/feeling-view-details";
	}
	
		@GetMapping("member/analysis/honesty")
		public String honesty(Model model, HttpSession session) {
			Integer id = (Integer) session.getAttribute("id");	
			List<Honesty> list = service.getHonesty(null, null, id);
			model.addAttribute("list", list);
			return "member/diary/analysis/looking-back/honesty";
		}
//	
	@GetMapping("member/analysis/how")
	public String How(Model model, HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");	
		List<How> list = service.getHow(null, null, id);
		How Tophow = service.getHowTop(id).get(0); // 첫 번째 요소만 가져오기
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
