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
	public MemberVO memberInfo(String user_id) {
	
		return memberDAO.memberInfo(user_id);
	}
	//아이디 중복체크
//	@Override
//	public MemberVO idCheck(String user_id) throws Exception{
//		return memberDAO.idCheck(user_id);
//	}
	
	//아이디 중복체크
	@Override
	public String idCheck(String user_id) {
		int count=memberDAO.idCheck(user_id);
		return (count==0) ? "ok":"fail";
	}
}