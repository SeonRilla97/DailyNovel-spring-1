package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Diary {
	
	private int memberId;
	private int templateId;
	private Integer feelingId;
	private Integer weatherId;
	private Integer honesty;
	private String regDate;
//	private String reg_date;
	private String title;
	private String content;
//	private String text;



}
