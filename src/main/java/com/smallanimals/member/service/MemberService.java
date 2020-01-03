package com.smallanimals.member.service;

import com.smallanimals.member.vo.MemberVO;

public interface MemberService {

	//회원가입
	void registerMember(MemberVO vo);
	
	//회원정보 수정 시 정보값 불러오기
	MemberVO memberInfo(String userId);
	
	//아이디 체크
	public MemberVO idCheck(String userId) throws Exception;
	
	//회원정보 수정
	public void memberUpdate(MemberVO vo);
	
	//회원탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
}

