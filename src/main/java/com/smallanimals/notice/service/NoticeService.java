package com.smallanimals.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallanimals.notice.dao.NoticeDAO;
import com.smallanimals.notice.vo.NoticeVO;

@Service
public class NoticeService implements NoticeServiceImpl {
	
	private NoticeDAO dao;
	
	@Autowired
	public NoticeService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<NoticeVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public NoticeVO view(int no) {
		// TODO Auto-generated method stub
		return dao.view(no);
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}