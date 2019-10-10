package com.smallanimals.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.smallanimals.member.vo.AuthoritiesVO;

public class AuthoritiesDAO {
	 	@Autowired
	    private SqlSessionTemplate sqlSession;
	 
	    public AuthoritiesVO getUserById(String username) {
	        return sqlSession.selectOne("user.selectUserById", username);
	    }

}
