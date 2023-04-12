package com.dailynovel.web.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryPreview;
import com.dailynovel.web.entity.DiaryView;

@Mapper
public interface DiaryRepository {
	//--Create--
	void register(Diary diary);
	
	//--Read--
	List<Diary> getAllDiaryById(); //해당 유저의 모든 다이러리 가져오기
	List<Diary> findAllById(
			Integer memberId,
			Integer tid, //템플릿
			Integer fid, //기분
			Integer wid,
			String date //날짜
			); //정렬기준에 따라 다이어리 가져오기
	
	Diary view(Integer id); //id 추가
	
	//detail_view 이용하기s
	DiaryView findDiaryView(Integer id); //id 추가
	
	
	Set<Integer> getDateByMonthly(int year, int month);
	List<DiaryPreview> getDiaryByMonthly(int year, int month); 
	
	
	//---Update---
	void update(Diary diary, Integer diaryId);
	
	//--Delete--
	void delete();
	
}


