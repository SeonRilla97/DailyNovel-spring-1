package com.dailynovel.web.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Diary {
	
	private int memberId;
	private int templateId;
	private Integer feelingId;
	private Integer weatherId;
	private Integer honesty;


	private Timestamp regDate;
//	private String regDate;
	private String title;
	private String content;
	private Integer id; // diary Id 추가자 : 선유진



}
