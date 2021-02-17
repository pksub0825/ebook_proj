package com.semiproj.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.semiproj.db.ConnectionPoolMgr;

public class MemberDAO {
	private ConnectionPoolMgr pool;
	
	public MemberDAO() {
		pool=new ConnectionPoolMgr();
	}
	
	public int insertMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//1,2
			con=pool.getConnection();
			
			//3
			String sql="insert into member (no, email, pwd, nickname, name, hp, address)" + 
					" values(member_seq.nextval,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getEmail());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getNickname());
			ps.setString(4, vo.getName());
			ps.setString(5, vo.getHp());
			ps.setString(6, vo.getAddress());
			
			//4
			int cnt=ps.executeUpdate();
			System.out.println("회원가입 결과, cnt="+cnt+",매개변수 vo:"+vo);
			
			return cnt;
			
		} finally {
			pool.dbClose(ps, con);
		}
	}
	
	public int checkDup(String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="select count(email) from member where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			//4
			rs=ps.executeQuery();
			if(rs.next()){
				int count=rs.getInt(1);
				if(count>0){	//이미 존재=>사용불가
					result=MemberService.EXIST_EMAIL;
				}else{	//사용가능
					result=MemberService.NON_EXIST_EMAIL;
				}
			}//if
			
			System.out.println("이메일 중복 확인 결과 , result="+result+", 매개변수 email="+email);
			
			return result;
		} finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int checkNickname(String nickname) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int result = 0;
		try {
			//1,2
			con=pool.getConnection();
			//3
			String sql="select count(nickname) from member where nickname=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, nickname);
			
			//4
			rs=ps.executeQuery();
			if(rs.next()){
				int count=rs.getInt(1);
				if(count>0){	//이미 존재=>사용불가
					result=MemberService.EXIST_NICKNAME;
				}else{	//사용가능
					result=MemberService.NON_EXIST_NICKNAME;
				}
			}//if
			
			System.out.println("별명 중복 확인 결과 , result="+result+", 매개변수 nickname="+nickname);
			
			return result;
		} finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int loginCheck(String email, String pwd) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		
		try {
			con=pool.getConnection();
			
			String sql="select pwd from member" + 
					" where email=? and outdate is null";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				String dbPwd=rs.getString(1);
				if(dbPwd.equals(pwd)) {
					result=MemberService.LOGIN_OK;
				}else {
					result=MemberService.PWD_DISAGREE;
				}
			}else {
				result=MemberService.EMAIL_NONE;
			}
			
			System.out.println("로그인 처리 결과, result="+result
				+", 매개변수 email="+email+", pwd="+pwd);
			return result;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public MemberVO selectMember(String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		MemberVO vo = new MemberVO();
		
		try {
			con=pool.getConnection();
			
			String sql="select * from member where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			rs=ps.executeQuery();
			if(rs.next()){
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String pwd=rs.getString("pwd");
				String nickname=rs.getString("nickname");
				String hp=rs.getString("hp");
				String address=rs.getString("address");
				Timestamp regdate=rs.getTimestamp("regdate");
				Timestamp outdate=rs.getTimestamp("outdate");
				
				vo.setNo(no);
				vo.setPwd(pwd);
				vo.setEmail(email);
				vo.setNickname(nickname);
				vo.setName(name);
				vo.setHp(hp);
				vo.setAddress(address);
				vo.setOutdate(outdate);
				vo.setRegdate(regdate);
			}
			System.out.println("회원조회 결과 vo="+vo+", 매개변수 email="+email);
			return vo;
		} finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int updateMember(MemberVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=pool.getConnection();
			
			String sql="update member" +
					" set pwd=?, nickname=?, hp=?, address=?" +
					" where nickname=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getPwd());
			ps.setString(2, vo.getNickname());
			ps.setString(3, vo.getHp());
			ps.setString(4, vo.getAddress());
			ps.setString(5, vo.getNickname());
			
			int cnt=ps.executeUpdate();
			System.out.println("회원수정 결과 cnt="+cnt+", 매개변수 vo="+vo);
			return cnt;
		} finally {
			pool.dbClose(ps, con);
		}
	}
	
	public int withdrawMember(String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con=pool.getConnection();
			
			String sql="update member" + 
					" set outdate = sysdate" + 
					" where email = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			int cnt=ps.executeUpdate();
			System.out.println("회원탈퇴 결과, cnt="+cnt+", 매개변수 email="+email);
			return cnt;
		} finally {
			pool.dbClose(ps, con);
		}
	}
}
