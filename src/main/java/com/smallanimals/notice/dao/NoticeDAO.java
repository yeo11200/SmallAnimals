package com.smallanimals.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.notice.service.NoticeServiceImpl;
import com.smallanimals.notice.vo.NoticeVO;

@Repository
public class NoticeDAO implements NoticeServiceImpl {

	public SqlSessionTemplate sql;
	
	@Autowired
	public NoticeDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public final String name = "com.smallanimals.notice.";
	@Override
	public List<NoticeVO> list() {
		// TODO Auto-generated method stub
		return sql.selectList(name+"list");
	}

	@Override
	public NoticeVO view(int no) {
		// TODO Auto-generated method stub
		return sql.selectOne(name+"view", no);
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.insert(name+"insert", vo);
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sql.update(name+"update", vo);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return sql.delete(name+"delete", no);
	}
	
	public int count() {
		return sql.selectOne(name+"count");
	}
}
