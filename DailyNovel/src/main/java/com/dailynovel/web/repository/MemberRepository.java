package com.dailynovel.web.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public int FindSameNickname(String nickname); 

}
