package com.smallanimals.qnaboard.dao;

import java.util.List;

import com.smallanimals.qnaboard.vo.QnAboardVO;

public interface QnAboardDAO {
	public abstract List<QnAboardVO> select();
	public abstract QnAboardVO select(int board_id);
	public abstract int insert(QnAboardVO vo);
	public abstract int delete(int board_id);
}
