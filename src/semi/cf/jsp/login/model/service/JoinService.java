package semi.cf.jsp.login.model.service;

import semi.cf.jsp.login.model.dao.JoinDao;
import semi.cf.jsp.login.model.exception.JoinException;
import semi.cf.jsp.login.model.vo.Join;

import static semi.cf.jsp.common.JDBCTemplate.*;

import java.sql.Connection;

public class JoinService {
	
	private Connection con;
	private JoinDao jDao = new JoinDao();
	
	
	public int insertJoin(Join j) throws JoinException {
		con = getConnection();
		int result = jDao.insertMember(con,j);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	
	public Join selectOne(int userid) {
       Connection con = getConnection();
		
		Join j = jDao.selectOne(con,userid);
		
		//게시글 상세보기를 통해 1회 조회할때 
		//두가지 기능이 실행이되어야한다.
		// 1. nno에 해당하는 게시글 내용을 가져오기.(Select)
		// 2. 게시글 내용이 성공적으로 불러와 졌다면.(UPDATE) 조회수가 1 증가해야한다.
		
		if(j != null) {
			
			commit(con);
			
		}else rollback(con);
		
		close(con);
		
		System.out.println("서비스 " +j);
		return j;
	}


	public int updateJoin(Join j) throws JoinException {
        Connection con = getConnection();
		
		int result = jDao.updateJoin(con,j);
		
		if(result > 0 )commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int deleteMember(String userid) throws JoinException {
		con = getConnection();
		int result = jDao.deleteMember(con,userid);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	
		
	}

	
	
		
	}



