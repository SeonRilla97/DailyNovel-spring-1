package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.repository.ListRepository;

@Service
public class defaultListService implements ListService {
	
	@Autowired
	private ListRepository repository;
	@Override
	public List<Diary> getDiarys(Integer memberId) {
		// TODO Auto-generated method stub
		return repository.findAllById(memberId,null,null,null,null,null);
	}

}
