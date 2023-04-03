package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Feeling;

public interface AnalysisService {
	
	List<Feeling> getCount();
	
	List<Feeling> getFeelingRank(); 
	
	
	List<Feeling> getValue();

	List<Feeling> getFeelingTopRank();

}
