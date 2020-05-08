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
 * Servlet implementation class PasswordFind
 */
@WebServlet("/pwFind.pf")
public class PasswordFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordFindServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userNo = request.getParameter("userNo");

		int result = -1;

		System.out.println("사번 : " + userId);
		System.out.println("주민 번호 : " + userNo);

		Member m = new Member();
		m.setUserId(userId);
		m.setUserNo(userNo);		

		MemberService ms = new MemberService();


		try {
			result = ms.findPw(m);
			System.out.println("서블릿의 트라이에 m 값을 받아 오나요?" + result);
			System.out.println("존재!");
			if(result == 1) {
				request.setAttribute("userId", userId);
				request.getRequestDispatcher("views/1_login/passwordFindSuccess.jsp").forward(request, response);
			}else{
				request.setAttribute("userId", userId);
				request.getRequestDispatcher("views/1_login/passwordFind.jsp").forward(request, response);
			};

		}catch(Exception e) {// 회원 아이디 찾지 못했을 떄
			request.setAttribute("msg", "존재하지 않은 회원입니다");
			request.setAttribute("exception", e);

			request.getRequestDispatcher("/views/1_login/passwordFind.jsp");
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
