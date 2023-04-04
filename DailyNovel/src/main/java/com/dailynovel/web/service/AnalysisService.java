package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.FeelingRank;

public interface FeelingService {
	
	List<FeelingRank> getCount();
	
	List<FeelingRank> getRank(); 
	
	List<FeelingRank> getTopRank();
	
	List<FeelingRank> getValue();

}
