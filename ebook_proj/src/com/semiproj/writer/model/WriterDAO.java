package com.semiproj.writer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semiproj.db.ConnectionPoolMgr;

public class WriterDAO {
	private ConnectionPoolMgr pool;
	
	public WriterDAO() {
		pool=new ConnectionPoolMgr();
	}
	
	public int insertWriter(WriterVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
		con=pool.getConnection();
		
		String sql="insert into writer\r\n" + 
				"values(writer_seq.nextval, ?, ?, ?, ?)";
		ps=con.prepareStatement(sql);
		
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getIntro());
		ps.setString(3, vo.getPhotoFileName());
		ps.setString(4, vo.getPhotoOriginFileName());
				
		int cnt=ps.executeUpdate();
		System.out.println("글쓰기 결과 cnt="+cnt+", 매개변수 vo="+vo);
		return cnt;
		
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	
	
	public WriterVO selectByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		WriterVO vo=new WriterVO();
		
		try {
			con=pool.getConnection();
			
			String sql="select * from writer where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				vo.setNo(no);
				vo.setName(rs.getString("name"));
				vo.setIntro(rs.getString("intro"));
				vo.setPhotoFileName(rs.getString("photofilename"));
				vo.setPhotoOriginFileName(rs.getString("photooriginfilename"));
			}
			System.out.println("작가 상세보기 결과 vo="+vo+", 매개변수 no="+no);
			return vo;
					
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}

	public List<WriterVO> selectByName(String name) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<WriterVO> list=new ArrayList<WriterVO>();
		try {
			con=pool.getConnection();
			
			String sql="select * from writer"
					+ " where name like '%'||?||'%'";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String dbName=rs.getString("name");
				String intro=rs.getString("intro");
				String photoFileName=rs.getString("photofilename");
				String photoOriginFileName=rs.getString("photooriginfilename");
				
				WriterVO vo=new WriterVO(no, dbName, intro, photoFileName, photoOriginFileName);
				list.add(vo);
			}
			
			System.out.println("작가 이름 조회 결과 list.size()="+list.size()+", 매개변수 name="+name);
			
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}

	public List<WriterVO> selectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		List<WriterVO> list= new ArrayList<WriterVO>();
		
		try {
			con=pool.getConnection();
			
			String sql="select * from writer order by no desc";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				int wrno=rs.getInt("no");
				String name=rs.getString("name");
				String intro=rs.getString("intro");
				String photoFileName=rs.getString("photoFileName");
				String photoOriginFileName=rs.getString("photoOriginFileName");
				
				WriterVO vo=new WriterVO(wrno, name, intro, photoFileName, photoOriginFileName);
				list.add(vo);
			}
			System.out.println("글목록 결과 list.size="+list.size());
			
			return list;
			
		}finally {
			pool.dbClose(rs, ps, con);
			
		}
	}
	
	public int updateWriter(WriterVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//con
			con=pool.getConnection();
			
			//ps
			String sql="update writer" + 
					" set name=?, intro=?";
			//작가이미지 파일 첨부한 경우
			if(vo.getPhotoFileName()!=null && !vo.getPhotoFileName().isEmpty()) {
				sql+=", photoFileName=?, photoOriginFileName=?";
				
			}
			
			sql+=" where no=?";
				
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getIntro());
			//이미지파일 첨부 됐을 때
			if(vo.getPhotoFileName()!=null && !vo.getPhotoFileName().isEmpty()) {
				ps.setString(3, vo.getPhotoFileName());
				ps.setString(4, vo.getPhotoOriginFileName());
				ps.setInt(5, vo.getNo());
			}else ps.setInt(3, vo.getNo());
			
			
			
			//
			int cnt=ps.executeUpdate();
			System.out.println("작가 정보 수정 결과 cnt="+cnt+", 매개변수 vo="+vo);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public int deleteWr(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=pool.getConnection();
			
			String sql="delete writer where no=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			int cnt=ps.executeUpdate();
			System.out.println("책 정보 삭제 결과 cnt="+cnt+", 매개변수 no="+no);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
}//class























