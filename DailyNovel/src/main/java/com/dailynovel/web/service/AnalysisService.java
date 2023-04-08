package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Analysis;

public interface AnalysisService {
	
	List<Feeling> getCount();
	

	List<Feeling> getValue();

	List<Feeling> getFeelingRank();

	List<Feeling> getFeelingTopRank();

	List<Feeling> getValue(String name, Integer frequency);

	List<Analysis> getHonesty();

	List<Analysis> getHonesty(String honestyRange, Integer count);

}
