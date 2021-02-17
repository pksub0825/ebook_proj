package com.semiproj.common;

import java.util.Date;


public class Utility {
	//public static final String TEST_DIR="C:\\lecture\\workspace_list\\jsp_ws\\mystudy\\WebContent\\pds_upload";
	public static final String TEST_DIR="C:\\lecture\\workspace_list\\proj_ws\\semiproj\\WebContent\\file_upload";
	//public static final String UPLOAD_DIR="pds_upload";
	public static final String UPLOAD_DIR="file_upload";
	public static String displayRe(int step) {
		//답변글인 경우 단계별로 이미지 보여주기
		String str="";
		if(step>0){
			for(int k=0; k<step; k++){
				str+="&nbsp";
			}//for
			str+="<img src='../images/re.gif'>";
		}//if
		
		return str;
	}
	
	public static String cutString(String title, int len) {
		//제목이 30자 이상인 경우 일부만 추출하기
		String result=title;
		if(title.length()>len) {
			result=title.substring(0, len)+"..";
		}
		
		return result;
	}
	
	//Timestamp의 부모인 Date에 regdate를 넣고 매개변수 처리
	public static String displayNew(Date regdate) {
		//24시간 이내의 글인 경우 new 이미지 보여주기
		Date today=new Date();
		long gap=(today.getTime()-regdate.getTime())/1000; //초
		gap=gap/(60*60); //시간
		
		String result="";
		if(gap<24) {
			result="<img src='../images/new.gif'>";
		}//if
		
		return result;
	}
	
	/*public static String displayFile(String fileName) {
		String result="";
		if(fileName!=null && !fileName.isEmpty()) {
			result="<img src='../images/file.gif' alt='파일 이미지'>";
		}
		return result;
	}*/
	
	public static String getFileInfo(String originName) {
		String result="";
		
		if(originName!=null && !originName.isEmpty()) {
			result="<img src='../images/file.gif' alt='파일 이미지'>";
			result+=" "+originName;
		}
		return result;
	}
}
