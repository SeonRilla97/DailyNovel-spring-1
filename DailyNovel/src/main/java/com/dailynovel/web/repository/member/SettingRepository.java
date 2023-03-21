package com.dailynovel.web.repository.member;


import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Setting;

@Mapper
public interface SettingRepository {
	
	Setting findById(int id);
	

}
