package com.smallanimals.member.dao;

import com.smallanimals.member.vo.MemberVO;

public interface MemberDAO {

	void registerMember(MemberVO vo);
	
	MemberVO memberInfo(String userId);

	public MemberVO idCheck(String userId) throws Exception;
	
	public void memberUpdate(MemberVO vo);
}