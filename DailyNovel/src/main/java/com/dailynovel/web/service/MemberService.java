package com.dailynovel.web.service;

import com.dailynovel.web.entity.Member;

public interface MemberService{

	int FindSameNickname(String nickname);

	
	String loginCheck(String email,String password);


	int FindSameEmail(String email);


	String findEmailByNickname(String nickname);


	int passwordChange(String password, String email);


	int getMemberSetting(int uid);



}
