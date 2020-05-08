package semi.cf.jsp.meetingroom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.meetingroom.model.service.MeetingRoomService;

/**
 * Servlet implementation class MeetingRoomDeleteServlet
 */
@WebServlet("/meetingroomDelete.me")
public class MeetingRoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mno = Integer.parseInt(request.getParameter("mno"));
		String Mtype = request.getParameter("type");
		
		System.out.println("타입 확인 :" + Mtype);
		System.out.println("삭제 확인 :" + mno);
		
		MeetingRoomService ms = new MeetingRoomService();
		
		int result = ms.deleteMeetingRoom(mno);
		
		if(result > 0) {
			System.out.println("리스트로 이동");
			response.sendRedirect("meetingroomList.me?type="+Mtype);
		}else {
			request.setAttribute("msg", "삭제 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			.forward(request, response);
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
