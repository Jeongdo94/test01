package semi.cf.jsp.meetingroom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.meetingroom.model.service.MeetingRoomService;

/**
 * Servlet implementation class MeetingRoomDuplicateServlet
 */
@WebServlet("/meetingroomDup.me")
public class MeetingRoomDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomDuplicateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stime = request.getParameter("stime");
		String ftime = request.getParameter("ftime");
		String mtype = request.getParameter("mtype");
		
		System.out.println("시작 시간 확인" + stime);
		System.out.println("종료 시간 확인" + ftime);
		System.out.println("타입 오는지 확인" + mtype);
		
		
		MeetingRoomService ms = new MeetingRoomService();
		
		int result = ms.meetingroomDupcheck(stime, ftime, mtype);
		
		response.getWriter().print((result > 0)? "no" : "ok");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
