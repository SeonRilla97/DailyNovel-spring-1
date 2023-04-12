package com.dailynovel.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailynovel.web.entity.Member;
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
	public int [] getMemberSetting(int uid) {
		// TODO Auto-generated method stub
		
		int[] fontSet = new int[2]; 
		
		Member m = repository.findMemberSetting(uid);
		fontSet[0] = m.getFont_family();
		fontSet[1] = m.getFont_size();
		
		return fontSet;
	}


}
