package com.smallanimals.tipboard.vo;

import java.util.Date;

public class TipReplyVO {
	private int reply_id;
	private int board_id;
	private String user_id;
	private String contents;
	private Date reg_date;
	
	public TipReplyVO() {}

	public TipReplyVO(int reply_id, int board_id, String user_id, String contents, Date reg_date) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.user_id = user_id;
		this.contents = contents;
		this.reg_date = reg_date;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
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
	
}
