package com.dailynovel.web.controller.member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.service.SettingService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member/")
public class  MemberController {

	
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("main")
	public String main(){
		return "/member/main";
	}
	
	
	
	// 세팅 ========================================================================
	@RequestMapping("setting")
	public String setting(){
		return "/member/settings/main";
	}
	// 세팅-프로필-------------------------------------------------------------------
	@RequestMapping("setting/profile")
	public String profile(Model model){
		
		Setting setting = settingService.getById(1);
		//Setting setting = settingService.update();
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/profile";
	}
	
	@PostMapping("setting/profile/update")
	public String profileUpdate(Model model ,
			//MultipartFile profileIma,
			@RequestPart(name="image")MultipartFile profile,
			@RequestParam("name")String Nickname,
			@RequestParam("stsMessage") String stsMessage, 
			@ModelAttribute Setting setting,
			HttpServletRequest request){
		Integer id = 1;
		System.out.println(profile);
		
		if(profile!=null  && !profile.isEmpty()) { //이미지가 비어있지 않을 때만 실행시키기
			System.out.println("안 비었어~");
			Date date = new Date(System.currentTimeMillis()); // 현재 시간 측정
	        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss-SS"); // 시간 측정 포멧 지정
	        String time = format.format(date); // 측정한 시간을 포멧화 하기
	        MultipartFile img = profile;  // input된 이미지를 파일에 넣기
	        String profileImage = time+"__"+ img.getOriginalFilename(); // 이미지 파일의 이름을 추출
	   
	        String urlPath = "/img/profile/"+ profileImage; // 업로드할 파일이 저장될 경로
	        String realPath = request.getServletContext().getRealPath(urlPath); //실제 파일 경로
	            
	            	try {
						profile.transferTo(new File(realPath));
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	setting.setProfileImage(profileImage);
		}
		
		setting.setId(id);
		setting.setNickName(Nickname);
		setting.setStatusMessage(stsMessage);
		System.out.println(setting);
		int a =settingService.updateProfile(setting);
		
		if(a==1)
			return "redirect:../profile";
			//return "redirect:../../main";
		else
			return "ㅋㅋ";
	}
	

	// 세팅-폰트-------------------------------------------------------------------
	@RequestMapping("setting/font")
	public String font(Model model){
		
		Setting setting = settingService.getById(2);
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/font";
	}
	
	// 세팅-알람-------------------------------------------------------------------
	@RequestMapping("setting/alarm")
	public String alarm(Model model){
		
		Setting setting = settingService.getById(2);
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/alarm";
	}
	
	@PostMapping("setting/alarm/update")
	public String alarm(Model model,
			@RequestParam(name="web-alarm", required = false)String alarmSwitch,
			@RequestParam(name="katolk-alarm", required = false)String kakaoAlarmSwitch,
			@RequestParam(name="timer") String alarmTime,
			@ModelAttribute Setting setting){
		
		setting.setId(2);
		setting.setAlarmSwitch((alarmSwitch==null?"0":"1"));
		setting.setKakaoAlarmSwitch((kakaoAlarmSwitch==null?"0":"1"));
		setting.setAlarmTime(alarmTime);
		
		System.out.println(setting);
		int a =settingService.updateProfile(setting);
		
		if(a==1)
			return "redirect:../alarm";
			//return "redirect:../../main";
		else
			return "ㅋㅋ";
	}
	
	// 세팅-내보내기-------------------------------------------------------------------
	@RequestMapping("setting/export")
	public String export(Model model){
		
		Setting setting = settingService.getById(2);
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/export";
	}
	
	@RequestMapping("setting/export/text")
	public String exportText(Model model) throws FileNotFoundException{

		List<Export> export = settingService.getDiaryListByid(2);
		//C:\Users\BW3\Desktop\down
		String homeDir = System.getProperty("user.home");
		System.out.println(homeDir);
		String filePath = homeDir + "/Downloads/dailynovel.txt";
		FileOutputStream fos = new FileOutputStream(filePath);
		PrintStream out = new PrintStream(fos);
		
		for(Export aa : export ) {
			out.print(aa.getRegDate());
			out.print(" [ ");
			out.print(aa.getFeelingName());
			out.print(" ] ");
			out.println();
			out.printf("제목: %s", aa.getTitle());
			out.println();
			out.print(aa.getText());
			out.println();
			out.println();
		}
		
		return "redirect:../../setting/export";
	}
	
	
	
	// 세팅-피드백-------------------------------------------------------------------
	@RequestMapping("setting/service-help")
	public String serviceHelp(Model model){
		
		Setting setting = settingService.getById(2);
		model.addAttribute("setting", setting);
		System.out.println(setting);
		return "member/settings/component/service-help";
	}
	
	// 세팅-로그아웃-------------------------------------------------------------------
	@RequestMapping("setting/out")
	public String out() {
		
		return "member/settings/component/out";
	}
	
	@PostMapping("setting/out/update")
	public String acountOut(Model model,
			@ModelAttribute Setting setting){
		
		Integer id = 1;
		//setting.setId(id);
		
		int a =settingService.deleteAcount(id);
		
//		return "member/settings/main";
		if(a==1)
			return "redirect:../../../";
		else
			return "redirect:../../setting/out";
	}
	
}
