package com.dailynovel.web.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

//@Component
public class AuthFilter implements Filter {

	private static String[] permitUrls = {

			"/admin/**", "/member/**"

	}; //

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httprequest = (HttpServletRequest) request;
		String uri = httprequest.getRequestURI();

		String urL = httprequest.getRequestURL().toString();

		System.out.println("필터 입구");
		// 필터를 끼니깐 모두 백지가 되어버렸다.. 이를 어떻게 해야하나? filter는 수문장이라서 입구에서 지키고 있다.
		// 이 필터가 실행되게 하는데? 들여보내주질않아서 요청이 여기서 끝나고 빈페이지를 가져오게된다.
		// 그렇다면 들여보내게 하는 방법은...? chain을 이용한다

		// 입구를 지나면 여기를 실행 모든 resource들이 실행된다-> css파일 이미지 등등..
		chain.doFilter(request, response);

		// 응답전에 실행
		System.out.println("필터 출구");

	}

}
