package com.dailynovel.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user/")
public class  UserController {

	@RequestMapping("login")
	public String login(){

		return "/WEB-INF/view/user/login.jsp";
		
	}
	@RequestMapping("signup")
	public String signUp(){

		return "/WEB-INF/view/user/signUp.jsp";
		
	}
	
	@RequestMapping("recovery/main")
	public String recoveryMain(){

		return "/WEB-INF/view/user/account-recovery/main.jsp";
		
	}
	@RequestMapping("recovery/id")
	public String recoveryId(){

		return "/WEB-INF/view/user/account-recovery/id.jsp";
		
	}
	@RequestMapping("recovery/password")
	public String recoveryPassword(){

		return "/WEB-INF/view/user/account-recovery/password.jsp";
		//이거 하나로 만들자는 의견은 어떨지(id와 pass)
		
	}

}
