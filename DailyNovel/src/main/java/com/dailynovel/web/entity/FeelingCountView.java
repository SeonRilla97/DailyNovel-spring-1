package com.dailynovel.web.entity;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class FeelingCountView {
	
	private int id;
	private String feeling;
	private int value;
	private String img;
}
