package com.dailynovel.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.service.SettingService;

@Controller
@RequestMapping("/member/")
public class  MemberController {

	
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("main")
	public String main(){
		return "/member/main";
	}
	
	@RequestMapping("setting")
	public String setting(){
		return "/member/settings/main";
	}
	
	@RequestMapping("setting/profile")
	public String profile(Model model){
		
		Setting setting = settingService.getById(21);
		//Setting setting = settingService.update();
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/profile";
	}
	
	@PostMapping("setting/profile/update")
	public String profileUpdate(Model model ,
			@RequestParam("name")String Nickname,
			@RequestParam("stsMessage") String stsMessage, 
			@ModelAttribute Setting setting){
		Integer id = 21;
		setting.setId(id);
		setting.setNickName(Nickname);
		setting.setStatusMessage(stsMessage);
		int a =settingService.updateProfile(setting);
		
		if(a==1)
			return "redirect:../profile";
		
		else
			return "ㅋㅋ";
	}
	
	@RequestMapping("setting/out")
	public String out() {
		
		return "member/settings/component/out";
	}
	
	@PostMapping("setting/out/update")
	public String acountOut(Model model,
			@ModelAttribute Setting setting){
		
		Integer id = 13;
		//setting.setId(id);
		
		int a =settingService.deleteAcount(id);
		
//		return "member/settings/main";
		if(a==1)
			return "redirect:../../../";
		else
			return "redirect:../../setting/out";
	}
	
	

	
}
