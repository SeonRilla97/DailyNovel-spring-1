package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DiaryPreview {
	private Long memberId;
	private String regDate;
	private String title;
	private String content;
	private Integer templateId;
	private Integer feelingId;
	private Integer weatherId;
}
