package com.semiproj.bookinfo.model;

import java.sql.Timestamp;

public class BookInfoVO {
	private int no;
	private String title;
	private int price;
	private Timestamp regdate;
	private String publisher;
	private int wrNo;
	private String content;
	private String txtFileName;
	private String coverFileName;
	private String txtOriginFileName;
	private String coverOriginFileName;
	private int readCount;
	
	public BookInfoVO() {
		super();
	}
	public BookInfoVO(int no, String title, int price, Timestamp regdate, String publisher, int wrNo, String content,
			String txtFileName, String coverFileName, String txtOriginFileName, String coverOriginFileName, int readCount) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.regdate = regdate;
		this.publisher = publisher;
		this.wrNo = wrNo;
		this.content = content;
		this.txtFileName = txtFileName;
		this.coverFileName = coverFileName;
		this.txtOriginFileName = txtOriginFileName;
		this.coverOriginFileName = coverOriginFileName;
		this.readCount = readCount;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getWrNo() {
		return wrNo;
	}
	public void setWrNo(int wrNo) {
		this.wrNo = wrNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTxtFileName() {
		return txtFileName;
	}
	public void setTxtFileName(String txtFileName) {
		this.txtFileName = txtFileName;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getTxtOriginFileName() {
		return txtOriginFileName;
	}
	public void setTxtOriginFileName(String txtOriginFileName) {
		this.txtOriginFileName = txtOriginFileName;
	}
	public String getCoverOriginFileName() {
		return coverOriginFileName;
	}
	public void setCoverOriginFileName(String coverOriginFileName) {
		this.coverOriginFileName = coverOriginFileName;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	@Override
	public String toString() {
		return "BookInfoVO [no=" + no + ", title=" + title + ", price=" + price + ", regdate=" + regdate
				+ ", publisher=" + publisher + ", wrNo=" + wrNo + ", content=" + content + ", txtFileName="
				+ txtFileName + ", coverFileName=" + coverFileName + ", txtOriginFileName=" + txtOriginFileName
				+ ", coverOriginFileName=" + coverOriginFileName + ", readCount=" + readCount + "]";
	}
}
