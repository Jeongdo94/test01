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
import semi.cf.jsp.boardComment.model.service.CommentService;
import semi.cf.jsp.boardComment.model.vo.Comment;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/noticeDetail.nd")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int bno = Integer.parseInt(request.getParameter("bno"));
	System.out.println(bno);
	//게시글 상세조회
	Notice n = new NoticeService().NoticeDetail(bno);
	
	//게시판 댓글 조회
	ArrayList<Comment> clist= new CommentService().selectList(bno);
	
	
	String page ="";
	
	if(n != null) {
		System.out.println("n 서블렛= "+n);
		page = "views/5_board/noticeDetail.jsp";
		request.setAttribute("notice", n);
		request.setAttribute("clist", clist);
		
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
