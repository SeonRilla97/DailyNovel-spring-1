package com.dailynovel.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Diary;
import com.dailynovel.web.entity.DiaryView;
import com.dailynovel.web.repository.DiaryRepository;

@Service
public class DefaultDiaryService implements DiaryService {
	
	@Autowired
	private DiaryRepository repository;
	

	@Override
	public Diary Diary(Integer id) {
		// TODO Auto-generated method stub
		Diary d = repository.view(id);
		
		return d;
	}

	@Override
	public DiaryView viewDiary(Integer id) {
		// TODO Auto-generated method stub
		DiaryView d2 = repository.findDiaryView(id);
		
		return d2;
	}
	
	@Override
	public String[] getDiarySetToCSS(Integer id) {
		// TODO Auto-generated method stub
		DiaryView d = repository.findDiaryView(id);
		
		String feel = d.getFeelingName();
		String weather = d.getWeatherName();
		
	
		
		String [] DiarySetToCss = new String[2]; 
		
		// 감정부분 변환기
		if(feel == null){
			DiarySetToCss[0] = "null-circle-img";
		}
		else if(feel.equals("화남") ) {
			DiarySetToCss[0] = "angry-img";
		}
		else if(feel.equals("불편")) {
			DiarySetToCss[0] = "anxiety-img";
		}
		else if(feel.equals("평온")) {
			DiarySetToCss[0] = "calm-img";
		}
		else if(feel.equals("실망")) {
			DiarySetToCss[0] = "disappointed-img";
		}
		else if(feel.equals("불안")) {
			DiarySetToCss[0] = "anxiety-img";
		}
		else if(feel.equals("행복")) {
			DiarySetToCss[0] = "happy-img";
		}
		else if(feel.equals("슬픔")) {
			DiarySetToCss[0] = "sad-img";
		}
		else if(feel.equals("감동")) {
			DiarySetToCss[0] = "touched-img";
		}
		else if(feel.equals("신남")) {
			DiarySetToCss[0] = "excited-img";
		}
		
		System.out.println(DiarySetToCss[0]);
		
		//날씨부분 변환
		
		System.out.println(weather);
		
		if(weather == null){
			DiarySetToCss[1] = "null-circle-img";
		}
		else if(weather.equals("맑음")) {
			DiarySetToCss[1] = "sunny-img";
		}
		else if(weather.equals("흐림")) {
			DiarySetToCss[1] = "cloudy-img";
		}
		else if(weather.equals("눈")) {
			DiarySetToCss[1] = "snow-img";
		}
		else if(weather.equals("비")) {
			DiarySetToCss[1] = "rain-img";
		}
		else if(weather.equals("먼지")) {
			DiarySetToCss[1] = "dust-img";
		}
	
		
		System.out.println(DiarySetToCss[1]);
		
		return DiarySetToCss;
	}
	
	
	
	@Override
	public void insertDiary(Diary diary) {
		repository.register(diary);		

	}	
	
	@Override
	public int modifyDiary(Diary diary) {
		
		repository.update(diary);
		
		return 1;
	}


	
	//월별 일기 얻기(사용자 별)
	public Map<Integer, ArrayList<Diary>> getAllbyMonthly(int memberId, int year,int month){
	//담을 객체 선언만 한거
		Map<Integer, ArrayList<Diary>> diaryMap = new HashMap<>();
		
		//다이어리 값 받아오기
		List<Diary> list = repository.getDiaryByMonthly(memberId,year, month);
		
		for(Diary dry : list) {
			int curdate = dry.getRegDate().toLocalDateTime().getDayOfMonth();
			//해당 날짜가 key:value 선언이 되어있는지 확인, 없으면 생성
			if (!diaryMap.containsKey(curdate)) {
				diaryMap.put(curdate, new ArrayList<Diary>());
		    }
			//key(날짜) 별 value(미리보기) 넣기
			diaryMap.get(curdate).add(dry);	
		}
		return diaryMap;
	}

	//정렬기준에 따라 일기 주기 (사용자별)--> 후에 이거 front에서 처리하도록 바뀔예정 -> 데이터 전부 다 주고 Front에서 정렬하도록
	//대신 데이터를 다시는 불러오지 않기 때문에, 데이터가 변화 된 적이 있는지 확인하는것도 좋을듯? (예를들면 다이어리 개수비교)
	//일기를 지운 뒤, 일기를 다시 불러오기, 컴퓨터에선 일기쓰고 모바일에선 list보고 이럴때 조오옹나 신경쓸거 많아지지만 서버와 통신은 최소화?? 
	@Override
	public List<Diary> getAllByCriterion(Integer memberId, Integer tid, Integer fid, Integer wid,
			String regDate) {
		List<Diary> list = repository.findAllById(memberId,tid,fid,wid,regDate);
		System.out.println("서비스단 리스트 출력" + list);
		return repository.findAllById(memberId,tid,fid,wid,regDate);
	}

	
	@Override
	public int removeDiary(Integer id) {
		
		int result = repository.delete(id);
		
		
		return result;
	}
	
	
}