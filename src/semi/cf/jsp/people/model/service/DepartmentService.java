package semi.cf.jsp.people.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import semi.cf.jsp.people.model.dao.DepartmentDao;
import semi.cf.jsp.people.model.vo.Department;
import static semi.cf.jsp.common.JDBCTemplate.*;

public class DepartmentService {
	
	DepartmentDao dDao = new DepartmentDao();

	public ArrayList<Department> selectOne(String dept) {
		
        Connection con = getConnection();
		
		ArrayList<Department> list = dDao.selectOne(con,dept);
		
		
		
        close(con);
		
		return list;
		

	}	

}
