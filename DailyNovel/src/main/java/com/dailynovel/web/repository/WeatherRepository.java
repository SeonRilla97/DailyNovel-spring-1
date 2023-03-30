package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Weather;

@Mapper
public interface WeatherRepository {
	
	List<Weather> findAll();
	
}
