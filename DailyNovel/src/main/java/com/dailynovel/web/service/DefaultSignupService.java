package com.dailynovel.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.repository.MemberRepository;

@Service
public class DefaultSignupService implements SignupService {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public void signup(String id,
			String pwd,
			String nickname,
			String phoneNum) {
		memberRepository.insert(id, pwd, nickname, phoneNum);
		
	}

}
