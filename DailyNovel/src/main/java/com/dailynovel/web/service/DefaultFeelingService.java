package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.FeelingCountView;
import com.dailynovel.web.entity.FeelingRankView;
import com.dailynovel.web.entity.FeelingTopRankView;
import com.dailynovel.web.repository.FeelingRepository;

@Service
public class DefaultFeelingService implements FeelingService {

	
	@Autowired
	private FeelingRepository repository;
	
	@Override
	public List<FeelingCountView> getViewCount() {
		
		return repository.findViewAll();
	}

	@Override
	public List<FeelingRankView> getRankView() {
		// TODO Auto-generated method stub
		return repository.findRankView();
	}

	@Override
	public List<FeelingTopRankView> getTopRankView() {
		// TODO Auto-generated method stub
		return repository.findTopRankView();
	}



}
