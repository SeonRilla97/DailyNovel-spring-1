package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Weather;
import com.dailynovel.web.repository.WeatherRepository;
@Service
public class DefaultWeatherService implements WeatherService {

	@Autowired
	private WeatherRepository repository;
	
	public List<Weather> getWeatherList(){
		List<Weather> list = repository.findAll();
		return list; 	
		}
	
	
}
