package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingRank;

@Mapper
public interface FeelingRepository {
	
	List<Feeling> findFeelingAll();

	
	List<FeelingRank> findAll(String name,
							String description,
							String img,
							Integer frequency
									); 
	List<FeelingRank> findTopRank(String name,
								String img,
								Integer frequency,
								String description
									);
	List<FeelingRank> findRank(String name,
				   			String img,
							Integer frequency
			);
	
}
