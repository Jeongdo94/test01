package semi.cf.jsp.login.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.login.model.exception.JoinException;
import semi.cf.jsp.login.model.service.JoinService;
import semi.cf.jsp.login.model.vo.Join;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.me")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		int userpwd = Integer.parseInt(request.getParameter("userpwd"));
		String username = request.getParameter("username");
		String userno = request.getParameter("userno");
		String email = request.getParameter("email");
		String phone = request.getParameter("tel1")+"-"
				      + request.getParameter("tel2")+"-"
				      + request.getParameter("tel3");
		String dept = request.getParameter("dept");
		String posit = request.getParameter("posit");
		String hire_date = request.getParameter("hire_date");	
		String ent_yn = request.getParameter("ent_yn") ;
		
		System.out.println(userid);
		System.out.println(userpwd);
		System.out.println(username);
		System.out.println(userno);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(dept);
		System.out.println(posit);
		System.out.println(hire_date);
		System.out.println(ent_yn);
		
	
        Date writeDate = null;
		
		if(hire_date !="" && hire_date != null) {
			//날짜가 들어왔을 때
			//2020-01-30 --> 2020, 1, 30
			String[] dateArr = hire_date.split("-");
			int[] intArr = new int[dateArr.length];
			
			//String --> int
			for(int i = 0; i<dateArr.length;i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			writeDate = new Date(new GregorianCalendar(
					intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());
			
		}else {
			// 날짜가 들어오지 않으면
			writeDate = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		// 회원 가입 시 전달을 위한  vo 생성
		Join j = new Join(username,userno,userid,userpwd,email,phone,dept,posit,writeDate,ent_yn);
		System.out.println("가입 회원 정보 확인 : " + j);
		
		// 회원 가입 서비스 실행
		JoinService js = new JoinService();
		
		try {
			js.insertJoin(j);
			System.out.println("정보전달 완료!");
			
			response.sendRedirect("views/1_login/join.jsp");
		} catch (JoinException e) {
			request.setAttribute("msg", "등록 중 에러 발생!!");
			request.setAttribute("exception",e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			//e.printStackTrace();
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
