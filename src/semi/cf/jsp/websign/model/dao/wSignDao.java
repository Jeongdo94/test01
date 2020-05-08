package semi.cf.jsp.websign.model.dao;

import static semi.cf.jsp.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import semi.cf.jsp.member.model.vo.Member;
import semi.cf.jsp.websign.model.vo.wSign;
import semi.cf.jsp.websign.model.vo.wSign_Psn;

public class wSignDao {
	
	private Properties prop;
	
	public wSignDao() {
		prop = new Properties();
		
		String filePath = wSign.class.getResource("/config/wSign-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<wSign> selectList(Connection con, int currentPage, int limit) {
		// 전달할 객체 선언
		ArrayList<wSign> list = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {			
			pstmt = con.prepareStatement(sql);
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<wSign>();
			
			while(rset.next()) {
				wSign s = new wSign();
				
				s.setwNo(rset.getInt("WNO"));
				s.setwTitle(rset.getString("WTITLE"));
				s.setwCls(rset.getString("WCLS"));
				
				list.add(s);
				
				System.out.println("DAO" + list);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Member> searchNotice(Connection con, String category, String keyword) {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(category) {
		case "이름":
			sql = prop.getProperty("searchName");
			break;
		case "연락처":
			sql = prop.getProperty("searchNumber");
			break;
		case "부서명":
			sql = prop.getProperty("searchDept");
			break;
		}
		try {
	         
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, keyword);
	         
	         rset = pstmt.executeQuery();
	         list = new ArrayList<Member>();
	         
	         while(rset.next()) {
	            Member m = new Member();
	            
	            m.setUserName(rset.getString("USERNAME"));
	            m.setUserId(rset.getString("USERID"));
	            m.setPosit(rset.getString("POSIT"));
	            m.setDept(rset.getString("DEPT"));
	            
	            list.add(m);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
		
		return list;
	}

	public ArrayList<Member> MemberList(Connection con) {
		// 전달할 객체 선언
		ArrayList<Member> list = null; 
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("MemberList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Member>();
			
			// if, while
			while(rset.next()) {
				Member m = new Member();
	            
	            m.setUserName(rset.getString("USERNAME"));
	            m.setUserId(rset.getString("USERID"));
	            m.setPosit(rset.getString("POSIT"));
	            m.setDept(rset.getString("DEPT"));
	            
	            list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int insertSigner(Connection con, wSign_Psn pSigner1, wSign_Psn pSigner2, wSign_Psn pSigner3) {
		System.out.println("Insert Dao 도착");
		// 결과 확인을 위한 변수 result 생성
		int result = 0;
		PreparedStatement pstmt = null;
		
		System.out.println("Insert Dao try 시작");
		try {
				String sql = prop.getProperty("insertSigner");
				
				pstmt = con.prepareStatement(sql);
				
				System.out.println("Insert Dao sql 입력전");
				pstmt.setString(1, pSigner1.getUserId());
				pstmt.setInt(2, pSigner1.getApprOrder());
				pstmt.setString(3, pSigner1.getAppr_Yn());
				
				pstmt.setString(4, pSigner2.getUserId());
				pstmt.setInt(5, pSigner2.getApprOrder());
				pstmt.setString(6, pSigner2.getAppr_Yn());
				
				pstmt.setString(7, pSigner3.getUserId());
				pstmt.setInt(8, pSigner3.getApprOrder());
				pstmt.setString(9, pSigner3.getAppr_Yn());
				
				System.out.println("Insert Dao sql 입력후");
				result = pstmt.executeUpdate();
				
				System.out.println("Insert Dao result" + result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertSigner(Connection con, wSign ws) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		System.out.println(ws.getwCon().getBytes().length);
		try {
				String sql = prop.getProperty("insertCon");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, ws.getwTitle());
				pstmt.setString(2, ws.getwWriter());
				pstmt.setString(3, ws.getwCls());
				pstmt.setDate(4, ws.getwDate());
				pstmt.setString(5, ws.getSigner());
				pstmt.setInt(6, ws.getsStep());
				pstmt.setString(7, ws.getwCon());

				
				result = pstmt.executeUpdate();
				
				System.out.println(result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public wSign selectOne(Connection con, int wno) {
		wSign result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	// Select의 결과를 담은 객체
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, wno);
			rset =pstmt.executeQuery();
			
			if(rset.next()) {
				result = new wSign();
				
				result.setwNo(wno);
				result.setwDate(rset.getDate("WDATE"));
				result.setwWriter(rset.getString("WWRITE"));
				result.setwTitle(rset.getString("WTITLE"));
				result.setSigner(rset.getString("SIGNER"));
				result.setwCls(rset.getString("WCLS"));
				result.setwCon(rset.getString("WCON"));
				result.setsStep(rset.getInt("SSTEP"));
			}
			System.out.println("notice 확인 : " + result);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public ArrayList<wSign> selectList2(Connection con, String wno) {
		// 전달할 객체 선언
				ArrayList<wSign> list = null; 
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectList2");
				
				try {
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, wno);
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<wSign>();
					
					while(rset.next()) {
						wSign ws = new wSign();
						
						ws.setwNo(rset.getInt("WNO"));
						ws.setwTitle(rset.getString("WTITLE"));
						ws.setwWriter(rset.getString("WWRITE"));
						ws.setwCls(rset.getString("WCLS"));
						ws.setwDate(rset.getDate("WDATE"));
						ws.setSigner(rset.getString("SIGNER"));
						ws.setsStep(rset.getInt("SSTEP"));
						ws.setwCon(rset.getString("wCon"));
						
						list.add(ws);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				return list;
	}

	public ArrayList<wSign_Psn> selectList3(Connection con) {
		// 전달할 객체 선언
		ArrayList<wSign_Psn> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList3");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<wSign_Psn>();
			// if, while
			while(rset.next()) {
				wSign_Psn wp = new wSign_Psn();
				
				wp.setUserId(rset.getString("USERID"));
				wp.setApprOrder(rset.getInt("APPRODER"));
				
				list.add(wp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int updateYn(Connection con, int wno, String id) {
		int result =0;
		int stepNo = 0;
		ResultSet rset = null;
	
		wSign_Psn wp = null;
		
		PreparedStatement pstmt = null;
		
		String searchSql = prop.getProperty("searchSql");;
		
		String psnUpdateSql = prop.getProperty("updateYn");
		
		String docStepUpdateSql = prop.getProperty("docStepUpdateSql");
		
		try {
			pstmt = con.prepareStatement(searchSql);
			pstmt.setInt(1, wno);
			pstmt.setString(2, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				wp = new wSign_Psn();
				wp.setApprOrder(rset.getInt("APPRODER"));
			}
			
			for(int i = 1; i<=wp.getApprOrder(); i++) {
				pstmt = con.prepareStatement(psnUpdateSql);
				pstmt.setInt(1, wno);
				pstmt.setInt(2, i);
				result += pstmt.executeUpdate();
			}
			
			if(wp.getApprOrder() == 1) stepNo = 3;
			else if(wp.getApprOrder() == 2) stepNo = 4;
			else if(wp.getApprOrder() == 3) stepNo = 5;
			
			pstmt = con.prepareStatement(docStepUpdateSql);
			pstmt.setInt(1, stepNo);
			pstmt.setInt(2, wno);
			result += pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<wSign_Psn> selectOne2(Connection con, int wno) {
		ArrayList<wSign_Psn> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	// Select의 결과를 담은 객체
		
		String sql = prop.getProperty("selectOne2");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, wno);
			rset =pstmt.executeQuery();
			
			list = new ArrayList<wSign_Psn>();
			
			while(rset.next()) {
				wSign_Psn wp = new wSign_Psn();
				
				wp.setApprOrder(rset.getInt("APPRODER"));
				wp.setUserId(rset.getString("USERID"));
				wp.setAppr_Yn(rset.getString("APPR_YN"));
				wp.setSign(rset.getString("Sign"));
				
				
				
				list.add(wp);
			}
			System.out.println("notice 확인 : " + list);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}

	public int updateYn2(Connection con, int wno, String id) {
		int result =0;
		
		PreparedStatement pstmt = null;
		
		String step6 = prop.getProperty("step6");
		
		try {
			pstmt = con.prepareStatement(step6);
			pstmt.setInt(1, wno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
