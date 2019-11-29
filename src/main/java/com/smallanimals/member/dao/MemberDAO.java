package com.smallanimals.member.dao;

import com.smallanimals.member.vo.MemberVO;

public interface MemberDAO {

	void registerMember(MemberVO vo);
	
	MemberVO memberInfo(String user_id);
	
	//public MemberVO idCheck(String user_id) throws Exception;
	int idCheck(String user_id);
}