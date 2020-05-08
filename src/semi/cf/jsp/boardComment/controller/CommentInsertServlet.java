package semi.cf.jsp.boardComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.boardComment.model.service.CommentService;
import semi.cf.jsp.boardComment.model.vo.Comment;

/**
 * Servlet implementation class CommentInsertServlet
 */
@WebServlet("/commentInsert.cn")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cwrite = request.getParameter("writer");  // 작성자
		String ccon = request.getParameter("replyContent");  //댓글내용
		String cbtype = request.getParameter("ntype");  //게시판유형
		int cbno = Integer.parseInt(request.getParameter("bno")); //게시판글번호 (댓글번호=cno)
		
		
		Comment nco = new Comment(cbno,cbtype,cwrite,ccon);
		System.out.println("댓글 추가 서블렛 : "+ nco);
		
		int result = new CommentService().insertComment(nco);
		
		if(result>0) {
			response.sendRedirect("noticeDetail.nd?bno="+cbno);
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
