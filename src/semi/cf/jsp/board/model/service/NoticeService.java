package semi.cf.jsp.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semi.cf.jsp.board.model.dao.NoticeDao;
import semi.cf.jsp.board.model.vo.Notice;

import static semi.cf.jsp.common.JDBCTemplate.*;

public class NoticeService {

	private static NoticeDao nDao = new NoticeDao();
	
	/**
	 * 공지사항 목록
	 * @return
	 */
	public ArrayList<Notice> selectList(int currentPage, int limit, String ntype) {
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.selectList(con,currentPage,limit,ntype);
		
		close(con);
		
		return list;
		
	}

	/**
	 * 공지사항 목록 페이징 
	 * @return
	 */
	public int getListCount(String ntype) {
		Connection con = getConnection();
		int listCount =nDao.getListCount(con, ntype);
		System.out.println("ntype:"+ntype);
		close (con);
		
		return listCount;
	}

	/**
	 * 게시판 세부내용
	 * @param bno
	 * @return
	 */
	public Notice NoticeDetail(int bno) {
		Connection con = getConnection();
		
		Notice n = nDao.noticeDetail(con,bno);
		
		if(n != null) {
			int result = nDao.ReadCount(con,bno);
			
			if(result>0) commit(con);
			else rollback(con);
		}
		
		close(con);
		
		return n;
	}

	/**게시판 글작성 추가
	 * @param n
	 * @return
	 */
	public int writerNotice(Notice n) {
		Connection con = getConnection();
		int result = nDao.writerNotice(con,n);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	/**
	 * 게시판 업데이트 view불러오기
	 * @param bno
	 * @return
	 */
	public Notice updateView(int bno) {
		Connection con = getConnection();

		Notice n = nDao.updateView(con,bno);
		
		close(con);
		
		System.out.println("업데이트 서비스 : "+n);
		return n;
	}

	/**
	 * 게시판 업데이트 (수정)
	 * @param n
	 * @return
	 */
	public int updateNotice(Notice n) {
		Connection con = getConnection();
		
		int result = nDao.update(con,n);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;

	}

	/**
	 * 게시판 글삭제
	 * @param bno
	 * @return
	 */
	public int deleteNotice(int bno) {
		Connection con =getConnection();
		
		int result = nDao.deleteNotice(con,bno);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	/**
	 * 게시판 검색
	 * @param category
	 * @param content
	 * @return
	 */
	public static ArrayList<Notice> searchNotice(int currentPage, int limit, String ntype, String category, String content) {
		Connection con = getConnection();
		
		ArrayList<Notice> list = null;
		System.out.println("검색service");
		if(content.length()>0) {
			list = nDao.searchNotice(con,currentPage,limit,ntype,category,content);
		}else {
			
		}

		return list;
	}

	/**
	 * 게시판 검색 Count
	 * @param ntype
	 * @param category
	 * @param content
	 * @return
	 */
	public int searchListCount(String ntype, String category, String content) {
	   Connection con = getConnection();
	   
	   int searchListCount = nDao.getSearchListCount(con,ntype,category,content);
	   
	   
		return searchListCount;
	}


	/**
	 * 게시판 글작성 후 추가
	 * @param n
	 * @return
	 */
//	public int insertNotice(Notice n) {
//		Connection con = getConnection();
//		
//		int result = nDao.insertNotice(con,n);
//		
//		
//		
//		return 0;
//	}

}
