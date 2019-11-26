package com.smallanimals.tipboard.vo;

public class TipLikeVO {
	private String user_id;
	private int board_id;
	
	public TipLikeVO() {}

	public TipLikeVO(String user_id, int board_id) {
		super();
		this.user_id = user_id;
		this.board_id = board_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
}
