package com.dailynovel.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Diary;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class AnalysisRepositoryTest {
	
	
	@Autowired
	private AnalysisRepository repository;
	
	
	@Test
	void testFindHonesty() {
		List<Diary> list = repository.findHonesty(null);
		System.out.println(list);
	}

}
