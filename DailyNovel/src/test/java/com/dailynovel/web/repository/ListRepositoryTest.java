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
class ListRepositoryTest {

	@Autowired
	private ListRepository repo;
	@Test
	void test() {
		List<Diary> list = repo.findAllById(1,1,null,null,"2023-03-24");
//		Diary list = new Diary(1,1,1,1,1,"2024-03-24","타이틀","컨텐츠");
		System.out.println(list);
	}

}
