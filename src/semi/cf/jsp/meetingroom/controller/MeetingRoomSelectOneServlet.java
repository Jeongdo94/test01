package semi.cf.jsp.meetingroom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.meetingroom.model.service.MeetingRoomService;
import semi.cf.jsp.meetingroom.model.vo.MeetingRoom;

/**
 * Servlet implementation class MeetingRoomSelectOneServlet
 */
@WebServlet("/meetingroomSelectOne.me")
public class MeetingRoomSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		System.out.println("확인 :" + mno);
		
		MeetingRoomService ms = new MeetingRoomService();
		
		MeetingRoom m = ms.selectOne(mno);
		
		System.out.println("test1:"+m);
		
		String page = "";
		
		if(m != null) {
			page = "views/9_meetingroom/meetingroomDetail.jsp";
			request.setAttribute("meetingroom", m);
			System.out.println(m);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "예약 상세보기 실패 !");
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
