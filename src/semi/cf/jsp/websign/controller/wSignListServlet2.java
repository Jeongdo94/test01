package semi.cf.jsp.websign.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.cf.jsp.websign.model.vo.PageInfo;
import semi.cf.jsp.member.model.vo.Member;
import semi.cf.jsp.websign.model.service.wSignService;
import semi.cf.jsp.websign.model.vo.wSign;
import semi.cf.jsp.websign.model.vo.wSign_Psn;

/**
 * Servlet implementation class wSignListServlet
 */
@WebServlet("/signlist2.sl")
public class wSignListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSignListServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
		ArrayList<wSign> list = null;
		ArrayList<wSign_Psn> list2 = null;
		
		wSignService ws = new wSignService();
		
		list = ws.selectList2(m.getUserId());
		list2 = ws.selectList3();
		
		String page = "";		
		
		if(list != null) {
			page = "views/2_websign/wSignList2.jsp";
			request.setAttribute("list",list);
			request.setAttribute("psn",list2);
		} else {
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
