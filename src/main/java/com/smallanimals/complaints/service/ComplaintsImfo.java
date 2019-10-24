package com.smallanimals.complaints.service;

import java.util.List;

import com.smallanimals.complaints.vo.ComplaintsVO;

public interface ComplaintsImfo {
	
	public List<ComplaintsVO> list();
	public ComplaintsVO view(int no);
	public int insert(ComplaintsVO vo);
	public int update(ComplaintsVO vo);
	public int delete(int no);
}
