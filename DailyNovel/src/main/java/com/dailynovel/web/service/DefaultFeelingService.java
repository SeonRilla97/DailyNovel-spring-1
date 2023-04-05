package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.repository.FeelingRepository;

@Service
public class DefaultFeelingService implements FeelingService {

	
	@Autowired
	private FeelingRepository repository;
	

	@Override
	public List<Feeling> getCount() {
		// TODO Auto-generated method stub
		return repository.findAll(null, null, null, null);
	}

	@Override
	public List<Feeling> getRank() {
		// TODO Auto-generated method stub
		return repository.findRank(null, null, null);
	}

	@Override
	public List<Feeling> getTopRank() {
		// TODO Auto-generated method stub
		return repository.findTopRank(null, null, null, null);
	}

	@Override
	public List<Feeling> getValue() {
		// TODO Auto-generated method stub
		return repository.findValue(null, null);
	}
	
	
	
	
	





}
