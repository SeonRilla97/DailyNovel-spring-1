package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingPercent;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;

public interface AnalysisService {
	
	List<Feeling> getCount(Integer id);

	List<Feeling> getValue(String name, Integer frequency, Integer id);

	List<Feeling> getFeelingRank(Integer id);

	List<Feeling> getFeelingTopRank(Integer id);
	
	List<FeelingPercent> getPercent(Integer id);


	List<Honesty> getHonesty(String honestyRange, Integer count, Integer id);
	
	List<How> getHow(String name, Integer count, Integer id);
	
	List<How> getHowTop(Integer id);





}
