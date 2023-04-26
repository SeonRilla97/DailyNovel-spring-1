
package com.dailynovel.web.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DailyNovelUserDetails implements UserDetails { 
	
	//데이터 베이스에서 쿼리문을쓰면 담을 공간

	private long id;
	private String email;//
	private String username;
	private String password;//
	private List<GrantedAuthority> authroties;//
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<GrantedAuthority> getAhthroties() {
		return authroties;
	}

	public void setAhthroties(List<GrantedAuthority> ahthroties) {
		this.authroties = ahthroties;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authroties;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "DailyNovelUserDetails [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", ahthroties=" + authroties + "]";
	}

}
