package semi.cf.jsp.login.controller;

import java.io.IOException;
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
@WebServlet("/select.me")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int userid = Integer.parseInt(request.getParameter("userid"));	//--> String 을 int로 바꿀때는 parseInt를 꼭 붙혀야함ㅇㅇ
		System.out.println(userid);
		// 반은값을 NoticeService로 보내기 위해서 객체를 새롭게 하나 만든다.
		JoinService js = new JoinService();
		
		// NoticeService에서 반환받을 변수를 지정
		// NoticeService에 있는 selectOne()메소드를 [상세페이지를 호출하기위한 메소드]를 호출.
		Join j = js.selectOne(userid);
		
		//DB 에서 전달받은 객체정보를 전달할 코드 작성
		String page = "" ; 
		// --> 성공을 하던, 실패를 하던 각각의 페이지에다가 forward방식으로 호출할 예정이라
		//		변수 하나를 선언
		
		if(j != null) {// 공지사항 상세페이지 데이터 가져오는데 성공할시 
			page = "views/1_login/select.jsp";
			request.setAttribute("Join", j);
			// request.setAttribute("내가 전달할 객체(변수)의 명을 기입","내가전달할 객체(변수)값을 기입");
		}else {
			page = "view/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세보기 실패.");
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
