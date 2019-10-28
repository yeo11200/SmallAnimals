package com.smallanimals.complaints.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.smallanimals.complaints.service.ComplaintsImfo;
import com.smallanimals.complaints.vo.ComplaintsVO;

@Repository
public class ComplaintsDAO implements ComplaintsImfo{

	private SqlSessionTemplate sql;
	
	public ComplaintsDAO(SqlSessionTemplate template) {
		this.sql = template;
	}
	private static String name = "com.smallanimals.complaints.";
<<<<<<< HEAD
=======
	
>>>>>>> complaints
	@Override
	public List<ComplaintsVO> list() {
		// TODO Auto-generated method stub
		return sql.selectList(name+"list");
	}

	@Override
	public ComplaintsVO view(int no) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return null;
=======
		return sql.selectOne(name+"view");
>>>>>>> complaints
	}

	@Override
	public int insert(ComplaintsVO vo) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return sql.insert(name+"insert", vo);
>>>>>>> complaints
	}

	@Override
	public int update(ComplaintsVO vo) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return sql.update(name+"update", vo);
>>>>>>> complaints
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return 0;
=======
		return sql.delete(name+"delete", no);
>>>>>>> complaints
	}

}
