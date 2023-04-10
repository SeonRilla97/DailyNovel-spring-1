package com.dailynovel.web.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Setting {
	private Integer id;
	private String email;
	private String password;
	private String nickName;
	//private MultipartFile profileImage;
	private String profileImage;
	private String statusMessage;
	private String fontFamily;
	private String fontSize;
	private String alarmSwitch;
	private String kakaoAlarmSwitch;
	private String alarmTime;
	//private MultipartFile profileImage2;

}

