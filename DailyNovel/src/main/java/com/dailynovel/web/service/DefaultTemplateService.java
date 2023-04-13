package com.dailynovel.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Template;
import com.dailynovel.web.repository.TemplateRepository;
@Service
public class DefaultTemplateService implements TemplateService {

	@Autowired
	private TemplateRepository repository;
	
	public List<Template> getTemplateList(){
		List<Template> list = repository.findAll();
		return list;
	}
	
}
