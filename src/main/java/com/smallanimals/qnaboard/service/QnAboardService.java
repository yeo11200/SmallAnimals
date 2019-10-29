package com.smallanimals.qnaboard.service;

import java.util.List;

import com.smallanimals.qnaboard.vo.QnAboardVO;

public interface QnAboardService {
	public abstract List<QnAboardVO> read();
	public abstract QnAboardVO read(int board_id);
	public abstract int create(QnAboardVO vo);
	public abstract int update(QnAboardVO vo);
	public abstract int delete(int board_id);
	public abstract int viewUp(QnAboardVO vo);
}
