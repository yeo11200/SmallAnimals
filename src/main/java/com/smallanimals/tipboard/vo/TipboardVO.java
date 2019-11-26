package com.smallanimals.tipboard.vo;

import java.util.Date;

public class TipboardVO {
	private int board_id;
	private String user_id;
	private String title;
	private String contents;
	private Date reg_date;
	private Date edit_date;
	private int edit_num;
	private int viewcnt;
	
	public TipboardVO() {}

	public TipboardVO(int board_id, String user_id, String title, String contents, Date reg_date, Date edit_date,
			int edit_num, int viewcnt) {
		super();
		this.board_id = board_id;
		this.user_id = user_id;
		this.title = title;
		this.contents = contents;
		this.reg_date = reg_date;
		this.edit_date = edit_date;
		this.edit_num = edit_num;
		this.viewcnt = viewcnt;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

	public int getEdit_num() {
		return edit_num;
	}

	public void setEdit_num(int edit_num) {
		this.edit_num = edit_num;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
}
