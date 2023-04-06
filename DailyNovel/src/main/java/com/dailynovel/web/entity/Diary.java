package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Diary {
	
	private int memberId;
	private String regDate;
	private String title;
	private String content;
	private Integer templateId;
	private Integer feelingId;
	private Integer weatherId;
	private Integer honesty;


}
