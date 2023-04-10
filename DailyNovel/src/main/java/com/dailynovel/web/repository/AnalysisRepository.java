package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;

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
	
	List<Honesty> findHonesty(String honestyRange, Integer count);
	
	List<Feeling> findValue(String name, Integer frequency);
	
	List<How> findHow(String name, Integer count);
	
	List<How> findTopHow(String description, Integer count);
	
	

	 

	

	 

	
}