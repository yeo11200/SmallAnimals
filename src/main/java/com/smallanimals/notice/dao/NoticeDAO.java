package com.smallanimals.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.notice.service.NoticeServiceImpl;
import com.smallanimals.notice.vo.NoticeVO;
import com.smallanimals.notice.vo.PreVO;

@Repository
public class NoticeDAO{

	public SqlSessionTemplate sql;
	
	@Autowired
	public NoticeDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public final String name = "com.smallanimals.notice.";
	public List<NoticeVO> list(PreVO vo) {
		// TODO Auto-generated method stub
		return sql.selectList(name+"list", vo);
	}

	public NoticeVO view(int no) {
		// TODO Auto-generated method stub
		return sql.selectOne(name+"view", no);
	}

	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.insert(name+"insert", vo);
	}

	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.update(name+"update", vo);
	}

	public int delete(int no) {
		// TODO Auto-generated method stub
		return sql.delete(name+"delete", no);
	}
	
	public int count(PreVO vo) {
		return sql.selectOne(name+"count", vo);
	}
}
