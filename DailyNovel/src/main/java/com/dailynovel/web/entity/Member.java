package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	private long id;
	private	String email;
	private	String password;
	private String nickname;
	
	private int font_family;
	private int font_size;
	

}
