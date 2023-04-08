package com.dailynovel.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryPreview;
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
	public void insertDiary(Diary diary) {
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

	public Map<Integer, ArrayList<DiaryPreview>> getPreview(int year,int month){
	//담을 객체 선언만 한거
		Map<Integer, ArrayList<DiaryPreview>> diaryMap = new HashMap<>();
		
		//다이어리 값 받아오기
		List<DiaryPreview> list = repository.getDiaryByMonthly(year, month);
		
		for(DiaryPreview dry : list) {
			int curdate = dry.getDiaryDate();
			//해당 날짜가 key:value 선언이 되어있는지 확인, 없으면 생성
			if (!diaryMap.containsKey(curdate)) {
				diaryMap.put(curdate, new ArrayList<DiaryPreview>());
		    }
			//key(날짜) 별 value(미리보기) 넣기
			diaryMap.get(curdate).add(dry);	
		}
		return diaryMap;
	}

}
