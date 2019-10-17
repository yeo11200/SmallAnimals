package com.smallanimals.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smallanimals.member.dao.AuthoritiesDAO;
import com.smallanimals.member.vo.MemberVO;


@Service
public class AuthoritiesService implements UserDetailsService{
	
    @Autowired
    private AuthoritiesDAO AuthorDAO;


	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			System.out.println("service까진 오는데" + username);
			
		   MemberVO user = AuthorDAO.getUserById(username);
	        if(user==null) {
	        
	        	throw new UsernameNotFoundException(username);
	        }else {
	        	System.out.println(user.getPassword()+ "얻어온 비밀번호");
	        }
	        return user;
	}
	
}
