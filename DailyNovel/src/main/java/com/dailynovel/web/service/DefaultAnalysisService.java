package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.repository.AnalysisRepository;

@Service
public class DefaultAnalysisService implements AnalysisService {

	
	@Autowired
	private AnalysisRepository repository;
	

	@Override
	public List<Feeling> getCount() {
		// TODO Auto-generated method stub
		return repository.findCount(null, null, null, null);
	}


	@Override
	public List<Feeling> getFeelingTopRank() {
		// TODO Auto-generated method stub
		return repository.findFeelingTopRank(null, null, null, null);
	}

	@Override
	public List<Feeling> getValue() {
		// TODO Auto-generated method stub
		return repository.findCount(null, null, null, null);
	}

	@Override
	public List<Feeling> getFeelingRank() {
		// TODO Auto-generated method stub
		return repository.findFeelingRank(null, null, null);
	}


	@Override
	public List<Feeling> getValue(String name, Integer frequency) {
		// TODO Auto-generated method stub
		return repository.findValue(name, frequency);
	}


	@Override
	public List<Diary> getHonesty() {
		// TODO Auto-generated method stub
		return repository.findHonesty(null, null);
	}


	@Override
	public List<Diary> getHonesty(String honestyRange, Integer count) {
		// TODO Auto-generated method stub
		return repository.findHonesty(honestyRange, count);
	}












	





	
	
	
	
	





}
