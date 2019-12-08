package com.smallanimals.complaints.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

// @AllArgsConstructor -> 생성자를 자동으로 생성하는 어노테이션 하지만, 여기서 에러가 발생했다.
@Data
public class ReplyComplaintsVO {

	private int replyNo, boardNo, depth, countLike, depthReply;
	private String replyContent, replyWriter;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyWriteDate;
	
	
}
