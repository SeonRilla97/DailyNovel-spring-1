package com.dailynovel.web.service;

import java.util.ArrayList;
import java.util.Map;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryPreview;

public interface DiaryService {
	
	//모재영 구현
	Diary viewDiary(Integer id);
	
	//노션 유진이의 공간 참고(여기에 선언한 이유) -> Diary관련 서비스라고 생각함 (미리보기 서비스가 아닌)
	Map<Integer, ArrayList<DiaryPreview>> getPreview(int year,int month);
	void insertDiary(Diary diary);
	int updateDiary();
	int deleteDiary();
}
