package com.dailynovel.web.service;


import com.dailynovel.web.entity.Member;


public interface MemberService{

	int FindSameNickname(String nickname);

	
	boolean loginCheck(String email,String password);


	int FindSameEmail(String email);


	String findEmailByNickname(String nickname);


	int passwordChange(String email , String password);


	boolean temporaryPassword(String email, String uuid);


	int getIdByEmail(String email);


	int[] getMemberSetting(int uid);



}
