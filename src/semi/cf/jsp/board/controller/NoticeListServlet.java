package semi.cf.jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.board.model.service.NoticeService;
import semi.cf.jsp.board.model.vo.Notice;
import semi.cf.jsp.board.model.vo.Page;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/noticeList.nl")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Notice> list = null;
		
		NoticeService ns = new NoticeService();
		String ntype = request.getParameter("type");

		///////////////////////게시판 페이징처리////////////////////////////
		// 1 , 11 , 21 , 31 ... 
		int startPage;
		
		// 10 , 20 , 30 ...
		int endPage;
		
		//전체 페이지의 가장 마지막 페이지
		int maxPage;
		
		//현재 페이지
		//처음 접속 시 페이지는 1페이지 시작
		int currentPage = 1;
		
		//총 페이지수 ( 한 페이지 당 보여줄 게시글 수)
		//글 개수  및 페이지 수 10개
		int limit = 10;
		if(request.getParameter("currentPage") != null) {
			System.out.println("currentPage : " + request.getParameter("currentPage"));
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("currentPage: " + currentPage);
		//페이징 처리 listCount : 총 게시글 수 
		int listCount = ns.getListCount(ntype);
		
		System.out.println("총 게시글 수  : " + listCount);
		
		//전체페이지중 마지막페이지
		maxPage = (int)((double)listCount/limit+0.9);
		
		//시작페이지
		startPage = ((currentPage - 1) / limit) * limit + 1;//(int)((double)(currentPage/limit + 0.9)-1.0) * limit +1;

		System.out.println("startPage2 : " + startPage);
		
		//끝페이지
		endPage = startPage + limit -1 ;
		System.out.println("endPage : " + endPage);
		// 만약 마지막 페이지보다 현재 게시글이 끝나는 페이지가 적다면
		// ex)  총 페이지가 7페이지 or 13 페이지
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		//////////////////////게시판 목록 리스트/////////////////////////
		
		list = ns.selectList(currentPage, limit , ntype);
		
		String page = "";
		
		if(list != null) {
			//jsp로 넘겨주기 위해서는 setattribute로 넘겨주고 getattribute로 받아준다.
			page = "views/5_board/noticeList.jsp";
			request.setAttribute("list", list);
			
			Page pg = null;
			pg = new Page(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pg", pg);
		}else {
		
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
