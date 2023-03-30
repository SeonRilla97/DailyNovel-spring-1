package com.dailynovel.web.controller.member;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import com.aspose.words.Document;
import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;
import com.dailynovel.web.service.ListService;
import com.dailynovel.web.service.SettingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private SettingService settingService;

  @Autowired
	private ListService listservice;
	
	@RequestMapping("main")
	public String main() {
		return "/member/main";
	}

	@RequestMapping("/diary/guide")
	public String diaryguide(){
		return "/member/diary/guide";
	}	
	@RequestMapping("/diary/list")
	public String diarylist(Model model,
			@RequestParam(required = true, defaultValue = "1", name="id") Integer id
			,@RequestParam(required = false, name="wid", defaultValue="1")Integer weatherId 
			,@RequestParam(required = false, name="tid", defaultValue="2")Integer templateId
			,@RequestParam(required = false, name="fid", defaultValue="2")Integer feelingId
			,@RequestParam(required = false, name="reg_date", defaultValue="2")String regDate){
		//선유진-검색
		
		List<Diary> list =  listservice.getDiarys(id);
		 
		List<Template> templateList = listservice.getTemplateList();
		List<Feeling>	feelingList = listservice.getFeelingList();
		List<Weather>	weatherList =listservice.getWeatherList();
		
		model.addAttribute("feeling", feelingList);
		model.addAttribute("diaryList", list);
		model.addAttribute("templateList", templateList);
		model.addAttribute("weatherList", weatherList);
		System.out.println(templateList);
		System.out.println(list);
		System.out.println(regDate +id +weatherId+templateId+feelingId);
		System.out.println(weatherList);
		System.out.println(feelingList);
		model.addAttribute("list",list);
		return "/member/diary/list";
	}
	
	@RequestMapping("/diary/selecttmp")
	public String diarySelectView(){
		return "/member/diary/select-tmp";
	}
}
