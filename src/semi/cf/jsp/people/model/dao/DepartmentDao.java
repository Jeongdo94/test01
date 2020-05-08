package semi.cf.jsp.people.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import semi.cf.jsp.people.model.vo.Department;
import static semi.cf.jsp.common.JDBCTemplate.close;
import static semi.cf.jsp.common.JDBCTemplate.*;

public class DepartmentDao {
	
	
	private Properties prop;
	
	
	public DepartmentDao() {
       
		prop = new Properties();
		
		String filePath = Department.class.getResource("/config/department-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<Department> selectList(Connection con) {
		
		ArrayList<Department> list = null; // 전달할 객체 선언
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Department>();
			
			// if, while
			while(rset.next()) {
				Department d = new Department();
				
				d.setUsername(rset.getString("username"));
				d.setUserid(rset.getString("userid"));
				d.setEmail(rset.getString("email"));
				d.setPhone(rset.getString("phone"));
				d.setDept(rset.getString("dept"));
				d.setPosit(rset.getString("posit"));
				
				
				list.add(d);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


	public ArrayList<Department> selectOne(Connection con, String dept) {
		
		ArrayList<Department> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectA");
		
//		switch(dept) {
//		case "경영지원본부" : 
//			sql = prop.getProperty("selectA");
//			break;
//		case "영업추진본부" :
//			sql = prop.getProperty("selectB");
//			break;
//		case "생산 본부" :
//			sql = prop.getProperty("selectC");
//			break;
//		case "해외생산본부" :
//			sql = prop.getProperty("selectD");
//			break;	
//		}
					
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dept);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Department>();
			
			while(rset.next()) {
				Department d = new Department();
				
				d.setUsername(rset.getString("username"));
				d.setUserid(rset.getString("userid"));
				d.setEmail(rset.getString("email"));
				d.setPhone(rset.getString("phone"));
				d.setDept(rset.getString("dept"));
				d.setPosit(rset.getString("posit"));
				
				list.add(d);
			}
			System.out.println(list + "dao");
			System.out.println(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	
	}
	

}
