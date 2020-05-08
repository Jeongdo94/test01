package semi.cf.jsp.boardComment.model.dao;

import static semi.cf.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import semi.cf.jsp.boardComment.model.vo.Comment;

public class CommentDao {
	private Properties prop = new Properties();
	
	public CommentDao() {
		String filePath = CommentDao.class
						  .getResource("/config/comment-query.properties")
						  .getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시판 댓글 삽입
	 * @param con
	 * @param nco
	 * @return
	 */
	public int insertComment(Connection con, Comment nco) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		System.out.println("댓글 dao: "+ nco);
		String sql =prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,nco.getCbno());
			pstmt.setString(2, nco.getCbtype());
			pstmt.setString(3, nco.getCwriter());
			pstmt.setString(4, nco.getCcon());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 게시판 댓글 불러오기 list
	 * @param con
	 * @param bno
	 * @return
	 */
	public ArrayList<Comment> selectList(Connection con, int bno) {
		ArrayList<Comment> clist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			clist = new ArrayList<Comment>();
			
			while(rset.next()) {
				Comment co = new Comment();
				
				co.setCno(rset.getInt("CNO"));
				co.setCbno(rset.getInt("CBNO"));
				co.setCbtype(rset.getString("CBTYPE"));
				co.setCwriter(rset.getString("CWRITE"));
				co.setCcon(rset.getString("CCON"));
				co.setCdate(rset.getString("CDATE"));
				
				clist.add(co);
				
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return clist;
	}
	
	/**
	 * 게시판 댓글 삭제
	 * @param con
	 * @param cno
	 * @return
	 */
	public int commentDelete(Connection con, int cno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("commentDelete");
		System.out.println("게시판 댓글 삭제 dao 댓글번호:"+cno);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("게시판 댓글 삭제 dao result:"+result);
		return result;
	}


	

}
