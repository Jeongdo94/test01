package semi.cf.jsp.websign.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.websign.model.service.wSignService;
import semi.cf.jsp.websign.model.vo.wSign;
import semi.cf.jsp.websign.model.vo.wSign_Psn;

/**
 * Servlet implementation class wSignYnServlet
 */
@WebServlet("/wSignYnServlet.sy")
public class wSignYnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSignYnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wno = Integer.parseInt(request.getParameter("wno"));
		String id = request.getParameter("id");
		
		// NoticeService에서 반환받을 변수를 지정
		// NoticeService에 있는 selectOne()메소드[상세페이지를 호출하기위한 메소드]를
		
		int result = new wSignService().updateYn(wno, id);
		
		// DB에서 전달받은 객체정보를 전달할 코드 작성
		String page = ""; // --> 성공을 하던, 실패를 하던 각각의 페이지에다가 forward방식으로 호출할 예정이라
						  // 변수하나를 선언
		if(result > 0) { // 공지글 상세페이지 데이터 가져오는데 성공
			page = "signlist2.sl";
			// request.setAttribute("내가 전달할 객체(변수)의 명을 기입", "내가 전달할 객체(변수)값을 기입");
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 상세보기 실패!");
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
