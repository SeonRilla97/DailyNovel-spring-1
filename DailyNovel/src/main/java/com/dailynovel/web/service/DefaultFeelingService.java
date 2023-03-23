package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dailynovel.web.entity.FeelingCountView;
import com.dailynovel.web.repository.FeelingRepository;

public class DefaultFeelingService implements FeelingService {

	
	@Autowired
	private FeelingRepository repository;
	
	@Override
	public List<FeelingCountView> getViewCount() {
		
		return repository.findViewAll();
	}

}
