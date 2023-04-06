package com.dailynovel.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.repository.MemberRepository;
@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberRepository repository;
	
	@Override
	public int FindSameNickname(String nickname) {
		// TODO Auto-generated method stub
		
		int samenicknameNumber =   repository.FindSameNickname(nickname);
		
		return samenicknameNumber;
	}

}
