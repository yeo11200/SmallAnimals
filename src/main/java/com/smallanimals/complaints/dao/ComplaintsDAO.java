package com.smallanimals.complaints.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.smallanimals.complaints.service.ComplaintsImfo;
import com.smallanimals.complaints.vo.ComplaintsVO;
import com.smallanimals.complaints.vo.ReplyComplaintsVO;

@Repository
public class ComplaintsDAO implements ComplaintsImfo{

	private SqlSessionTemplate sql;
	
	public ComplaintsDAO(SqlSessionTemplate template) {
		this.sql = template;
	}
	private static String name = "com.smallanimals.complaints.";

	@Override
	public List<ComplaintsVO> list() {
		// TODO Auto-generated method stub
		return sql.selectList(name+"list");
	}

	@Override
	public ComplaintsVO view(int no) {
		// TODO Auto-generated method stub
		return sql.selectOne(name+"view", no);
	}

	@Override
	public int insert(ComplaintsVO vo) {
		// TODO Auto-generated method stub
		return sql.insert(name+"insert", vo);
	}

	@Override
	public int update(ComplaintsVO vo) {
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
	
	@Override
	public List<ReplyComplaintsVO> replyList(int boardNo) {
		// TODO Auto-generated method stub
		System.out.println(name+"replyList");
		return sql.selectList(name+"replyList", boardNo);
	}

	@Override
	public int replyInsert(ReplyComplaintsVO rvo) {
		// TODO Auto-generated method stub
		return sql.insert(name+"replyInsert", rvo);
	}

	@Override
	public int replyUpdate(ReplyComplaintsVO rvo) {
		// TODO Auto-generated method stub
		return sql.update(name+"replyUpdate", rvo);
	}

	@Override
	public int replyDelete(int replyNo) {
		// TODO Auto-generated method stub
		return sql.delete(name+"replyDelete", replyNo);
	}
	
	public List<ReplyComplaintsVO> replyCommintList(int replyNo) {
		// TODO Auto-generated method stub
		return sql.selectList(name+"replyCommintList", replyNo);
	}
//
//	@Override
//	public int replyCommintInsert(ReplyComplaintsVO rvo) {
//		// TODO Auto-generated method stub
//		return sql.insert(name + "replyCommentInsert", rvo);
//	}
//
//	@Override
//	public int replyCommintUpdate(ReplyComplaintsVO rvo) {
//		// TODO Auto-generated method stub
//		return sql.update(name + "replyCommentUpdate", rvo);
//	}
//
//	@Override
//	public int replyCommintDelete(int rno) {
//		// TODO Auto-generated method stub
//		return sql.delete(name + "replyCommentDelete", rno);
//	}

}
