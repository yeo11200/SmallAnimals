package com.smallanimals.complaints.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smallanimals.complaints.dao.ComplaintsDAO;
import com.smallanimals.complaints.service.ComplaintsImfo;
import com.smallanimals.complaints.vo.ComplaintsVO;
import com.smallanimals.complaints.vo.ReplyComplaintsVO;

@Service
@Transactional
public class ComplaintsService implements ComplaintsImfo{

	private ComplaintsDAO dao;
	
	public ComplaintsService(ComplaintsDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<ComplaintsVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public ComplaintsVO view(int no) {
		// TODO Auto-generated method stub
		return dao.view(no);
	}

	@Override
	public int insert(ComplaintsVO vo) {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}

	@Override
	public int update(ComplaintsVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

	@Override
	public List<ReplyComplaintsVO> replyList(int boardNo) {
		// TODO Auto-generated method stub
		return dao.replyList(boardNo);
	}

	public int count() {
		return dao.count();
	}
	@Override
	public int replyInsert(ReplyComplaintsVO rvo) {
		// TODO Auto-generated method stub
		
		// 그냥 댓글일 경우
		// 깊이의 갯수가 없을 경우 1을 추가
		if(rvo.getDepthReply() == 0) {
			rvo.setDepth(1);
			
		// 대댓글일 경우
		// 깊이가 1이라도 있으면 깊이 + 1해서 대댓글 구현
		}else {
			rvo.setDepth(rvo.getDepth() + 1);
		}
		
		// 그냥 댓글일 경우
		// 댓글일 경우에는 replyNo가 없는 것이 당연, 앞에서 replyNo가 안넘어오기 떄문에
		if(rvo.getReplyNo() == 0) {
			rvo.setParentsReply(0);
		}else {
			// 대댓글일 경우
			// 하지만 replyNo가 있으면, 대댓글인 것을 알 수 있다.
			rvo.setParentsReply(rvo.getReplyNo());
		}
		
		return dao.replyInsert(rvo);
	}

	@Override
	public int replyUpdate(ReplyComplaintsVO rvo) {
		// TODO Auto-generated method stub
		return dao.replyUpdate(rvo);
	}

	@Override
	public int replyDelete(int rno) {
		// TODO Auto-generated method stub
		return dao.replyDelete(rno);
	}
	
	public List<ReplyComplaintsVO> replyCommintList(int replyNo) {
		// TODO Auto-generated method stub
		return dao.replyCommintList(replyNo);
	}
}
