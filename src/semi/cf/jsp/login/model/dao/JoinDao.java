package semi.cf.jsp.login.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import semi.cf.jsp.login.model.exception.JoinException;
import semi.cf.jsp.login.model.vo.Join;
import static semi.cf.jsp.common.JDBCTemplate.close;

public class JoinDao {
	
	
	private Properties prop;
	
	public JoinDao() {
		
		prop = new Properties();
		
		String filePath = JoinDao.class.getResource("/config/join-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	public int insertMember(Connection con, Join j) throws JoinException{
        
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("insertMember");
			
			pstmt = con.prepareStatement(sql); 
			
			pstmt.setInt(1, j.getUserid());
			pstmt.setInt(2, j.getUserpwd());
			pstmt.setString(3, j.getUsername());
			pstmt.setString(4, j.getUserno());
			pstmt.setString(5, j.getEmail());
			pstmt.setString(6, j.getPhone());
			pstmt.setString(7, j.getDept());
			pstmt.setString(8, j.getPosit());
			pstmt.setDate(9, j.getHire_date());
			pstmt.setString(10, j.getEnt_yn());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw new JoinException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}


	public Join selectOne(Connection con, int userid) {
		   Join j  = null;
		   PreparedStatement pstmt = null;
		   ResultSet rset = null;
		   String sql = prop.getProperty("selectMember");
		   try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, userid);
			
			
			// CRUD == executeUpdate();
			// SELECT == executeQuery();
			rset = pstmt.executeQuery();
						
			// if, while
			if(rset.next()) {
				j = new Join();
				
				j.setUserid(rset.getInt("userid"));
				j.setUserpwd(rset.getInt("userpwd"));
				j.setUsername(rset.getString("username"));
				j.setUserno(rset.getString("userno"));
				j.setEmail(rset.getString("email"));
				j.setPhone(rset.getString("phone"));
				j.setDept(rset.getString("dept"));
				j.setPosit(rset.getString("posit"));
				j.setHire_date(rset.getDate("hire_date"));
				j.setEnt_yn(rset.getString("ent_yn"));
				

			}

			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return j;
	}


	public int updateJoin(Connection con, Join j) throws JoinException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, j.getUserid());
			pstmt.setInt(2, j.getUserpwd());
			pstmt.setString(3, j.getUsername());
			pstmt.setString(4, j.getUserno());
			pstmt.setString(5, j.getEmail());
			pstmt.setString(6, j.getPhone());
			pstmt.setString(7, j.getDept());
			pstmt.setString(8, j.getPosit());
			pstmt.setDate(9, j.getHire_date());
			pstmt.setString(10, j.getEnt_yn());
			pstmt.setInt(11, j.getUserid());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteMember(Connection con, String userid) throws JoinException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("deleteMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw new JoinException(e.getMessage());
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	
	}





