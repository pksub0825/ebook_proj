package com.semiproj.comments.model;

import java.sql.Timestamp;

public class CommentsVO {
	private int no;
	private String nickname; 
	Timestamp regdate;
	private String content;
	private int bookNo ;
	
	public CommentsVO() {
		super();
	}
	public CommentsVO(int no, String nickname,Timestamp regdate, String content, int bookNo) {
		super();
		this.no = no;
		this.nickname = nickname;
		this.regdate = regdate;
		this.content = content;
		this.bookNo = bookNo;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	@Override
	public String toString() {
		return "CommentsVO [no=" + no + ", nickname=" + nickname + " regdate=" + regdate
				+ ", content=" + content + ", bookNo=" + bookNo + "]";
	}
}
