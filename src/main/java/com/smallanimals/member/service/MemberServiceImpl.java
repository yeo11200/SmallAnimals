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
	
	vo.setUserPwd(passwordEncoder.encode(vo.getUserPwd())); 
	if(vo.getUserRole()==null) { 
		vo.setUserRole("ROLE_USER"); 
	
	} 
	vo.setUserPhone(vo.getUserPhone()+vo.getUserPhone1()+vo.getUserPhone2());
	vo.setUserRegdate(vo.getYy()+vo.getMm()+vo.getDd());
		memberDAO.registerMember(vo);
	}

}
