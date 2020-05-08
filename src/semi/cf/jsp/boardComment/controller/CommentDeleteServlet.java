package semi.cf.jsp.boardComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.board.model.service.NoticeService;
import semi.cf.jsp.boardComment.model.service.CommentService;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/cDelete.cd")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		CommentService cs = new CommentService();
		System.out.println("게시판 댓글 댓글번호:"+cno);
		System.out.println("게시판 댓글 글번호:"+bno);
		
		int result = cs.commentDelete(cno);
		
		
		if(result>0) {
			response.sendRedirect("noticeDetail.nd?bno="+bno);
		}else {
			
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
