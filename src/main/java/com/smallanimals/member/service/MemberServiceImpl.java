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
		memberDAO.registerMember(vo);
	}

	//회원정보 수정시 정보 값 불러오기
	@Override
	public MemberVO memberInfo(String userId) {
		return memberDAO.memberInfo(userId);
	}
	
	@Override
	public MemberVO idCheck(String userId) throws Exception {
		System.out.println("MemberServiceImpl 실행합니다~~~~~~~~~~~~~~~~~~~~~~~"+userId);
		return memberDAO.idCheck(userId);
	}
	
	@Override
	public void memberUpdate(MemberVO vo) {
		System.out.println("MemberServiceImpl 구간" + vo);
		 memberDAO.memberUpdate(vo);
	}
}