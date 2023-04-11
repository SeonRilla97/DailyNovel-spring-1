package com.dailynovel.web.controller.member;

public class test {

	public static void main(String[] args) {
		
		String content = "<html><body>\n";
		for (int i=0 ; i< 10 ; i++) {
		    content += i + " [" + i+1 + "]"+"\n";
		}
		content += "</body></html>";
		
		System.out.println(content);
	}

}
