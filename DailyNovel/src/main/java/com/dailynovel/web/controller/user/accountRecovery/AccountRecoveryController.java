package com.dailynovel.web.controller.user.accountRecovery;

import java.util.Random;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dailynovel.web.service.MemberService;

import jakarta.mail.internet.MimeMessage;

@RequestMapping("/user/account-recovery")
@Controller
public class  AccountRecoveryController {
	
	
//	
	@Autowired
	private JavaMailSenderImpl sender;
	
	
	@Autowired
	private MemberService service;

	@RequestMapping("email")
	public String login() {
		return "/user/account-recovery/email";
	}
	@RequestMapping("password")
	public String password() {
		return "/user/account-recovery/password";
	}
	
	
}