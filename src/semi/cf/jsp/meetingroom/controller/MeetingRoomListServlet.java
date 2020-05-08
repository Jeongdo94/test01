package semi.cf.jsp.meetingroom.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.meetingroom.model.service.MeetingRoomService;
import semi.cf.jsp.meetingroom.model.vo.MeetingRoom;

/**
 * Servlet implementation class MeetingRoomList
 */
@WebServlet("/meetingroomList.me")
public class MeetingRoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>();
		
		String Mtype = request.getParameter("type");
		
		MeetingRoomService ms = new MeetingRoomService();
		
		System.out.println("타입 확인"+Mtype);
		list = ms.selectList(Mtype.toLowerCase());
		//list = ms.selectList(Mtype);
		
		String page = "";
		
		if(list != null) {
			page = "views/9_meetingroom/meetingroomList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("title", Mtype);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 목록 불러오기 에러!");
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
