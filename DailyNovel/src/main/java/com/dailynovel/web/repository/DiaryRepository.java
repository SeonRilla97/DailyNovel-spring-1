package com.dailynovel.web.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryPreview;

@Mapper
public interface DiaryRepository {
	//--Create--
	void register(Diary diary);
	
	//--Read--
	List<Diary> getAllDiaryById();
	Diary view();
	Set<Integer> getDateByMonthly(int year, int month);
	List<DiaryPreview> getDiaryByMonthly(int year, int month); 
	
	
	//---Update---
	Diary update();
	
	//--Delete--
	void delete();
	
}


