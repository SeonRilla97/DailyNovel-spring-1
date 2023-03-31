package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dailynovel.web.entity.Diary;

@Mapper
public interface DiaryRepository {
	
	List<Diary> getAllDiaryById();
	
	Diary view();
	
	void register(Diary diary);
	
	Diary update();
	void delete();
}


