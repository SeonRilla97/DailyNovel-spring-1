package com.dailynovel.web.controller.user.accountRecovery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/account-recovery")
@Controller
public class  AccountRecoveryController {

	@RequestMapping("login")
	public String login() {
		return "/WEB-INF/view/user/login.jsp";
	}

	@RequestMapping("signup")
	public String signUp() {
		return "/WEB-INF/view/user/sign_up.jsp";
	}
}
