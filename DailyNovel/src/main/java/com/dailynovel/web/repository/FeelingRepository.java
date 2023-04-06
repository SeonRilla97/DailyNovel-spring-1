package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingRank;

@Mapper
public interface FeelingRepository {

	
	List<Feeling> findAll();
	List<Feeling> findCount();
	List<Feeling> findFeelingTopRank(String name,
								String img,
								Integer frequency,
								String description
									);
	List<Feeling> findFeelingRank(String name,
				   			String img,
							Integer frequency
			);

	
	List<Feeling> findLabel(String name);
	
	List<Feeling> findValue(Integer frequency);
	
}