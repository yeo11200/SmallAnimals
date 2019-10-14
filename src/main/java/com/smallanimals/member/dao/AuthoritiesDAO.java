package com.smallanimals.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.member.vo.AuthoritiesVO;

@Repository("AuthoritiesDAO")
public class AuthoritiesDAO {
	 	@Autowired
	    private SqlSessionTemplate sqlSession;
	 	
	    public AuthoritiesVO getUserById(String username) {
	    	System.out.println("dao로 안옵니다;");
	        return sqlSession.selectOne("member.selectUserById", username);
	    }
	    
	    public String getString(String username) {
	    	System.out.println(username);
	    	return username + "!" ;
	    }

}

