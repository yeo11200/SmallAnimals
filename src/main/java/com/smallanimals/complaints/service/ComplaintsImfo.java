package com.smallanimals.complaints.service;

import java.util.List;

import com.smallanimals.complaints.vo.ComplaintsVO;
import com.smallanimals.complaints.vo.ReplyComplaintsVO;

public interface ComplaintsImfo {
	
	public List<ComplaintsVO> list();
	public ComplaintsVO view(int no);
	public int insert(ComplaintsVO vo);
	public int update(ComplaintsVO vo);
	public int delete(int no);
	
	public List<ReplyComplaintsVO> replyList(int replyNo);
	public int replyInsert(ReplyComplaintsVO rvo);
	public int replyUpdate(ReplyComplaintsVO rvo);
	public int replyDelete(int rno);
	public List<ReplyComplaintsVO> replyCommintList(int replyNo);
	public int replyCommintInsert(ReplyComplaintsVO rvo);
	public int replyCommintUpdate(ReplyComplaintsVO rvo);
	public int replyCommintDelete(int rno);
}
