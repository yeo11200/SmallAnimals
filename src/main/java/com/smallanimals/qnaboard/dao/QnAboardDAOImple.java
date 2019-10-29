package com.smallanimals.qnaboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smallanimals.qnaboard.vo.QnAboardVO;

@Repository
public class QnAboardDAOImple implements QnAboardDAO {
	private static final String NAMESPACE = "com.smallanimals.qnaboard"; 
	private static final Logger logger = LoggerFactory.getLogger(QnAboardDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<QnAboardVO> select() {
		logger.info("select list 호출");
		return sqlSession.selectList(NAMESPACE + ".select_list");
	}

	@Override
	public QnAboardVO select(int board_id) {
		logger.info("select vo 호출");
		return sqlSession.selectOne(NAMESPACE + ".select_by_no", board_id);
	}

	@Override
	public int insert(QnAboardVO vo) {
		logger.info("insert vo 호출");
		System.out.println("제목 : " + vo.getTitle());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int delete(int board_id) {
		logger.info("delete 호출");
		return sqlSession.delete(NAMESPACE + ".delete", board_id);
	}

}
