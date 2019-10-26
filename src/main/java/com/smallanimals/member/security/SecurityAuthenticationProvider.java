package com.smallanimals.member.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.smallanimals.member.service.AuthoritiesService;
import com.smallanimals.member.vo.MemberVO;


public class SecurityAuthenticationProvider implements AuthenticationProvider  {

	@Autowired
	private AuthoritiesService AuthSer;
	
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = (String) authentication.getPrincipal();
	        String password = (String) authentication.getCredentials();
	        
	        MemberVO user = (MemberVO) AuthSer.loadUserByUsername(username);
	        System.out.println("��й�ȣ ��!");
	       System.out.println(password);
	        System.out.println(user.getPassword());
	        
	        if(!matchPassword(password, user.getPassword())) {
	            throw new BadCredentialsException(username);
	        }
	 
	        if(!user.isEnabled()) {
	            throw new BadCredentialsException(username);
	        }
	        
	        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return true;
	}
	
	  private boolean matchPassword(String loginPwd, String password) {
	        return loginPwd.equals(password);
	  } 
		  


}