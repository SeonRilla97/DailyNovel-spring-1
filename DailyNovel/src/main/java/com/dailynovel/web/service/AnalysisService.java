package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;

public interface AnalysisService {
	
	List<Feeling> getCount();
	

	List<Feeling> getValue();

	List<Feeling> getFeelingRank();

	List<Feeling> getFeelingTopRank();

	List<Feeling> getValue(String name, Integer frequency);

	List<Honesty> getHonesty();

	List<Honesty> getHonesty(String honestyRange, Integer count);
	
	List<How> getHow(String name, Integer count);

	List<How> getHow();
	
	List<How> getHowTop();

}
