package com.dailynovel.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryView;
import com.dailynovel.web.entity.Feeling;
import com.dailynovel.web.entity.Template;
import com.dailynovel.web.entity.Weather;
import com.dailynovel.web.service.DiaryService;
import com.dailynovel.web.service.FeelingService;
import com.dailynovel.web.service.MemberService;
import com.dailynovel.web.service.SettingService;
import com.dailynovel.web.service.TemplateService;
import com.dailynovel.web.service.WeatherService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private SettingService settingService;


	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private FeelingService feelingService;
	
	@Autowired
	private TemplateService templateService;
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("main")
	public String main() {
		return "/member/main";
	}

	// 일기 작성 부분
	@RequestMapping("/diary/guide")
	public String diaryguide() {
		return "/member/diary/guide";
	}

	@RequestMapping("/diary/selecttmp")
	public String diarySelectView() {
		return "/member/diary/select-tmp";
	}

	@RequestMapping("/diary/register")
	public String register(Model model,
			@RequestParam(required = true, defaultValue = "free-form", name="tmp") String tmp) {
			
			model.addAttribute("tmp", tmp);
		return "/member/diary/register";
	}


	@RequestMapping("/diary/list")
	public String diarylist(Model model,
			@RequestParam(required = true, defaultValue = "1", name = "id") Integer memberId,
			@RequestParam(required = false, name = "wid") Integer wid,
			@RequestParam(required = false, name = "tid") Integer tid,
			@RequestParam(required = false, name = "fid") Integer fid,
			@RequestParam(required = false, name = "reg_date") String regDate,
			HttpSession session) {
		// 선유진-검색
		System.out.println("레그데이트 :" + regDate);
		List<Diary> list = diaryService.getDiarys(memberId, tid, fid, wid, regDate);
		
		List<Template> templateList = templateService.getTemplateList();
		List<Feeling> feelingList = feelingService.getFeelingList();
		List<Weather> weatherList = weatherService.getWeatherList();
		int id = (int) session.getAttribute("id");

		Template curTName;
		Feeling curFName;
		Weather curWName;
		// ======request로 부터 받은 id를 가지고 List collection에 저장되어있는 카테고리의 이름을
		// 얻어온다.============
		if (tid != null) {
			curTName = templateList.get(tid - 1); // List 0 부터 시작(DB의 1번이 List에선 0번)
			System.out.println(curTName);
			model.addAttribute("curTmeplate", curTName);
		}
		if (fid != null) {
			curFName = feelingList.get(fid - 1);
			System.out.println(curFName);
			model.addAttribute("curFeeling", curFName);
		}
		if (wid != null) {
			curWName = weatherList.get(wid - 1);
			System.out.println(curWName);
			model.addAttribute("curWeather", curWName);
		}
		if (regDate != null) {
			String curRegDate = regDate;
			// System.out.println("날짜 삽입 완료!!");
			model.addAttribute("curRegDate", curRegDate);
		}
		// =======View로 이용하기 위해 Model에 데이터 삽입==============================
		model.addAttribute("feeling", feelingList);
		model.addAttribute("diaryList", list);
		model.addAttribute("templateList", templateList);
		model.addAttribute("weatherList", weatherList);
		model.addAttribute("list", list);
		System.out.println(list);

		System.out.println(memberId.toString() + wid + tid + fid + regDate);
		System.out.println(id);
		return "/member/diary/list";

	}

	// 수정 디테일 추가
	@RequestMapping("/diary/detail")
	public String detail(
			Model model,
			@RequestParam(required = true, defaultValue = "1", name = "diaryId") Integer diaryId
	// @RequestParam(required = true, defaultValue = "1", name="id") Integer
	// memberId,
	) {
		//임시 
		int uid = 1;

		DiaryView diary = diaryService.viewDiary(diaryId); 
		String fontnameCSS = settingService.getfontNameforCSS(memberService.getMemberSetting(uid));
		
		System.out.println(fontnameCSS);
		
//		.noto-sans-k{
//		    font-size: 100%;
//		    font-family: 'Noto Sans KR', sans-serif;
//		}
//		.nanum-pen-s{
//		    font-size: 100%;
//		    font-family: 'Nanum Pen Script', cursive;
//		}
//		.sunflower{
//		    font-size: 100%;
//		    font-family: 'Sunflower', sans-serif;
//		}
//		.dongle{
//		    font-size: 100%;
//		    font-family: 'Dongle', sans-serif;
//		}
		
		
		// d.getRegDate();
		// d.getTemplateId();
		// d.getFeelingId();
		// d.getWeatherId();
		// d.getTitle();
		// d.getContent();

		// 객체 통째로 보내준다.
		model.addAttribute("diary", diary);
		model.addAttribute("font", fontnameCSS);

		System.out.println(diary.getContent());

		return "/member/diary/detail";
	}

	@RequestMapping("/diary/modify")
	public String modify(
			Model model,
			@RequestParam(required = true, defaultValue = "1", name = "diaryId") Integer diaryId
	// @RequestParam(required = true, defaultValue = "1", name="id") Integer
	// memberId,
	) {
		//임시 
		int uid = 1;

		DiaryView diary = diaryService.viewDiary(diaryId); 
		String fontnameCSS = settingService.getfontNameforCSS(memberService.getMemberSetting(uid));
		
		System.out.println(fontnameCSS);
		
//		.noto-sans-k{
//		    font-size: 100%;
//		    font-family: 'Noto Sans KR', sans-serif;
//		}
//		.nanum-pen-s{
//		    font-size: 100%;
//		    font-family: 'Nanum Pen Script', cursive;
//		}
//		.sunflower{
//		    font-size: 100%;
//		    font-family: 'Sunflower', sans-serif;
//		}
//		.dongle{
//		    font-size: 100%;
//		    font-family: 'Dongle', sans-serif;
//		}
		
		
		// d.getRegDate();
		// d.getTemplateId();
		// d.getFeelingId();
		// d.getWeatherId();
		// d.getTitle();
		// d.getContent();

		// 객체 통째로 보내준다.
		model.addAttribute("diary", diary);
		model.addAttribute("font", fontnameCSS);

		return "/member/diary/modify";
	}
}
