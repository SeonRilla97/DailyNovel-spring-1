package com.dailynovel.web.controller.member;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.service.ListService;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class MemberControllerTest {


	@Autowired
	private ListService listservice;
	
	
	@Test
	void testDiarylist() {
		List<Diary> list = listservice.getDiarys(1, 1, 1, 1, null);
		System.out.println(list);
	}

}
