package com.smallanimals.tipboard.dao;

import java.util.List;

import com.smallanimals.tipboard.vo.TipLikeVO;
import com.smallanimals.tipboard.vo.TipReplyVO;
import com.smallanimals.tipboard.vo.TipboardVO;

public interface TipboardDAO {
	public abstract List<TipboardVO> select();
	public abstract TipboardVO select(int board_id);
	public abstract int insert(TipboardVO vo);
	public abstract int update(TipboardVO vo);
	public abstract int delete(int board_id);
	public abstract int viewUp(TipboardVO vo);
	public abstract int replyInsert(TipReplyVO vo);
	public abstract List<TipReplyVO> replySelect(int board_id);
	public abstract int replyDelete(int reply_id);
	public abstract TipLikeVO select_like(TipLikeVO vo);
	public abstract int insert_like(TipLikeVO vo);
	public abstract int delete_like(TipLikeVO vo);
	public abstract TipLikeVO select_dislike(TipLikeVO vo);
	public abstract int insert_dislike(TipLikeVO vo);
	public abstract int delete_dislike(TipLikeVO vo);
	
}
