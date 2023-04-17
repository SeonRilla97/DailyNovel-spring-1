package com.dailynovel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/")
public class  HomeController {
//	
//	@Autowired
//	private JavaMailSender javaMailSender;

	
	
	@RequestMapping("/")
	public String index(){

		return "/index";
		
	}
	

	
}
