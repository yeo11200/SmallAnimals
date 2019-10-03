package com.smallanymals.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanymals.notice.service.NoticeServiceImpl;
import com.smallanymals.notice.vo.NoticeVO;

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
		return null;
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int count() {
		return sql.selectOne(name+"count");
	}
}
