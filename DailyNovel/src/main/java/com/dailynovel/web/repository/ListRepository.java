package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;

@Mapper
public interface ListRepository {
	
	List<Diary> findAllById(
			Integer memberId,
			Integer how,
			Integer feeling,
			Integer year,
			Integer month,
			Integer sort
			);
	
}
