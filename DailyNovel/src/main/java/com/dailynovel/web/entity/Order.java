package com.dailynovel.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private Integer memberId;
	private Integer tid;
	private Integer wid;
	private Integer fid;
	private String regDate;
	
}
