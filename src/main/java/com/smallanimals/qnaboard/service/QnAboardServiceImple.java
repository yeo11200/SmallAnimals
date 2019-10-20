package com.smallanimals.qnaboard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallanimals.qnaboard.dao.QnAboardDAO;
import com.smallanimals.qnaboard.vo.QnAboardVO;

@Service
public class QnAboardServiceImple implements QnAboardService {
	private static final Logger logger = LoggerFactory.getLogger(QnAboardServiceImple.class);

	@Autowired
	private QnAboardDAO dao;

	@Override
	public List<QnAboardVO> read() {
		logger.info("read list 호출");
		return dao.select();
	}

	@Override
	public QnAboardVO read(int board_id) {
		logger.info("read vo 호출");
		return dao.select(board_id);
	}

	@Override
	public int create(QnAboardVO vo) {
		logger.info("create 호출");
		return dao.insert(vo);
	}
	
	@Override
	public int update(QnAboardVO vo) {
		logger.info("update 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int board_id) {
		logger.info("delete 호출");
		return dao.delete(board_id);
	}
	
	@Override
	public int viewUp(QnAboardVO vo) {
		logger.info("viewUP 호출");
		return dao.viewUp(vo);
	}

}
