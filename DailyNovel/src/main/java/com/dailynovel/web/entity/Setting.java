package com.dailynovel.web.entity;


public class Setting {
	private int id;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	
	public Setting() {
		super();
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
