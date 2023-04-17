package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingPercent;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;

@Mapper
public interface AnalysisRepository {
	

	
	
	List<Feeling> findCount(String name,
							String description,
							String img,
							Integer frequency,
							Integer id
									); 
	List<Feeling> findFeelingTopRank(String name,
								String img,
								Integer frequency,
								String description,
								Integer id
									);
	List<Feeling> findFeelingRank(String name,
				   			String img,
							Integer frequency,
							Integer id
									);
	
	List<Honesty> findHonesty(String honestyRange, Integer count, Integer id);
	
	List<Feeling> findValue(String name, Integer frequency, Integer id);
	
	List<FeelingPercent> findpercent(String name,
								Integer frequency,
								Integer Count,
								Integer total,
								Integer id);
	
	List<How> findHow(String name, Integer count, Integer id);
	
	List<How> findTopHow(String description, Integer count, Integer id);
	
	

	 

	

	 

	
}