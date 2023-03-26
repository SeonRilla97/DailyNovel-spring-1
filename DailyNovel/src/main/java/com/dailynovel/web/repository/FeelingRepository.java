package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.FeelingCountView;
import com.dailynovel.web.entity.FeelingRankView;
import com.dailynovel.web.entity.FeelingTopRankView;

@Mapper
public interface FeelingRepository {
	
	
	List<FeelingCountView> findViewAll(); 
	
	List<FeelingRankView> findRankView(); 

	List<FeelingTopRankView> findTopRankView(); 

	
}