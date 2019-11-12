package com.smallanimals.complaints.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReplyComplaintsVO {

	private int replyNo, boardNo, depth;
	private String replyContent, replyWriter;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyWriteDate;
}
