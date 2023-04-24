package com.dailynovel.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//공신력있는 관련 사이트
//https://docs.spring.io/spring-security/reference/servlet/authorization/expression-based.html
// https://www.baeldung.com/spring-security-thymeleaf

@Configuration
public class RlandSecurityConfig {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		
		
		http
		.cors()
		.and()
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/admin/**")
		.hasAnyRole("ADMIN") //cors공격을 무시하겠다. csrf
		.requestMatchers("/member/**")
		.hasAnyRole("ADMIN","MEMBER")
		.anyRequest()
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/user/login") //이건 내가 만든 페이지
		.loginProcessingUrl("/user/login")
		.defaultSuccessUrl("/admin/index")
		.and()
		.logout()
		.logoutSuccessUrl("/index");
		
		
		
		
		//우리가 필터를 쓰면서 우리가 만든 인증 필터가 따로 로그인을 만들어 줘서 현재 만들어진 내용물은 스프링이 만들어준 것!
		//기본 url은 /login이 되고 user/login의 post요청은 url를 맞춰주거나 
		//
	
		//role과 Auth의 차이
		//둘이 같지만 달라지는거 
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		
		return new BCryptPasswordEncoder();
	}
	
	//2.메모리에서 받는것이 아닌 JDBC에서 가져오기
	//@Bean
	public UserDetailsService jdbcUserDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource); //데이터베이스를 활용해야하기 떄문에 sql문을 써줘야한다.
		manager.setUsersByUsernameQuery("select username, pwd password, 1 enabled from member where username =?"); //sql문을 넘겨줘야함 근데 문제는 이 퀄럼은 내 마음대로 정의한거기때문에 컬럼명이 안맞을 수도 있다.
		//원하는 컬럼명 username password enabled 3가지를 원한다. 우리는 username밖에 없다.. 
		manager.setAuthoritiesByUsernameQuery("select username, 'ROLE_ADMIN' authority from member where username =?");  //권한을 담는 sql문인데 없으면 없는대로 있으면 있는대로 쿼리의 결과값만 가져오면된다.
		//데이터 구조는 한명의 회원이 여러 권한을 가질려면 관리자 역할과 회원 역할을 하는 경우도 있다.
		//회원과 비회원만 있으면..?
		//username하고 authority만 있으면된다.
		
		return manager;
	}
	
	
	
	// 사용자 데이터 서비스의 종류
	//1. 인메모리 서비스
	//2. JDBC  서비스
	//3. LDAP 서비스
	
	//1.인메모리 서비스
	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails newlec = User.builder().username("newlec").password(passwordEncoder().encode("111")).roles("ADMIN","MEMBER").build();
		//여기서의 빌드는 롬복에게 어떤 영향을 줄까
		
		
		UserDetails dragon = User.builder().username("dragon").password(passwordEncoder().encode("111")).roles("ADMIN","MEMBER").build();
		//Member member= Member.builder().id//원래 만드는 방식이 아닌 직접 빌드를 만들어도됨
		//인증정보를 담아야하는 것이 필요하다!
		return new InMemoryUserDetailsManager(newlec,dragon);
	}
	
	//사용자 정보를 얻는 법
	
	//3. LDAP 서비스
//	@Bean
	public UserDetailsService rlandUserDetialsService() {
		
		
		
		return new RlandUserDetailService() ;
	}

}
