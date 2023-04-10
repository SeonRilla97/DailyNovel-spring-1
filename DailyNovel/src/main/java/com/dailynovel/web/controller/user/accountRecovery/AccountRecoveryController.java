package com.dailynovel.web.controller.user.accountRecovery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/account-recovery")
@Controller
public class  AccountRecoveryController {

	@RequestMapping("email")
	public String login() {
		return "/user/account-recovery/email";
	}

	@RequestMapping("password")
	public String password() {
		return "/user/account-recovery/password";
	}
	
	
	
	
}
