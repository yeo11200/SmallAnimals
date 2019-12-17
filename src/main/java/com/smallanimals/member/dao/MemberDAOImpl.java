package com.smallanimals.member.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.smallanimals.member.vo.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Resource
	private SqlSessionTemplate sqlSession;
	@Override
	public void registerMember(MemberVO vo) {
		sqlSession.insert("member.registerMember",vo);
	
	}
	
	@Override
	public MemberVO memberInfo(String userId) {
		
		return sqlSession.selectOne("member.memberInfo", userId);
	}
	
	@Override
	public MemberVO idCheck(String userId) {
		System.out.println("요기는 MemberDAOImpl 실행하는곳!!!!"+userId);
		return sqlSession.selectOne("member.idCheck",userId);
	}
	
	@Override
	public void memberUpdate(MemberVO vo) {
		System.out.println("MemberDAOImpl 실행 구간" + vo);
		 sqlSession.update("member.memberUpdate", vo);
	}
}