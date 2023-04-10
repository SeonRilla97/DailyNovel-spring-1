package com.dailynovel.web.controller.member.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;
import com.dailynovel.web.service.AnalysisService;

@RestController("apiAnalysisController")
@RequestMapping("/analysis1")
public class  AnalysisController {

	@Autowired
	private AnalysisService service;
	
	
	
//	@GetMapping("feeling")
//	public String feeling(Model model) {
//		List<Feeling> rank = service.getFeelingRank();
//		Feeling Toprank = service.getFeelingTopRank().get(0); // 첫 번째 요소만 가져오기
//		System.out.println("Rank");
//		model.addAttribute("rank", rank);
//		model.addAttribute("Toprank", Toprank);
//		return "member/diary/analysis/looking-back/feeling";
//	}
	
	
	@GetMapping("feeling-chart")
	public List<Feeling> getList(
			
			@RequestParam(name = "name") String name,
			@RequestParam(name = "frequency", defaultValue = "0") Integer frequency){					
			List<Feeling> List = service.getValue(name, frequency);
			return List;
			
}
	@GetMapping("honesty")
	public List<Honesty> getHonesty(
			
			@RequestParam(name = "honestyRange") String honestyRange,
			
			@RequestParam(name = "count") Integer count){					
			List<Honesty> list = service.getHonesty(honestyRange, count);
			return list;
			
}

//	
	@GetMapping("how")
	public List<How> getHowChart(
			
			@RequestParam(name = "name", defaultValue = "자유") String name,
			@RequestParam(name = "count") Integer count){					
			List<How> list = service.getHow(name, count);
			return list;
	}
	


}
