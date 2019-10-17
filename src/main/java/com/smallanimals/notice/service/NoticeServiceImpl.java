package com.smallanimals.notice.service;

import java.util.List;

import com.smallanimals.notice.vo.NoticeVO;
import com.smallanimals.notice.vo.PreVO;

public interface NoticeServiceImpl {

	public List<NoticeVO> list(PreVO vo);
	public NoticeVO view(int no);
	public int insert(NoticeVO vo);
	public int update(NoticeVO vo);
	public int delete(int no);
}
