package com.semiproj.eventboard.model;

import java.sql.SQLException;
import java.util.List;

public class eventBoardService {
	private eventBoardDAO dao;
	
	public eventBoardService() {
		dao=new eventBoardDAO();
	}
	
	public int insertBoard(eventBoardVO vo) throws SQLException {
		return dao.insertBoard(vo);
	}

	public List<eventBoardVO> selectAll(String condition, String keyword) throws SQLException{
		return dao.selectAll(condition, keyword);
	}
	
	public eventBoardVO selectByNo(int no) throws SQLException {
		return dao.selectByNo(no);
	}
	
	public int updateBoard(eventBoardVO vo) throws SQLException {
		return dao.updateBoard(vo);
	}
	
	public int deleteBoard(int no) throws SQLException {
		return dao.deleteBoard(no);
	}

	public int updateReadCount(int no) throws SQLException {
		return dao.updateReadCount(no);
	}
	
	public int updateDownCount(int no) throws SQLException {
		return dao.updatedownCount(no);
	}
	
	public List<eventBoardVO> listSideMenu() throws SQLException{
		return dao.listSideMenu();
	}
	
}
