package com.dailynovel.web.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	public void insert(String id,
			String pwd,
			String nickname,
			String phoneNum);
}
