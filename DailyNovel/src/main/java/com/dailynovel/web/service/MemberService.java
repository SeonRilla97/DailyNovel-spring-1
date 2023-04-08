package com.dailynovel.web.service;

public interface MemberService{

	int FindSameNickname(String nickname);

	
	String loginCheck(String email,String password);

}
