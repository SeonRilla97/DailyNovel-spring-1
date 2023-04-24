package com.dailynovel.web.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailynovel.web.entity.Member;
import com.dailynovel.web.repository.MemberRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class DefaultMemberService implements MemberService {

	@Autowired
	private JavaMailSenderImpl sender;	
	
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


	
	
	@Override
	public int [] getMemberSetting(int uid) {
		// TODO Auto-generated method stub
		
		int[] fontSet = new int[2]; 
		
		Member m = repository.findMemberSetting(uid);
		fontSet[0] = m.getFont_family();
		fontSet[1] = m.getFont_size();
		
		return fontSet;
	}

	@Override
	public boolean mailCheck(String email, int authCode, String Subject, String Text) {
		
		int checkEmail = repository.getFindId(email);
		if(checkEmail != 1) {
		    MimeMessage message = sender.createMimeMessage();
		    // use the true flag to indicate you need a multipart message
		    MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, false);
				helper.setTo(email);
				helper.setSubject("DailyNovel"+ Subject);
				// use the true flag to indicate the text included is HTML
				helper.setText("<html><body>"+Text+":"+authCode+"</body></html>",true);
				// let's include the infamous windows Sample file (this time copied to c:/)
				sender.send(message);
			} catch (MessagingException e) {
			
				e.printStackTrace();
			}
	    return true;
		}
		return false;
		
	}
	
	@Override
	public int randNum() {
		Random rand = new Random();
		int randNum = rand.nextInt(999999);
		
		return randNum;
	}



}
