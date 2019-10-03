package com.smallanymals.notice.vo;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NoticeVO {
	public int no, emp;
	public String title, writer, content;
	public Date startDate, endDate, writeDate;

}
