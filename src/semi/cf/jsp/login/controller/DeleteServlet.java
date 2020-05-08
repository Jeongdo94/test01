package semi.cf.jsp.login.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.cf.jsp.login.model.exception.JoinException;
import semi.cf.jsp.login.model.service.JoinService;
import semi.cf.jsp.login.model.vo.Join;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/mDelete.me")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dept = request.getParameter("dept");
		String userid = request.getParameter("userid");
		
        //HttpSession session = request.getSession(false);
		
		//int userid = ((Join)session.getAttribute("join")).getUserid();
		
		System.out.println("회원 기존 아이디: " + userid);
		
		JoinService js = new JoinService();
		
		Join j = new Join();
		j.setDept(dept);
		
		try {
			js.deleteMember(userid);
			
			System.out.println("회원 탈퇴 성공!");
			
			// 회원탈퇴성공시 현재 로그인한 세션 정보를 초기화해줘야한다.!!!!!!
			//session.invalidate();
			String encodeDept = URLEncoder.encode("조직도","UTF-8");
			response.sendRedirect("views/5_people/"+encodeDept+".jsp");
			
			
		} catch (JoinException e) {
			
			request.setAttribute("msg", "회원 탈퇴 수행 중 에러 발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
