package com.smallanimals.member.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthoritiesVO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6257072243459845911L;
	private String userId; 
	private String userPw; 
	private String userRole;
	private String userName;
	private boolean userEnabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        auth.add(new SimpleGrantedAuthority(userRole));
	        return auth;
	}
	@Override
	public String getPassword() {
		return userPw;
	}
	@Override
	public String getUsername() {
		return userId;
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
		return userEnabled;
	}
	   public String getNAME() {
	        return userName;
	    }
	 
	    public void setNAME(String name) {
	    	userName = name;
	    }

}
