package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;
import com.dailynovel.web.repository.FeelingRepository;
import com.dailynovel.web.repository.ListRepository;
import com.dailynovel.web.repository.TemplateRepository;
import com.dailynovel.web.repository.WeatherRepository;

@Service
public class DefaultListService implements ListService {
	
	@Autowired
	private ListRepository repository;
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private WeatherRepository weatherRepository;
	@Autowired
	private FeelingRepository feelingRepository;
	
	
	
	@Override
	public List<Diary> getDiarys(
			Integer memberId,
			Integer tid,
			Integer fid,
			Integer wid,
			String regDate 
			) {
		// TODO Auto-generated method stub
//		System.out.println("여기는 서비스 단 입니다." + memberId.toString() + tid + fid + wid + regDate);
		List<Diary> list = repository.findAllById(memberId,tid,fid,wid,regDate);
		System.out.println("서비스단 리스트 출력" + list);
		return repository.findAllById(memberId,tid,fid,wid,regDate);
//		return null;
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
		List<Feeling> list = feelingRepository.findAll();
		return  list;
	}

}
