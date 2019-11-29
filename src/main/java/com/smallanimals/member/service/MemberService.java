package com.smallanimals.member.service;

import com.smallanimals.member.vo.MemberVO;

public interface MemberService {

	
	void registerMember(MemberVO vo);
	//회원정보 수정 시 정보값 불러오기
	MemberVO memberInfo(String user_id);
	
	//아이디 확인
	// public String idCheck(String user_id) throws Exception;
	String idCheck(String user_id);
	
	
	}