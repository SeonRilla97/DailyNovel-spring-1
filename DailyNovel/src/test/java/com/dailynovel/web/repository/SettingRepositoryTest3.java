package com.dailynovel.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Setting;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class SettingRepositoryTest3 {

	@Autowired
	private SettingRepository repository;
	
	@Test
	void testFindDiaryListById() {
		List<Export> setting = repository.findDiaryListById(1);
		System.out.println(setting);

	}

}
