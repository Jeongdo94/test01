package semi.cf.jsp.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import semi.cf.jsp.board.model.vo.Notice;
import semi.cf.jsp.board.model.vo.Page;

import static semi.cf.jsp.common.JDBCTemplate.*;
import static semi.cf.jsp.common.JDBCTemplate.close;

public class NoticeDao {
	
	private Properties prop = new Properties();
	public NoticeDao() {
		
		String filePath = Notice.class.getResource("/config/notice.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시판 목록 불러오기
	 * @param con
	 * @return
	 */
	public ArrayList<Notice> selectList(Connection con, int currentPage, int limit , String ntype) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage-1)*limit +1; //1 11 21 31 ...
			int endRow = startRow + limit -1;
			String noticeType ="";
			
			switch(ntype) {
			case "a" : noticeType ="공지사항" ; break;
			case "b" : noticeType ="인사게시판" ; break;
			case "c" : noticeType ="일반게시판" ; break;
			case "d" : noticeType ="경조사게시판" ; break;
			}
			
			pstmt.setString(1, noticeType);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
//				n.setBno(rset.getInt("RNUM"));
				n.setBno(rset.getInt("BNO"));
				n.setBwriter(rset.getString("BWRITE"));
				n.setBcls(rset.getString("BCLS"));
				n.setBtitle(rset.getString("BTITLE"));
				n.setBdate(rset.getDate("BDATE"));
				n.setBcount(rset.getInt("BCOUNT"));
				
				list.add(n);
			}
			
			System.out.println("//" + list);

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * 게시판 목록 listCount 게시글수
	 * @param con
	 * @return
	 */
	public int getListCount(Connection con, String ntype) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		String noticeType = "";
		
		try {
			
			switch(ntype) {
			case "a" : noticeType ="공지사항" ; break;
			case "b" : noticeType ="인사게시판" ; break;
			case "c" : noticeType ="일반게시판" ; break;
			case "d" : noticeType ="경조사게시판" ; break;
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, noticeType);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {			
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	/**
	 * 게시판 세부내용
	 * @param con
	 * @param bno
	 * @return
	 */
	public Notice noticeDetail(Connection con, int bno) {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeDetail");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				
				n.setBno(bno);
				n.setBtype(rset.getString("BTYPE"));
				n.setBtitle(rset.getString("BTITLE"));
				n.setBcon(rset.getString("BCON"));
				n.setBdate(rset.getDate("BDATE"));
				n.setBcount(rset.getInt("BCOUNT"));
				n.setBwriter(rset.getString("BWRITE"));
				n.setBcls(rset.getString("BCLS"));
				n.setBoardfile(rset.getString("BFILE"));				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("n="+n);
		return n;
		
	}

	/**
	 * 조회수
	 * @param con
	 * @param bno
	 * @return
	 */
	public int ReadCount(Connection con, int bno) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("readCount");
		
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 게시판 글작성
	 * @param con
	 * @param n
	 * @return
	 */
	public int writerNotice(Connection con, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("writerNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getBwriter());
			pstmt.setString(2, n.getBcls());
			pstmt.setString(3, n.getBtitle());
			pstmt.setString(4, n.getBcon());
			pstmt.setString(5, n.getBtype());
			pstmt.setString(6, n.getBoardfile());
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 게시판 업데이트 불러오기
	 * @param con
	 * @param bno
	 * @return
	 */
	public Notice updateView(Connection con, int bno) {
		Notice n =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateSelect");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				n = new Notice();
				
				n.setBno(bno);
				n.setBtype(rset.getString("BTYPE"));
				n.setBtitle(rset.getString("BTITLE"));
				n.setBcon(rset.getString("BCON"));
				n.setBdate(rset.getDate("BDATE"));
				n.setBcount(rset.getInt("BCOUNT"));
				n.setBwriter(rset.getString("BWRITE"));
				n.setBcls(rset.getString("BCLS"));
				n.setBoardfile(rset.getString("BFILE"));
				
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("업데이트 값 불러오기 dao:"+ n);
		return n;
	}

	/**
	 * 게시판 업데이트 
	 * @param con
	 * @param n
	 * @return
	 */
	public int update(Connection con, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, n.getBcls());
			pstmt.setString(2, n.getBtitle());
			pstmt.setString(3, n.getBcon());
			pstmt.setString(4, n.getBoardfile());
			pstmt.setInt(5, n.getBno());
			
			result = pstmt.executeUpdate();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 게시판 글 삭제
	 * @param con
	 * @param bno
	 * @return
	 */
	public int deleteNotice(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,bno);
			
			result = pstmt.executeUpdate();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> searchNotice(Connection con, int currentPage, int limit, String ntype, String category, String content) {
		ArrayList<Notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		
		try {
			System.out.println(category);
			switch(category) {
			case "bwrite" : 
				sql = prop.getProperty("searchWriter"); break;
			case "btitle" :
				sql = prop.getProperty("searchTitle"); break;
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()) {
				Notice n = new Notice();
				
				n.setBno(rset.getInt("BNO"));
				n.setBwriter(rset.getString("BWRITE"));
				n.setBcls(rset.getString("BCLS"));
				n.setBtitle(rset.getString("BTITLE"));
				n.setBdate(rset.getDate("BDATE"));
				n.setBcount(rset.getInt("BCOUNT"));
				n.setBoardfile(rset.getString("BFILE"));
				
				list.add(n);
				System.out.println("검색 Dao :"+list);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * 게시판 검색 listCount
	 * @param ntype
	 * @param category
	 * @param content
	 * @return
	 */
	public int getSearchListCount(Connection con, String ntype, String category, String content) {
		PreparedStatement pstmt = null;
		String noticeType="";
		ResultSet rset = null;
		int searchListCount = 0;
		String sql =null;

		try {
			switch(ntype) {
			case "a" : noticeType ="공지사항" ; break;
			case "b" : noticeType ="인사게시판" ; break;
			case "c" : noticeType ="일반게시판" ; break;
			case "d" : noticeType ="경조사게시판" ; break;
			}
			if (category.equals("bwrite")){
				  sql = prop.getProperty("SlistCountW");					
				}
			if(category.equals("btitle")) {
			  sql = prop.getProperty("SlistCountT");
			
			}
			
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			

			
			//pstmt.setString(1, category.trim()); //에러남 디비 컬럼명을 넣어주면 '___' 로 들어가서 안됨!!!!
			pstmt.setString(1, content.trim());
			pstmt.setString(2, noticeType.trim());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {			
				searchListCount = rset.getInt(1);
//				searchListCount = 1;
			}
			
			System.out.println("게시판 검색 :"+rset.getInt(1));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return searchListCount;
	}

	
	/**
	 * 게시글 내용작성 후 추가
	 * @param con
	 * @param n
	 * @return
	 */
//	public int insertNotice(Connection con, Notice n) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		
//		String sql = prop.getProperty("insertNotice");
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(1, n.get);
//			pstmt.setString(2, n.getBcls());
//			pstmt.setString(3, n.getBtitle());
//			pstmt.setString(4, n.getBcon());
//			pstmt.setString(5, n.getBtype());
//			pstmt.setString(6, n.getBoardfile());
//			
//			
//			
//			result = 
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

}
