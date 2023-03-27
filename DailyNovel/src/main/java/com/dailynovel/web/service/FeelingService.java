package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.FeelingCountView;
import com.dailynovel.web.entity.FeelingRankView;
import com.dailynovel.web.entity.FeelingTopRankView;

public interface FeelingService {
	
	List<FeelingCountView> getViewCount();
	
	List<FeelingRankView> getRankView(); 
	
	List<FeelingTopRankView> getTopRankView(); 

}
