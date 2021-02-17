package com.semiproj.comments.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.semiproj.db.ConnectionPoolMgr;

public class CommentsDAO {
	private ConnectionPoolMgr pool;
	
	public CommentsDAO() {
		pool=new ConnectionPoolMgr();
	}
	
	public List<CommentsVO> selectAllCmt(int bookNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<CommentsVO> list = new ArrayList<CommentsVO>();
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3. ps
			String sql="select * from comments" + 
					" where bookNo=? order by no asc";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookNo);
			
			//4. exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String nickname=rs.getString("nickname");
				Timestamp regdate=rs.getTimestamp("regdate");
				String content=rs.getString("content");
				
				CommentsVO vo = new CommentsVO(no, nickname,regdate, content, bookNo);
				
				list.add(vo);
			}
			System.out.println("글목록 결과 list.size="+list.size()+" , 매개변수 bookNo="+bookNo);
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	public List<CommentsVO> selectCmt(int bookNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<CommentsVO> list = new ArrayList<CommentsVO>();
		try {
			//1,2 con
			con=pool.getConnection();
			
			//3. ps
			String sql="select * from comments" + 
					" where bookNo=? order by no asc";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookNo);
			
			//4. exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String nickname=rs.getString("nickname");
				Timestamp regdate=rs.getTimestamp("regdate");
				String content=rs.getString("content");
				
				CommentsVO vo = new CommentsVO(no, nickname,regdate, content, bookNo);
				
				list.add(vo);
			}
			System.out.println("글목록 결과 list.size="+list.size()+" , 매개변수 bookNo="+bookNo);
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int insertCmt(CommentsVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int cnt=0;
		try {
			con=pool.getConnection();
			
			String sql="insert into comments(no,nickname,content,bookNo)" + 
					" values(comments_seq.nextval,?,?,?)";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getNickname());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getBookNo());
			
			cnt=ps.executeUpdate();
			System.out.println("댓글 작성 결과 : cnt="+cnt+" , 매개변수 vo="+vo);
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public int selectCommentsCnt(int bookNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		int count=0;
		try {
			con=pool.getConnection();
			
			String sql="select count(*) from comments"
					+ " where bookNo=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookNo);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
			System.out.println("코멘트 수 count="+count+", 매개변수 bookNo="+bookNo);
			
			return count;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}
	
	public int deleteCmt(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="delete from comments where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);
			
			int cnt=ps.executeUpdate();
			System.out.println("댓글 삭제 결과 cnt="+cnt+", 매개변수 no="+no);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
		
	}
	public int updateCmt(CommentsVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int cnt=0;
		try {
			con=pool.getConnection();
			
			String sql="update comments" + 
					" set content=? where no=?";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getContent());
			ps.setInt(2, vo.getNo());
			
			cnt=ps.executeUpdate();
			System.out.println("댓글 수정 결과 : cnt="+cnt+" , 매개변수 vo="+vo);
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
}
