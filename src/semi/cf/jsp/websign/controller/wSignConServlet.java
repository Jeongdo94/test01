package semi.cf.jsp.websign.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.websign.model.service.wSignService;
import semi.cf.jsp.websign.model.vo.wSign;

/**
 * Servlet implementation class wSignCon
 */
@WebServlet("/wSignCon.sc")
public class wSignConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSignConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wDate = request.getParameter("wDate");
		String wTitle = request.getParameter("wTitle");
		String signer = request.getParameter("signer");
		String wWriter = request.getParameter("wWriter");
		String wCls = request.getParameter("wCls");
		String editordata = request.getParameter("editordata");
		int Step = Integer.parseInt(request.getParameter("wStep"));
		
		System.out.println("날짜 전달 확인 : " + wDate);
		System.out.println("작성자 전달 확인 : " + wWriter);
		System.out.println("제목 전달 확인 : " + wTitle);
		System.out.println("결재자 전달 확인 : " + signer);
		System.out.println("구분 전달 확인 : " + wCls);
		System.out.println("내용 전달 확인 : " + editordata);
		System.out.println("단계 전달 확인 : " + Step);
		
		Date writeDate = null;
		
		if(wDate !="" && wDate != null) {
			// 날짜가 들어왔을 때
			// 2020-01-30 --> 2020,1,30
			String[] dateArr = wDate.split("-");
			int[] intArr = new int[dateArr.length];
			
			// String --> int
			for(int i=0; i<dateArr.length;i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			writeDate = new Date(new GregorianCalendar(
					intArr[0],intArr[1]-1,intArr[2]).getTimeInMillis());
		}else {
			// 날짜가 들어오지 않으면
			writeDate = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		wSign ws = new wSign();
		
		System.out.println(writeDate);
		
		ws.setwDate(writeDate);
		ws.setwWriter(wWriter);
		ws.setwTitle(wTitle);
		ws.setSigner(signer);
		ws.setwCls(wCls);
		ws.setwCon(editordata);
		ws.setsStep(Step);
		
		wSignService ss = new wSignService();
		
		int result = ss.insertNotice(ws);
		
		if(result >0) {
			if(ws.getsStep() == 1){
				response.sendRedirect("signlist.sl");
			}else {
				response.sendRedirect("signlist2.sl");
			}
			// 공지사항 추가 성공
			
		}else {
			// 공지사항 추가 실패
			request.setAttribute("msg", "공지사항 등록 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
