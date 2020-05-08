package semi.cf.jsp.login.model.dao;

import static semi.cf.jsp.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import semi.cf.jsp.member.model.exception.MemberException;

import semi.cf.jsp.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		
		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectMember(Connection con, Member m) throws MemberException {
		Member result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null;
		ResultSet rset = null;	// Select의 결과를 담은 객체
		
		try {
			String sql = prop.getProperty("selectMember");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			// if while
			if(rset.next()) {
				result = new Member();
				
				result.setUserId(rset.getString("USERID"));
				result.setUserPwd(rset.getString("USERPWD"));
				result.setUserName(rset.getString("USERNAME"));
				result.setUserNo(rset.getString("USERNO"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPosit(rset.getString("PHONE"));
				result.setDept(rset.getString("DEPT"));
				result.setPosit(rset.getString("POSIT"));
				result.setHire_date(rset.getDate("HIRE_DATE"));
				result.setmInfo(rset.getString("MINFO"));
				result.setSign(rset.getString("SIGN"));
			}
		}catch(Exception e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("DAO member : "+result);
		return result;
	}
	
	/**
	 * 비번 비교하기
	 * @param con
	 * @param m
	 * @return
	 */
	public int findPw(Connection con, Member m) {
		System.out.println("DAO 오나요?");
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("findPw");

		try {
			pstmt = con.prepareStatement(sql);
			
			System.out.println("나는 DAO아이디 ! " + m.getUserId());
			System.out.println("나는 DAO주민번호 ! " + m.getUserNo());
			//널
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserNo());

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			System.out.println("DAO 알셋" + result);

		}catch(SQLException e) {
			e.printStackTrace();			
		}finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int updatePwd(Connection con, Member m) {
		System.out.println("없뎃DAO에 오나요?");
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("updatePwd");
			
			pstmt = con.prepareStatement(sql);
			
			System.out.println("업뎃한 비번!" + m.getUserPwd());
			pstmt.setString(1,m.getUserPwd());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
