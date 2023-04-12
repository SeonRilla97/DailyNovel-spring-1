package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.FeelingPercent;
import com.dailynovel.web.entity.Honesty;
import com.dailynovel.web.entity.How;
import com.dailynovel.web.repository.AnalysisRepository;

@Service
public class DefaultAnalysisService implements AnalysisService {

	
	@Autowired
	private AnalysisRepository repository;

	@Override
	public List<Feeling> getFeelingTopRank(Integer id) {
		// TODO Auto-generated method stub
		return repository.findFeelingTopRank(null, null, null, null, id);
	}



	@Override
	public List<Feeling> getFeelingRank(Integer id) {
		// TODO Auto-generated method stub
		return repository.findFeelingRank(null, null, null, id);
	}


	@Override
	public List<Feeling> getValue(String name, Integer frequency, Integer id) {
		// TODO Auto-generated method stub
		return repository.findValue(name, frequency ,id);
	}

	@Override
	public List<FeelingPercent> getPercent(Integer id) {
		// TODO Auto-generated method stub
		return repository.findpercent(null, null, null, null, id);
	}



	@Override
	public List<Feeling> getCount(Integer id) {
		// TODO Auto-generated method stub
		return repository.findCount(null, null, null, null, id);
	}


	
	

	@Override
	public List<Honesty> getHonesty(String honestyRange, Integer count, Integer id) {
		// TODO Auto-generated method stub
		return repository.findHonesty(honestyRange, count, id);
	}




	@Override
	public List<How> getHow(String name, Integer count, Integer id) {
		// TODO Auto-generated method stub
		return repository.findHow(name, count, id);
	}




	@Override
	public List<How> getHowTop(Integer id) {
		// TODO Auto-generated method stub
		return repository.findTopHow(null, null, id);
	}














	





	
	
	
	
	





}
