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
	public MemberVO memberInfo(String user_id) {
		
		return sqlSession.selectOne("member.memberInfo", user_id);
	}
	
	
//아이디 중복체크
//	@Override
//	public MemberVO idCheck(String user_id) throws Exception{
//		return sqlSession.selectOne("member.idCheck", user_id);
//	}

	@Override
	public MemberVO idCheck(String user_id) {
		System.out.println("요기는 MemberDAOImpl 실행하는곳!!!!"+user_id);
		return sqlSession.selectOne("member.idCheck",user_id);
	}
}