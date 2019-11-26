package com.smallanimals.tipboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.tipboard.vo.TipLikeVO;
import com.smallanimals.tipboard.vo.TipReplyVO;
import com.smallanimals.tipboard.vo.TipboardVO;

@Repository
public class TipboardDAOImple implements TipboardDAO {
	private static final String NAMESPACE = "com.smallanimals.tipboard"; 
	private static final Logger logger = LoggerFactory.getLogger(TipboardDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<TipboardVO> select() {
		logger.info("DAO : select list 호출");
		return sqlSession.selectList(NAMESPACE + ".select_list");
	}

	@Override
	public TipboardVO select(int board_id) {
		logger.info("DAO : select vo 호출");
		return sqlSession.selectOne(NAMESPACE + ".select_by_no", board_id);
	}

	@Override
	public int insert(TipboardVO vo) {
		logger.info("DAO : insert 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(TipboardVO vo) {
		logger.info("DAO : update");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int board_id) {
		logger.info("DAO : delete 호출");
		return sqlSession.delete(NAMESPACE + ".delete", board_id);
	}
	
	@Override
	public int viewUp(TipboardVO vo) {
		logger.info("DAO : viewUp");
		return sqlSession.update(NAMESPACE + ".viewUp", vo);
	}

	@Override
	public int replyInsert(TipReplyVO vo) {
		logger.info("DAO : replyInsert");
		return sqlSession.insert(NAMESPACE + ".reply_insert", vo);
	}

	@Override
	public List<TipReplyVO> replySelect(int board_id) {
		logger.info("DAO : replySelect");
		return sqlSession.selectList(NAMESPACE + ".reply_select", board_id);
	}

	@Override
	public int replyDelete(int reply_id) {
		logger.info("DAO : replyDelete");
		return sqlSession.delete(NAMESPACE + ".reply_delete", reply_id);
	}

	@Override
	public TipLikeVO select_like(TipLikeVO vo) {
		logger.info("DAO : select_like");
		return sqlSession.selectOne(NAMESPACE + ".select_like", vo);
	}

	@Override
	public int insert_like(TipLikeVO vo) {
		logger.info("DAO : insert_like");
		return sqlSession.insert(NAMESPACE + ".insert_like", vo);
	}

	@Override
	public int delete_like(TipLikeVO vo) {
		logger.info("DAO : delete_like");
		return sqlSession.delete(NAMESPACE + ".delete_like", vo);
	}

	@Override
	public TipLikeVO select_dislike(TipLikeVO vo) {
		logger.info("DAO : select_dislike");
		return sqlSession.selectOne(NAMESPACE + ".select_dislike", vo);
	}

	@Override
	public int insert_dislike(TipLikeVO vo) {
		logger.info("DAO : insert_dislike");
		return sqlSession.insert(NAMESPACE + ".insert_dislike", vo);
	}

	@Override
	public int delete_dislike(TipLikeVO vo) {
		logger.info("DAO : delete_dislike");
		return sqlSession.insert(NAMESPACE + ".delete_dislike", vo);
	}

}
