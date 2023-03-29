package com.dailynovel.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailynovel.web.entity.FeelingRankView;
import com.dailynovel.web.repository.FeelingRepository;

@SpringBootTest
@AutoConfigureMybatis
class DefaultFeelingServiceTest {

	
	@Autowired
	private FeelingService service;
	
	
	@Test
	void test() {
		List<FeelingRankView> list = service.getRankView();
		System.out.println(list);		
		System.out.println("작업완료");
	}

}
