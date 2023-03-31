package com.dailynovel.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.repository.DiaryRepository;

@Service
public class DefaultDiaryService implements DiaryService {
	
	@Autowired
	private DiaryRepository repository;
	
	@Override
	public Diary viewDiary() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void registerDiary(Diary diary) {
		repository.register(diary);		

	}

	@Override
	public int updateDiary() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int deleteDiary() {
		// TODO Auto-generated method stub
		return 1;
	}


}
