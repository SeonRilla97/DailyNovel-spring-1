package com.dailynovel.web.entity;

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
	private String profileImage;
	private String statusMessage;
	
	
}