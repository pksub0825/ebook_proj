package com.semiproj.eventboard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.semiproj.db.ConnectionPoolMgr;


public class eventBoardDAO {
	private ConnectionPoolMgr pool;

	public eventBoardDAO() {
		pool=new ConnectionPoolMgr();
	}

	public int insertBoard(eventBoardVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//1,2 con
			con=pool.getConnection();

			//3. ps
			String sql="insert into eventboard(no,title,content,imgfilename,imgoriginfilename)" + 
					" values(eventboard_seq.nextval,?,?,?,?)";
			ps=con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setString(3, vo.getImgFileName());
			ps.setString(4, vo.getImgOriginFileName());

			//4. exec
			int cnt=ps.executeUpdate();
			System.out.println("글쓰기 결과 cnt="+cnt+", 매개변수 vo="+vo);

			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}

	public List<eventBoardVO> selectAll(String condition, String keyword) throws SQLException{

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		List<eventBoardVO> list=new ArrayList<eventBoardVO>();
		try {
			//1,2 con
			con=pool.getConnection();

			//3. ps
			String sql="select * from eventboard ";
			if(keyword!=null && !keyword.isEmpty()) { //검색
				sql += " where "+ condition +" like '%' || ? || '%'";
			}
			sql += " order by no desc";
			ps=con.prepareStatement(sql);
			
			if(keyword!=null && !keyword.isEmpty()) { //검색
				ps.setString(1, keyword);
			}

			//4. exec
			rs=ps.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("no");
				String title=rs.getString("title");
				Timestamp regdate=rs.getTimestamp("regdate");
				String content=rs.getString("content");
				String imgFileName=rs.getString("imgFileName");
				String imgOriginFileName=rs.getString("imgOriginFileName");
				int downCount=rs.getInt("downCount");

				eventBoardVO vo = new eventBoardVO(no, title, regdate, content, imgFileName, imgOriginFileName, downCount);
				list.add(vo);
			}
			System.out.println("글목록 결과 list.size="+list.size()
				+", 매개변수 condition="+condition+", keyword="+keyword);
		
			return list;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}

	public eventBoardVO selectByNo(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		eventBoardVO vo = new eventBoardVO();
		try {
			//1,2
			con=pool.getConnection();

			//3
			String sql="select * from eventboard where no=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);

			//4
			rs=ps.executeQuery();
			if(rs.next()) {
				vo.setNo(no);
				vo.setTitle(rs.getString("title"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setContent(rs.getString("content"));
				vo.setImgFileName(rs.getString("imgFileName"));
				vo.setImgOriginFileName(rs.getString("imgOriginFileName"));
				vo.setdownCount(rs.getInt("downCount"));
			}
			System.out.println("글 상세보기 결과 vo="+vo+", 매개변수 no="+no);

			return vo;
		}finally {
			pool.dbClose(rs, ps, con);
		}
	}

	public int updateBoard(eventBoardVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//1,2
			con=pool.getConnection();

			//3
			String sql="update eventboard" + 
					" set title=?,content=? ";
			//새로 파일 첨부한 경우만 파일정보 update
			if(vo.getImgFileName()!=null && !vo.getImgFileName().isEmpty()) {
				sql+=", imgfilename=?, imgoriginfilename=? ";
			}
					
			sql+=" where no=?";
			
			ps=con.prepareStatement(sql);

			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			
			if(vo.getImgFileName()!=null && !vo.getImgFileName().isEmpty()) {
				ps.setString(3, vo.getImgFileName());
				ps.setString(4, vo.getImgOriginFileName());
				ps.setInt(5, vo.getNo());
			}else {
				//첨부파일이 없으면 빠지기
				ps.setInt(3, vo.getNo());
			}

			//4
			int cnt=ps.executeUpdate();
			System.out.println("글수정 결과, cnt="+cnt+", 매개변수 vo="+vo);

			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}

	public int deleteBoard(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//1,2
			con=pool.getConnection();

			//3
			String sql="delete from eventboard where no=? ";
			ps=con.prepareStatement(sql);
			ps.setInt(1, no);

			//4
			int cnt=ps.executeUpdate();
			System.out.println("글 삭제 결과, cnt="+cnt+", 매개변수 no="+no);

			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}

	public int updateReadCount(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			//1,2
			con=pool.getConnection();

			//3
			String sql="update eventboard" + 
					" set readcount=readcount+1" + 
					" where no=?";
			ps=con.prepareStatement(sql);

			ps.setInt(1, no);

			//4
			int cnt=ps.executeUpdate();
			System.out.println("조회수 증가 결과, cnt="+cnt+", 매개변수 no="+no);

			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public int updatedownCount(int no) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="update eventboard" + 
					" set downCount=downCount+1" + 
					 " where no=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			int cnt=ps.executeUpdate();
			System.out.println("다운로드수 증가 결과, cnt="+ cnt+
					", 매개변수 no="+no);
			
			return cnt;
		}finally {
			pool.dbClose(ps, con);
		}
	}
	
	public List<eventBoardVO> listSideMenu() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<eventBoardVO> list=new ArrayList<eventBoardVO>();
		try {
			con=pool.getConnection();
			
			String sql="select no, title" + 
					" from (select no, title from eventboard" + 
					" order by no desc)" + 
					" where rownum<=3";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				eventBoardVO vo=new eventBoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				
				list.add(vo);
			}
		}finally {
			pool.dbClose(rs, ps, con);
		}
		
		return list;
	}
}
