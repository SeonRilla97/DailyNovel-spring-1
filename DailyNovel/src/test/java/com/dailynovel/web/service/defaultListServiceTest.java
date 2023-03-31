package com.dailynovel.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.repository.ListRepository;
@SpringBootTest
@AutoConfigureMybatis
class defaultListServiceTest {
	@Autowired
	private ListRepository repository;

	
	
	@Test
	void testGetDiarys() {
		List<Diary> list = repository.findAllById(1,1,null,null,null);
		System.out.println(list);
	}

}
