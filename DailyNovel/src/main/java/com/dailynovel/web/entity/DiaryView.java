package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//public class DiaryView extends Diary{
public class DiaryView {

	private int memberId;
	private Integer honesty;
	private String regDate;
	private String title;
	private String content;
	
	
	//기존 분 상속 
	private String templateName;
	private String feelingName;
	private String weatherName;
	

}
