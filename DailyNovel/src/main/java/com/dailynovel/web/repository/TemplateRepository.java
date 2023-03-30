package com.dailynovel.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dailynovel.web.entity.Template;

@Mapper
public interface TemplateRepository {
	
	List<Template> findAll();
	
}
