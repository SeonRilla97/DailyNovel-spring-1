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
public class Export {
	private Integer id; // 회원아이디
	private Date regDate; // 일기 등록일
	private String feelingName; // 기분날씨이름
	private String title;
	private String text;
}