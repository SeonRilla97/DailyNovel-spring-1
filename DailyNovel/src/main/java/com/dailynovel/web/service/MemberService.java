package com.dailynovel.web.service;

public interface MemberService{

	int FindSameNickname(String nickname);

	
	String loginCheck(String email,String password);


	int FindSameEmail(String email);


	String findEmailByNickname(String nickname);


	int passwordChange(String password, String email);

}
