package com.dailynovel.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class TemplateRepositoryTest {

	@Autowired
	TemplateRepository repo;
	@Autowired
	FeelingRepository Frepo;
	@Autowired
	WeatherRepository Wrepo;
	@Test
	void testFindAll() {
		List<Template> list = repo.findAll();
		List<Feeling> listF = Frepo.findAll();
		List<Weather> listW = Wrepo.findAll();
		System.out.println(listW);
	}

}
