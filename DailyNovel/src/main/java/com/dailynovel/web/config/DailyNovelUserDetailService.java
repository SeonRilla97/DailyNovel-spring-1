package com.dailynovel.web.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dailynovel.web.entity.Member;
import com.dailynovel.web.repository.MemberRepository;




@Service
public class DailyNovelUserDetailService implements UserDetailsService{

	@Autowired
	private MemberRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //username으로 얘를 load한다는 의미
	
		//알랜드details 그릇에 담을 데이터 준비
		
		Member member = repository.findByUserName(username); //member데이터 잘 가져와지나
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		//데이터가 준비되었으면 이제 RlandUserDetails 객체를 만들어서 데이터 담아서 반환해주기
		
		DailyNovelUserDetails user = new DailyNovelUserDetails();
		
		user.setId(member.getId());
		user.setUsername(username);
		user.setPassword(member.getPwd());
		user.setEmail(member.getEmail());
		user.setAhthroties(authorities);

		return user;
	}

}
