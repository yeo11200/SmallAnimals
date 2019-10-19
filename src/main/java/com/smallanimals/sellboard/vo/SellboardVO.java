package com.smallanimals.sellboard.vo;
import java.sql.Date;

public class SellboardVO {
	// field
	public int board_id, user_no, grade_no, edit_num, viewcnt;
	public String user_id, title, contents, user_type, ani_category;
	public Date reg_date, edit_date;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getGrade_no() {
		return grade_no;
	}
	public void setGrade_no(int grade_no) {
		this.grade_no = grade_no;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String GetTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String GetContents() {
		return contents;
	}
	public void SetContents(String contents) {
		this.contents = contents;
	}
	public String GetAni_category() {
		return ani_category;
	}
	public void SetAni_category(String ani_category) {
		this.ani_category = ani_category;
	}
	public Date GetReg_date() {
		return reg_date;
	}
	public void SetReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date GetEdit_date() {
		return edit_date;
	}
	public void SetEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}
}
