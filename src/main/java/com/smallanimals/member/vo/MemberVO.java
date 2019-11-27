package com.smallanimals.member.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberVO implements UserDetails{
  private String userNo;
  private String userId;
  private String userPwd;
  private String userNickname;
  private String userName;
  private String userPhone;
  private String userPhone1;
  private String userPhone2;
  private String yy;
  private String mm;
  public String getYy() {
	return yy;
}


public void setYy(String yy) {
	this.yy = yy;
}


public String getMm() {
	return mm;
}


public void setMm(String mm) {
	this.mm = mm;
}


public String getDd() {
	return dd;
}


public void setDd(String dd) {
	this.dd = dd;
}


private String dd;
  
  public String getUserPhone1() {
	return userPhone1;
}


public void setUserPhone1(String userPhone1) {
	this.userPhone1 = userPhone1;
}


public String getUserPhone2() {
	return userPhone2;
}


public void setUserPhone2(String userPhone2) {
	this.userPhone2 = userPhone2;
}


private String userRegdate;
  private String userAddr;
  private String userRole;
  private boolean userEnabled;
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	 ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
     auth.add(new SimpleGrantedAuthority(userRole));
     return auth;
}


public MemberVO() {
	super();
}


public MemberVO(String userNo, String userId, String userPwd, String userNickname, String userName, String userPhone,
		String userPhone1, String userPhone2,	String userRegdate, String yy,String mm ,String dd,String userAddr, String userRole, boolean userEnabled) {
	super();
	this.userNo = userNo;
	this.userId = userId;
	this.userPwd = userPwd;
	this.userNickname = userNickname;
	this.userName = userName;
	this.userPhone = userPhone;
	this.userPhone1 = userPhone1;
	this.userPhone2 = userPhone2;
	this.yy = yy;
	this.mm = mm;
	this.dd = dd;
	this.userRegdate = userRegdate;
	this.userAddr = userAddr;
	this.userRole = userRole;
	this.userEnabled = userEnabled;
}


@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return userPwd;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return userId;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return userEnabled;
}
public String getUserNo() {
	return userNo;
}
public void setUserNo(String userNo) {
	this.userNo = userNo;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPwd() {
	return userPwd;
}
public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}
public String getUserNickname() {
	return userNickname;
}
public void setUserNickname(String userNickname) {
	this.userNickname = userNickname;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public String getUserRegdate() {
	return userRegdate;
}
public void setUserRegdate(String userRegdate) {
	this.userRegdate = userRegdate;
}
public String getUserAddr() {
	return userAddr;
}
public void setUserAddr(String userAddr) {
	this.userAddr = userAddr;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public boolean isUserEnabled() {
	return userEnabled;
}
public void setUserEnabled(boolean userEnabled) {
	this.userEnabled = userEnabled;
}


@Override
public String toString() {
	return "MemberVO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userNickname="
			+ userNickname + ", userName=" + userName + ", userPhone=" + userPhone + ", userRegdate=" + userRegdate
			+ ", userAddr=" + userAddr + ", userRole=" + userRole + ", userEnabled=" + userEnabled + "]";
}




}
