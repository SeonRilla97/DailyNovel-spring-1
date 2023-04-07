package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;

@Mapper
public interface ListRepository {
	
	List<Diary> findAllById(
			Integer memberId,
			Integer tid, //템플릿
			Integer fid, //기분
			Integer wid,
			String date //날짜
			);
	
}
