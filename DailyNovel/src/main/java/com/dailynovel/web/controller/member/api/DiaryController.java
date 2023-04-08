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
		
		
		System.out.println(diary);
		return "ㄷ...될까..?";
	}
	
}
