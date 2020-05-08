package semi.cf.jsp.websign.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.websign.model.vo.PageInfo;
import semi.cf.jsp.websign.model.service.wSignService;
import semi.cf.jsp.websign.model.vo.wSign;

/**
 * Servlet implementation class wSignListServlet
 */
@WebServlet("/signlist.sl")
public class wSignListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSignListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ArrayList<wSign> list = null;
		
		wSignService ws = new wSignService();
//		-------------------------------------------
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = ws.getListCount();
		
		System.out.println("총 페이지 개수 : " + listCount);
		
		maxPage = (int)((double)listCount / limit + 0.9);
		startPage = ((int)((double)currentPage/limit + 0.9)-1) * limit +1;
		endPage = startPage + limit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = ws.selectList(currentPage,limit);
		
		String page = "";		
//		-------------------------------------------
		
		if(list != null) {
			page = "views/2_websign/wSignList.jsp";
			request.setAttribute("list",list);
			
			PageInfo pi = new PageInfo(currentPage, listCount
					, limit, maxPage, startPage,endPage);
			request.setAttribute("pi", pi);
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
