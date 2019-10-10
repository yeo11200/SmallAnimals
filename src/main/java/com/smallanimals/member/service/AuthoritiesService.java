package com.smallanimals.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smallanimals.member.dao.AuthoritiesDAO;
import com.smallanimals.member.vo.AuthoritiesVO;

public class AuthoritiesService implements UserDetailsService{
	 @Autowired
	  private AuthoritiesDAO AuthorDAO;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		   AuthoritiesVO user = AuthorDAO.getUserById(username);
	        if(user==null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return user;
	}

}
