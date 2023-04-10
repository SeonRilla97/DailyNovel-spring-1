package com.dailynovel.web.service;

public class 파일없음예외 extends Exception {
	@Override
	public String getMessage() {
	
		return "삭제할 이전 파일이 없는 오류가 발생했습니다.";
	}
}
