package com.smallanimals.member.dao;

import com.smallanimals.member.vo.MemberVO;

public interface MemberDAO {

	//회원가입
	void registerMember(MemberVO vo);
	
	MemberVO memberInfo(String userId);

	public MemberVO idCheck(String userId) throws Exception;
	
	public void memberUpdate(MemberVO vo);

	//회원탈퇴
		public void memberDelete(MemberVO vo) throws Exception;
}