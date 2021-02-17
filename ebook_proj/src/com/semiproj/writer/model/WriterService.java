package com.semiproj.writer.model;

import java.sql.SQLException;
import java.util.List;

public class WriterService {
	private WriterDAO writerDao;
	
	public WriterService() {
		writerDao=new WriterDAO();
	}
	
	public int insertWriter(WriterVO vo) throws SQLException {
		return writerDao.insertWriter(vo);
	}
	
	public List<WriterVO> selectByName(String name) throws SQLException {
		return writerDao.selectByName(name);
	}

	public WriterVO selectByNo(int no) throws SQLException {
		return writerDao.selectByNo(no);
	}
	
	public List<WriterVO> selectAll() throws SQLException{
		return writerDao.selectAll();
	}
	
	public int updateWriter(WriterVO vo) throws SQLException{
		return writerDao.updateWriter(vo);
	}
	
	public int deleteWr(int no) throws SQLException {
		return writerDao.deleteWr(no); 
	}

}
