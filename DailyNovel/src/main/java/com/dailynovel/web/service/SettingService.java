package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Font;
import com.dailynovel.web.entity.Setting;


public interface SettingService {
	Setting getById(Integer id);
	List<Export> getDiaryListByid(Integer id);
	
	List<Font> getByFontId();
	
	int updateProfile(Setting setting);
	int updateFont(Setting setting);
	
	int deleteAcount(Integer id);
	
}
