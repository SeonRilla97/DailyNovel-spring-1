package com.dailynovel.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailynovel.web.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService {

	@Autowired
	private MemberRepository repository;

	@Override
	public int FindSameNickname(String nickname) {
		// TODO Auto-generated method stub

		int samenicknameNumber = repository.FindSameNickname(nickname);

		return samenicknameNumber;
	}

	@Transactional(timeout = 30000)
	@Override
	public boolean loginCheck(String email, String password) {
		boolean check = false;
		int id = repository.getFindId(email);
		int pwd = repository.getFindPwd(email ,password);
		if (id == 1) {
			if (pwd == 1) {
				check =  true;
			} else {
				check = false;
			}

		} else {
			check = false;
		}

		return check;
	}

	@Override
	public int FindSameEmail(String email) {
		int checkEmail = repository.getFindId(email);
		return checkEmail;
	}

	@Override
	public String findEmailByNickname(String nickname) {

		String email="false";
		int checkNickname = repository.FindSameNickname(nickname);
		if(checkNickname==1) {
			email = repository.getFindEmail(nickname);
		return email;
		}
		
		return email;
	}

	@Override
	public int passwordChange(String password , String email) {

		
		return repository.updatePassword(password , email);
	}

	@Override
	public boolean temporaryPassword(String email, String uuid) {
		int checkEmail = repository.getFindId(email);
		if(checkEmail ==1) {
			int updateTemporaryPassword = repository.updateTemporaryPassword(uuid, email);
			System.out.println(updateTemporaryPassword);
			if(updateTemporaryPassword ==1)
				return true;
			else
				return false;
		}		
		
		return false;
	}

	@Override
	public int getIdByEmail(String email) {
		
		return repository.getFindIdByEmail(email);
	}

}
