package com.semiproj.comments.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentsService {
	private CommentsDAO cDao;
	
	public CommentsService() {
		cDao=new CommentsDAO();
	}
	
	public List<CommentsVO> selectAllCmt(int bookNo) throws SQLException {
		return cDao.selectAllCmt(bookNo);
	}
	
	public int insertCmt(CommentsVO vo) throws SQLException {
		return cDao.insertCmt(vo);
	}
	
	public int selectCommentsCnt(int bookNo) throws SQLException {
		return cDao.selectCommentsCnt(bookNo);
	}
	
	public int deleteCmt(int no) throws SQLException {
		return cDao.deleteCmt(no);
	}
	
	public int updateCmt(CommentsVO vo) throws SQLException {
		return cDao.updateCmt(vo);
	}
}


