package semi.cf.jsp.boardComment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semi.cf.jsp.boardComment.model.dao.CommentDao;
import semi.cf.jsp.boardComment.model.vo.Comment;

import static semi.cf.jsp.common.JDBCTemplate.*;


public class CommentService {
	private CommentDao cDao = new CommentDao();
	
	/**
	 * 댓글 삽입
	 * @param nco
	 * @return
	 */
	public int insertComment(Comment nco) {
		Connection con = getConnection();
		
		int result = cDao.insertComment(con,nco);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	
	/**
	 * 댓글 가져오기
	 * @param bno
	 * @return
	 */
	public ArrayList<Comment> selectList(int bno) {
		Connection con = getConnection();
		
		ArrayList<Comment> clist = cDao.selectList(con,bno);
	
		close(con);
		
		
		return clist;
	}
	
	
	/**
	 * 게시판 댓글 삭제
	 * @param cno
	 * @return
	 */
	public int commentDelete(int cno) {
		Connection con = getConnection();
		
		int result = cDao.commentDelete(con,cno);
		
		if(result>0) commit(con);
		else rollback(con);
		
		System.out.println("게시판 댓글 삭제 service:"+result);
		return result;
	}

}
