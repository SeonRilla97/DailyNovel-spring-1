package com.dailynovel.web.entity;

import lombok.Builder;
import lombok.Data;


public class Setting {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Setting(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Setting [id=" + id + "]";
	}
	
	
	
}
