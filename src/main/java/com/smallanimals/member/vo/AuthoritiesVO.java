package com.smallanimals.member.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthoritiesVO implements UserDetails {

	private String userId;
	private String userPw;
	private String gradeRole;
	private String name;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        auth.add(new SimpleGrantedAuthority(gradeRole));
	        return auth;
	}
	@Override
	public String getPassword() {
		return userPw;
	}
	@Override
	public String getUsername() {
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
