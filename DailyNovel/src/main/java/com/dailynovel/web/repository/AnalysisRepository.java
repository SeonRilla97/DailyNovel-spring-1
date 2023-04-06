package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;

@Mapper
public interface AnalysisRepository {
	

	
	 
	
	List<Feeling> findCount(String name,
							String description,
							String img,
							Integer frequency
									); 
	List<Feeling> findFeelingTopRank(String name,
								String img,
								Integer frequency,
								String description
									);
	List<Feeling> findFeelingRank(String name,
				   			String img,
							Integer frequency
									);

	
	
	List<Feeling> findValue(String name, Integer frequency);
	
	List<Diary> findHonesty(Float honesty, Integer count);
	
	

	 

	

	 

	
}