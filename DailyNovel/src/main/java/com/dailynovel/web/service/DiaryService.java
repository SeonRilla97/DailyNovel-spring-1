package com.dailynovel.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryView;

public interface DiaryService {
	
	//모재영 구현
	Diary Diary(Integer id);
	DiaryView viewDiary(Integer id);
	
	String [] getDiarySetToCSS(Integer id);
	
	
	//노션 유진이의 공간 참고(여기에 선언한 이유) -> Diary관련 서비스라고 생각함 (미리보기 서비스가 아닌)
	Map<Integer, ArrayList<Diary>> getAllbyMonthly(int memberId, int year,int month);
	List<Diary> getAllByCriterion(Integer memberId,
			Integer tid,
			Integer fid,
			Integer wid,
			String regDate 
			);
	
	void insertDiary(Diary diary);
	int modifyDiary(Diary diary);
	int removeDiary(Integer id);
}
