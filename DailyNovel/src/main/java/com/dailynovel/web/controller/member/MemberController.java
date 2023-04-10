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
import com.dailynovel.web.service.ListService;
import com.dailynovel.web.service.SettingService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private SettingService settingService;

	@Autowired
	private ListService listservice;

	@Autowired
	private DiaryService diaryservice;

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
	public String register() {
		return "/member/diary/register";
	}

	// 수정 부분
	@RequestMapping("/diary/modify")
	public String modify(Model model,
			@RequestParam(name = "diaryId") Integer diaryId) {

		//

		return "/member/diary/modify";
	}

	@RequestMapping("/diary/list")
	public String diarylist(Model model,
			@RequestParam(required = true, defaultValue = "1", name = "id") Integer memberId,
			@RequestParam(required = false, name = "wid") Integer wid,
			@RequestParam(required = false, name = "tid") Integer tid,
			@RequestParam(required = false, name = "fid") Integer fid,
			@RequestParam(required = false, name = "reg_date") String regDate) {
		// 선유진-검색
		System.out.println("레그데이트 :" + regDate);
		List<Diary> list = listservice.getDiarys(memberId, tid, fid, wid, regDate);

		List<Template> templateList = listservice.getTemplateList();
		List<Feeling> feelingList = listservice.getFeelingList();
		List<Weather> weatherList = listservice.getWeatherList();
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

		DiaryView diary = diaryservice.viewDiary(diaryId);

		// d.getRegDate();
		// d.getTemplateId();
		// d.getFeelingId();
		// d.getWeatherId();
		// d.getTitle();
		// d.getContent();

		// 객체 통째로 보내준다.
		model.addAttribute("diary", diary);

		return "/member/diary/detail";
	}

	@RequestMapping("/diary/edit")
	public String edit() {
		return "/member/diary/edit";
	}
	
}