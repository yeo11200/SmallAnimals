package com.smallanymals.notice.service;

import java.util.List;

import com.smallanymals.notice.vo.NoticeVO;

public interface NoticeServiceImpl {

	public List<NoticeVO> list();
	public NoticeVO view(int no);
	public int insert(NoticeVO vo);
	public int update(NoticeVO vo);
	public int delete(int no);
}
