package com.semiproj.writer.model;

public class WriterVO {
	private int no;
	private String name;
	private String intro;
	private String photoFileName;
	private String photoOriginFileName;
	
	
	public WriterVO() {
		super();
	}
	public WriterVO(int no, String name, String intro, String photoFileName, String photoOriginFileName) {
		super();
		this.no = no;
		this.name = name;
		this.intro = intro;
		this.photoFileName = photoFileName;
		this.photoOriginFileName = photoOriginFileName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoOriginFileName() {
		return photoOriginFileName;
	}
	public void setPhotoOriginFileName(String photoOriginFileName) {
		this.photoOriginFileName = photoOriginFileName;
	}
	@Override
	public String toString() {
		return "WriterVO [no=" + no + ", name=" + name + ", intro=" + intro + ", photoFileName=" + photoFileName
				+ ", photoOriginFileName=" + photoOriginFileName + "]";
	}
	
	
}
