package com.smallanimals.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smallanimals.member.dao.MemberDAO;
import com.smallanimals.member.vo.MemberVO;



@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	
	 @Autowired private PasswordEncoder passwordEncoder;
	
	 
	@Override
	public void registerMember(MemberVO vo) {
		System.out.println(vo.getUserName());
	vo.setUserPwd(passwordEncoder.encode(vo.getUserPwd())); 
		
		  if(vo.getUserRole()==null) {
		  vo.setUserRole("ROLE_USER");
		  }
		 
		memberDAO.registerMember(vo);
	}

}
