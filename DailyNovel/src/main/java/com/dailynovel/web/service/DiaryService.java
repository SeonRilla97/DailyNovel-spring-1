package com.dailynovel.web.service;

import com.dailynovel.web.entity.Diary;

public interface DiaryService {
	
	Diary viewDiary();
	void registerDiary(Diary diary);
	int updateDiary();
	int deleteDiary();
}
