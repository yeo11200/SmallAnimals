package com.smallanimals.tipboard.service;

import java.util.List;

import com.smallanimals.tipboard.vo.TipLikeVO;
import com.smallanimals.tipboard.vo.TipReplyVO;
import com.smallanimals.tipboard.vo.TipboardVO;

public interface TipboardService {
	public abstract List<TipboardVO> read();
	public abstract TipboardVO read(int board_id);
	public abstract int create(TipboardVO vo);
	public abstract int update(TipboardVO vo);
	public abstract int delete(int board_id);
	public abstract int viewUp(TipboardVO vo);
	public abstract int replyCreate(TipReplyVO vo);
	public abstract List<TipReplyVO> replyRead(int board_id);
	public abstract int replyDelete(int reply_id);
	public abstract TipLikeVO read_like(TipLikeVO vo);
	public abstract int create_like(TipLikeVO vo);
	public abstract int delete_like(TipLikeVO vo);
	public abstract TipLikeVO read_dislike(TipLikeVO vo);
	public abstract int create_dislike(TipLikeVO vo);
	public abstract int delete_dislike(TipLikeVO vo);
}
