package com.dailynovel.web.service;

import java.util.List;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Setting;


public interface SettingService {
	Setting getById(Integer id);
	
	
	int updateProfile(Setting setting);
	int deleteAcount(Integer id);
	
	List<Export> getDiaryListByid(Integer id);
	
}
