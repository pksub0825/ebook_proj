package com.semiproj.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MemberService {
	//이메일 중복확인시 사용
	public static final int EXIST_EMAIL=1;		//이메일가 존재하는경우
	public static final int NON_EXIST_EMAIL=2;	//이메일가 존재하지 않는 경우
	
	//이메일 중복확인시 사용
	public static final int EXIST_NICKNAME=1;		//별명이 존재하는경우
	public static final int NON_EXIST_NICKNAME=2;	//별명이 존재하지 않는 경우
	
	//로그인 처리시 사용
	public static final int LOGIN_OK=1;	//로그인 성공
	public static final int EMAIL_NONE=2;	//이메일가 없는경우
	public static final int PWD_DISAGREE=3;	//비밀번호 불일치
		
	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao=new MemberDAO();
	}
	
	public int insertMember(MemberVO vo) throws SQLException {
		return memberDao.insertMember(vo);
	}
	
	public int checkDup(String email) throws SQLException {
		return memberDao.checkDup(email);
	}
	
	public int checkNickname(String nickname) throws SQLException {
		return memberDao.checkNickname(nickname);
	}

	
	public int loginCheck(String email, String pwd) throws SQLException {
		return memberDao.loginCheck(email, pwd);
	}
	
	public MemberVO selectMember(String email) throws SQLException {
		return memberDao.selectMember(email);
	}
	
	public int updateMember(MemberVO vo) throws SQLException {
		return memberDao.updateMember(vo);
	}
	
	public int withdrawMember(String email) throws SQLException {
		return memberDao.withdrawMember(email);
	}
}
