package com.dailynovel.web.repository;

import org.junit.jupiter.api.Test;


import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.repository.SettingRepository;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class SettingRepositoryTest {

	
	@Autowired
	private SettingRepository repository;
	
	@Test
	void testFindById() {
		Setting setting = repository.findById(1);
		System.out.println(setting);
		
		
	}

}
