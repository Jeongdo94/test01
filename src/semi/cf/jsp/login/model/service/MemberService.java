package semi.cf.jsp.login.model.service;


import java.sql.Connection;

import static semi.cf.jsp.common.JDBCTemplate.*;
import semi.cf.jsp.login.model.dao.MemberDao;
import semi.cf.jsp.member.model.exception.MemberException;
import semi.cf.jsp.member.model.vo.Member;

public class MemberService {
	
	private Connection con;
	private MemberDao mDao = new MemberDao();
	
	public Member selectMember(Member m) throws MemberException {
		con = getConnection();
		
		Member result = mDao.selectMember(con,m);
		
		close(con);
		
		if(result == null) {
			throw new MemberException("회원 아이디나 비밀번호가 올바르지 않습니다.");
		}
		return result;
	}
	
	/**
	 * 비밀번호 맞는지 비교
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int findPw(Member m) {
		System.out.println("서비스 오나요?");
		Connection con = getConnection();
		
		int result = mDao.findPw(con, m);
		
		close(con);
		
		System.out.println("서비스의 값이 오나요?" + result);
		
		return result;
	}

	/**
	 * 비밀번호 재설정
	 * @param userPwd2
	 */
	public int updatePwd(Member m) {
		System.out.println("서비스에 오나요?");
		
		con = getConnection();
		
		int result = mDao.updatePwd(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
		
	}

}
