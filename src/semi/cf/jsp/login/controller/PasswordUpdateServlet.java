package semi.cf.jsp.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.cf.jsp.login.model.service.MemberService;
import semi.cf.jsp.member.model.exception.MemberException;
import semi.cf.jsp.member.model.vo.Member;

/**
 * Servlet implementation class PasswordUpdate
 */
@WebServlet("/pwUpdate.pu")
public class PasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		String userPwd1 = request.getParameter("userPwd1");
		String userPwd2 = request.getParameter("userPwd2");

		System.out.println("새비번 : " + userPwd1);
		System.out.println("비번확인 : " + userPwd2);
		System.out.println("업댓할사번 : " + userId);

		Member m = new Member();

		MemberService ms = new MemberService();
		
		try {
			m.setUserId(userId);
			m.setUserPwd(userPwd2);
			
			if(userPwd1.equals(userPwd2)) {
				
				
				int result = ms.updatePwd(m);
				
				System.out.println("새비번이 업뎃이 되었을까여? " + m.getUserPwd());
				System.out.println("이것은 m " + m);
				
				response.sendRedirect("views/1_login/login.jsp");

			}
		}catch(Exception e) {
			request.setAttribute("msg", "비밀번호 업뎃중 에러");
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
