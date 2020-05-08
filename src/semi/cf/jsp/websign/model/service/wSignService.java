package semi.cf.jsp.websign.model.service;

import static semi.cf.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import semi.cf.jsp.member.model.vo.Member;
import semi.cf.jsp.websign.model.dao.wSignDao;
import semi.cf.jsp.websign.model.vo.wSign;
import semi.cf.jsp.websign.model.vo.wSign_Psn;

public class wSignService {
	
	private wSignDao wDao = new wSignDao();

	/**
	 * 전자결재 양식 리스트
	 * @param limit 
	 * @param currentPage 
	 * @return
	 */
	public ArrayList<wSign> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<wSign> list = wDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	/**
	 * 전자결재 양식 리스트 페이징
	 * @return
	 */
	public int getListCount() {
		Connection con = getConnection();
		int listCount = wDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	/**
	 * 결재자 검색
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<Member> searchMember(String category, String keyword) {
		Connection con = getConnection();
		
		ArrayList<Member> list = null;
		
		list = wDao.searchNotice(con,category,keyword);
		
		if(category.length() > 0) {
			list = wDao.searchNotice(con,category,keyword);
			System.out.println("Service실행 (검색 : category) : "+category);
		} else {
			list = wDao.MemberList(con);
			System.out.println("Service실행 (MeberList)");
		}
		
		return list;
	}

	/**
	 * 결재자 추가
	 * @param signer
	 * @param pSinger1
	 * @param pSinger2
	 * @param pSinger3
	 */
	public int insertSigner(wSign_Psn pSigner1, wSign_Psn pSigner2, wSign_Psn pSigner3) {
		Connection con = getConnection();
		
		int iSigner= wDao.insertSigner(con, pSigner1, pSigner2, pSigner3);
		
		if(iSigner > 0 ) commit(con);
		else rollback(con);
		
		return iSigner;
	}

	public int insertNotice(wSign ws) {
		Connection con = getConnection();
		
		int wScon = wDao.insertSigner(con, ws);
		
		if(wScon > 0 ) commit(con);
		else rollback(con);
		
		return wScon;
	}

	public wSign selectOne(int wno) {
		Connection con = getConnection();
		
		wSign ws = wDao.selectOne(con, wno);
		
		close(con);
		
		return ws;
	}
	
	
	public ArrayList<wSign> selectList2(String wno) {
		Connection con = getConnection();
		
		ArrayList<wSign> list = wDao.selectList2(con, wno);
		
		close(con);
		
		return list;
	}

	public ArrayList<wSign_Psn> selectList3() {
		Connection con = getConnection();
		
		ArrayList<wSign_Psn> list = wDao.selectList3(con);
		
		close(con);
		
		return list;
	}

	public int updateYn(int wno, String id) {
		  Connection con = getConnection();
		  
		  int result = wDao.updateYn(con, wno, id);
		  
		  
		  if(result > 0)commit(con);
		  else rollback(con);
		  close(con);
		  
		  
		  return result;
	}

	public ArrayList<wSign_Psn> selectOne2(int wno) {
		Connection con = getConnection();
		
		ArrayList<wSign_Psn> wp = wDao.selectOne2(con, wno);
		
		close(con);
		
		return wp;
	}

	public int updateYn2(int wno, String id) {
		  Connection con = getConnection();
		  
		  int result = wDao.updateYn2(con, wno, id);
		  
		  
		  if(result > 0)commit(con);
		  else rollback(con);
		  close(con);
		  
		  
		  return result;
	}
}
