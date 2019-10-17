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

}
