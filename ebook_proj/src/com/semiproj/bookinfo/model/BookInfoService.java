package com.semiproj.bookinfo.model;

import java.sql.SQLException;
import java.util.List;

public class BookInfoService {
	private BookInfoDAO bookinfoDao;
	
	public BookInfoService(){
		bookinfoDao=new BookInfoDAO();
	}
	
	public List<BookInfoVO> selectAll(String condition, String keyword) throws SQLException{
		return bookinfoDao.selectAll(condition, keyword);
	}
	
	public BookInfoVO selectByNo(int no) throws SQLException{
		return bookinfoDao.selectByNo(no);
	}
	
	public int insertBook(BookInfoVO vo) throws SQLException{
		return bookinfoDao.insertBook(vo);
	}
	
	public int updateBook(BookInfoVO vo) throws SQLException{
		return bookinfoDao.updateBook(vo);
	}
	
	public int deleteBook(int no) throws SQLException {
		return bookinfoDao.deleteBook(no);
	}
	
	//작가번호로 책조회
	public List<BookInfoVO> selectByWrno(int wrno) throws SQLException {
		return bookinfoDao.selectByWrno(wrno);
	}
	
	public int updateReadCount(int no) throws SQLException{
		return bookinfoDao.updateReadCount(no);
	}
	
	public List<BookInfoVO> selectTop3() throws SQLException{
		return bookinfoDao.selectTop3();
	}
}
