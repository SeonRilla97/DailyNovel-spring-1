package com.dailynovel.web.controller.member.api;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailynovel.web.entity.DiaryPreview;
import com.dailynovel.web.service.DiaryService;

@RestController("apiDiaryController")
@RequestMapping("/diarys")
public class DiaryController {
 
	@Autowired
	private DiaryService service;
	
	
	@GetMapping("preview")
	public Map<Integer, ArrayList<DiaryPreview>> getPreview(
			@RequestParam int year,
			@RequestParam int month) {
		Map<Integer, ArrayList<DiaryPreview>> list = service.getPreview(year, month);
		
		return list;
	}
	
	

}
