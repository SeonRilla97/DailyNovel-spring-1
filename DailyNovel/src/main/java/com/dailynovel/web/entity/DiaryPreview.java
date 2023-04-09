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
	//선유진 - 해당 객체는 <<<Main페이지 의 미리보기>>>를 위한 객체입니다.
	// content 속성에서는 사용자 일기 내용 전체를 보여주는게 아닌, 60글자를 추출하여 저장합니다.
	// 일기 전체를 가져오지 않습니다.
	private Long memberId;
	private String regDate;
	private String title;
	private String content;
	private int diaryDate;
}
