package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Feeling;

@Mapper
public interface FeelingRepository {
	
	List<Feeling> findAll();
	
}
