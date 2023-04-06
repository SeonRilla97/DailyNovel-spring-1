package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;
import com.dailynovel.web.repository.AnalysisRepository;
import com.dailynovel.web.repository.ListRepository;
import com.dailynovel.web.repository.TemplateRepository;
import com.dailynovel.web.repository.WeatherRepository;

@Service
public class defaultListService implements ListService {
	
	@Autowired
	private ListRepository repository;
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private WeatherRepository weatherRepository;
	@Autowired
	private AnalysisRepository feelingRepository;
	
	
	
	@Override
	public List<Diary> getDiarys(Integer memberId) {
		// TODO Auto-generated method stub
		return repository.findAllById(memberId,null,null,null);
	}
	
	public List<Template> getTemplateList(){
		List<Template> list = templateRepository.findAll();
		return list;
	}
	
	public List<Weather> getWeatherList(){
		List<Weather> list = weatherRepository.findAll();
		return list; 	
		}
	public List<Feeling> getFeelingList(){
		List<Feeling> list = feelingRepository.findFeelingAll();
		return  list;
	}

}
