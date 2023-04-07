package com.dailynovel.web.controller.member.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.service.DiaryService;

@RestController("apiDiaryController")
@RequestMapping("diarys")
public class DiaryController {
	
	@Autowired
	private DiaryService service;
	
	@PostMapping
	public String insert(@RequestBody Diary diary) {
		service.insertDiary(diary);
		
		diary.setMemberId(1);
		diary.setRegDate("2023-01-27 21:50:50");
		diary.setFeelingId(1);
		diary.setWeatherId(1);
		diary.setTemplateId(1);		
		System.out.println(diary);
		return "ㄷ...될까..?";
	}
	
	@GetMapping("preview")
	public Map<Integer, ArrayList<DiaryPreview>> getPreview(
			@RequestParam int year,
			@RequestParam int month) {
		Map<Integer, ArrayList<DiaryPreview>> list = service.getPreview(year, month);
		
		return list;
	}
}
