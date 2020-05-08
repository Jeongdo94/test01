package semi.cf.jsp.websign.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.websign.model.service.wSignService;
import semi.cf.jsp.websign.model.vo.wSign;
import semi.cf.jsp.websign.model.vo.wSign_Psn;

/**
 * Servlet implementation class wSignerInsertServlet
 */
@WebServlet("/wSignerInsert.si")
public class wSignerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSignerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rName = request.getParameter("rName");
		System.out.println(rName);
		String rUserId = request.getParameter("rUserId");
		System.out.println(rUserId);
		String gName = request.getParameter("gName");
		System.out.println(gName);
		String gUserId = request.getParameter("gUserId");
		System.out.println(gUserId);
		String bName = request.getParameter("bName");
		System.out.println(bName);
		String bUserId = request.getParameter("bUserId");
		System.out.println(bUserId);
		
		wSign_Psn pSigner1 = new wSign_Psn();
		wSign_Psn pSigner2 = new wSign_Psn();
		wSign_Psn pSigner3 = new wSign_Psn();
		
		pSigner1.setUserId(rUserId);
		pSigner1.setApprOrder(1);
		pSigner1.setAppr_Yn("N");
		
		pSigner2.setUserId(gUserId);
		pSigner2.setApprOrder(2);
		pSigner2.setAppr_Yn("N");
		
		pSigner3.setUserId(bUserId);
		pSigner3.setApprOrder(3);
		pSigner3.setAppr_Yn("N");
		
		wSignService ss = new wSignService();
		
		try {
			ss.insertSigner(pSigner1,pSigner2,pSigner3);
			System.out.println("회원 가입 완료!");
			
			response.sendRedirect("views/2_websign/wSignInsert.jsp");
		} catch (Exception e) {
			request.setAttribute("msg", "회원 가입 중 에러 발생!!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
			e.printStackTrace();
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
