package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.repository.FeelingRepository;
@Service
public class DefaultFeelingService implements FeelingService {
	@Autowired
	private FeelingRepository feelingRepository;
	
	
	public List<Feeling> getFeelingList(){
		List<Feeling> list = feelingRepository.findAll();
		return  list;
	}


	
}
