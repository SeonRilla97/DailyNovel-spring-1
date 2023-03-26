package com.dailynovel.web.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Setting;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest

class SettingRepositoryTest2 {
	
	@Autowired
	private SettingRepository repository;
	
	@Test
	void testUpdateProfile() {
		Setting setting = new Setting();
		setting.setId(7);
		setting.setNickName("고양이");
		setting.setProfileImage("kakao.12.png");
		setting.setAlarmSwitch(0);
		setting.setKakaoAlarmSwitch(1);
		setting.setAlarmTime("23:11:25");
		System.out.println(setting);
		repository.updateProfile(setting);
		
	}

}
