package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;

public interface ListService {

	List<Diary> getDiarys(Integer id);
	public List<Template> getTemplateList();
	public List<Weather> getWeatherList();
	public List<Feeling> getFeelingList();
}
