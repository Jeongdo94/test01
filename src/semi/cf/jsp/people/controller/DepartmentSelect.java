package semi.cf.jsp.people.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.people.model.service.DepartmentService;
import semi.cf.jsp.people.model.vo.Department;

/**
 * Servlet implementation class DepartmentSelect
 */
@WebServlet("/selectOne.de")
public class DepartmentSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
        String dept = request.getParameter("dept");
        
        System.out.println("servlet "+ dept);
		
		ArrayList<Department> list = new ArrayList<Department>();
		
		DepartmentService ds = new DepartmentService();
		
		list = ds.selectOne(dept);
		
		String page = "";
		
		if(list != null) {
			page = "views/5_people/dept.jsp?dept="+dept;
			request.setAttribute("list", list);
			request.setAttribute("de", dept);
			System.out.println(list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
				
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
