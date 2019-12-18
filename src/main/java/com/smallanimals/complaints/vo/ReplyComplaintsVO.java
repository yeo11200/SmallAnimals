package com.smallanimals.complaints.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

// @AllArgsConstructor -> 생성자를 자동으로 생성하는 어노테이션 하지만, 여기서 에러가 발생했다.
public class ReplyComplaintsVO {

	private int replyNo, boardNo, depth, countLike, depthReply, parentsReply;
	private String replyContent, replyWriter;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyWriteDate;
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getCountLike() {
		return countLike;
	}
	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}
	public int getDepthReply() {
		return depthReply;
	}
	public void setDepthReply(int depthReply) {
		this.depthReply = depthReply;
	}
	public int getParentsReply() {
		return parentsReply;
	}
	public void setParentsReply(int parentsReply) {
		this.parentsReply = parentsReply;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getReplyWriteDate() {
		return replyWriteDate;
	}
	public void setReplyWriteDate(Date replyWriteDate) {
		this.replyWriteDate = replyWriteDate;
	}
	
	
}
