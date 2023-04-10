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
	List<Diary> getAllDiaryById();
	
	Diary view(Integer id); //id 추가
	
	//detail_view 이용하기s
	DiaryView findDiaryView(Integer id); //id 추가
	
	
	Set<Integer> getDateByMonthly(int year, int month);
	List<DiaryPreview> getDiaryByMonthly(int year, int month); 
	
	
	//---Update---
	Diary update();
	
	//--Delete--
	void delete();
	
}


