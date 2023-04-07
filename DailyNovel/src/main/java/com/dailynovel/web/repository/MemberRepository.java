package com.dailynovel.web.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {


	public int FindSameNickname(String nickname); 


	public void insert(String id,
			String pwd,
			String nickname,
			String phoneNum);


	public int getFindId(String email);
	public int getFindPwd(String email,String password);

}
