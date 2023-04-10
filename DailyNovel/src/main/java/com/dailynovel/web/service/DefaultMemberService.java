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
	public String loginCheck(String email, String password) {
		String check = "";
		int id = repository.getFindId(email);
		int pwd = repository.getFindPwd(email ,password);
		if (id == 1) {
			if (pwd == 1) {
				check = "로그인 성공!";
			} else {
				check = "비밀번호를 다시입력하세요";
			}

		} else {
			check = "계정이 올바르지 않습니다.";
		}

		return check;
	}

	@Override
	public int FindSameEmail(String email) {
		int checkEmail = repository.getFindId(email);
		return checkEmail;
	}

}
