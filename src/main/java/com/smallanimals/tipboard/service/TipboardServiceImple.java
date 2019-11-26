package com.smallanimals.tipboard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallanimals.qnaboard.service.QnAboardServiceImple;
import com.smallanimals.tipboard.dao.TipboardDAO;
import com.smallanimals.tipboard.vo.TipLikeVO;
import com.smallanimals.tipboard.vo.TipReplyVO;
import com.smallanimals.tipboard.vo.TipboardVO;

@Service
public class TipboardServiceImple implements TipboardService{
	private static final Logger logger = LoggerFactory.getLogger(QnAboardServiceImple.class);

	@Autowired
	private TipboardDAO dao;

	@Override
	public List<TipboardVO> read() {
		logger.info("Service : read list 호출");
		return dao.select();
	}

	@Override
	public TipboardVO read(int board_id) {
		logger.info("Service : read vo 호출");
		return dao.select(board_id);
	}

	@Override
	public int create(TipboardVO vo) {
		logger.info("Service : create 호출");
		return dao.insert(vo);
	}
	
	@Override	
	public int update(TipboardVO vo) {
		logger.info("Service : update 호출");
		return dao.update(vo);
	}

	@Override
	public int delete(int board_id) {
		logger.info("Service : delete 호출");
		return dao.delete(board_id);
	}
	
	@Override
	public int viewUp(TipboardVO vo) {
		logger.info("Service : viewUP 호출");
		return dao.viewUp(vo);
	}

	@Override
	public int replyCreate(TipReplyVO vo) {
		logger.info("Service : replyCreate 호출");
		return dao.replyInsert(vo);
	}

	@Override
	public List<TipReplyVO> replyRead(int board_id) {
		logger.info("Service : replyRead 호출");
		return dao.replySelect(board_id);
	}

	@Override
	public int replyDelete(int reply_id) {
		logger.info("Service : replyDelete 호출");
		return dao.replyDelete(reply_id);
	}

	@Override
	public TipLikeVO read_like(TipLikeVO vo) {
		logger.info("Service : read_like 호출");
		return dao.select_like(vo);
	}

	@Override
	public int create_like(TipLikeVO vo) {
		logger.info("Service : create_like 호출");
		return dao.insert_like(vo);
	}

	@Override
	public int delete_like(TipLikeVO vo) {
		logger.info("Service : delete_like 호출");
		return dao.delete_like(vo);
	}

	@Override
	public TipLikeVO read_dislike(TipLikeVO vo) {
		logger.info("Service : read_dislike 호출");
		return dao.select_dislike(vo);
	}

	@Override
	public int create_dislike(TipLikeVO vo) {
		logger.info("Service : create_dislike 호출");
		return dao.insert_dislike(vo);
	}

	@Override
	public int delete_dislike(TipLikeVO vo) {
		logger.info("Service : delete_dislike 호출");
		return dao.delete_dislike(vo);
	}

}
