package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;

@Mapper
public interface ListRepository {
	
	List<Diary> findAllById(
			Integer memberId,
			Integer how, //템플릿
			Integer feeling, //기분
			String date //날짜
			);
	
}
