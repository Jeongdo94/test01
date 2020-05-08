package semi.cf.jsp.login.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.GregorianCalendar;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.me")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userno = request.getParameter("userno");
		int userid = Integer.parseInt(request.getParameter("userid"));
		int userpwd = Integer.parseInt(request.getParameter("userpwd"));
		String email = request.getParameter("email");
		String phone = request.getParameter("tel1")+"-"
				      + request.getParameter("tel2")+"-"
				      + request.getParameter("tel3");
		String dept = request.getParameter("dept");
		String posit = request.getParameter("posit");
		String hire_date = request.getParameter("hire_date");	
		String ent_yn = request.getParameter("ent_yn") ;
		
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
		
		Join j = new Join();
		j.setUserid(userid);
		j.setUserpwd(userpwd);
		j.setUsername(username);
		j.setUserno(userno);
		j.setEmail(email);
		j.setPhone(phone);
		j.setDept(dept);
		j.setPosit(posit);
		j.setHire_date(writeDate);
		j.setEnt_yn(ent_yn);
		
		System.out.println("변경한 회원 정보 확인 : " + j);
		
		JoinService js = new JoinService();
		
		try {
			js.updateJoin(j);
			//TODO update 후에 session 객체 정보는 수정해야함 체크해주세요
//			HttpSession session = request.getSession(false);
//			session.setAttribute("member", j);
		
			System.out.println("회원 정보 수정 완료!");
			String encodeDept = URLEncoder.encode(dept,"UTF-8");
			response.sendRedirect("selectOne.de?dept="+encodeDept);
			
		} catch (JoinException e) {
		
			request.setAttribute("msg", "회원정보 수정 중 에러 발생!");
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
