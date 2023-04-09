package com.dailynovel.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.setFont;
import com.dailynovel.web.entity.Setting;

@Mapper
public interface SettingRepository {
	
	Setting findById(Integer id); 
	List<Export> findDiaryListById(Integer id);
	List<setFont> findFontById();
	int updateProfile(Setting setting);
	int updateFont(Setting setting);
	int deleteAcount(Integer id);
	
}

