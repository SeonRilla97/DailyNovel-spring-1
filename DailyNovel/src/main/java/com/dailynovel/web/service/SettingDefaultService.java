package com.dailynovel.web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Export;
import com.dailynovel.web.entity.Font;
import com.dailynovel.web.entity.Setting;
import com.dailynovel.web.repository.SettingRepository;




//@Component // 일단 동작 확인이 우선이니 Component로 박는데, 이후 Service로 바꾸겠다.
@Service // 내가 인터페이스로 쓰는 서비스와 어노테이션 Service가 이름이 충돌 나서 이렇게 적혀지는 거 같다.
public class SettingDefaultService implements SettingService {
	
	@Autowired
	private SettingRepository repository; 
	
	//이 게 필요한지 의문이 듦
	public void setRepository(SettingRepository repository) {
		this.repository=repository;
	}
	@Override
	public Setting getById(Integer id) {
		return repository.findById(id);
	}
	@Override
	public List<Export> getDiaryListByid(Integer id) {
		
		return repository.findDiaryListById(id);
	}
	@Override
	public List<Font> getByFontId() {
		// TODO Auto-generated method stub
		return repository.findFontById();
	}

	@Override
	public int updateProfile(Setting setting) {
		
	return 	repository.updateProfile(setting);
	}

	@Override
	public int updateFont(Setting setting) {
		return repository.updateFont(setting);
	}
	
	
	@Override
	public int deleteAcount(Integer id) {
		
		return repository.deleteAcount(id);
	}
}
