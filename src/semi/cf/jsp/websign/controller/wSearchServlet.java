package semi.cf.jsp.websign.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.cf.jsp.member.model.vo.Member;
import semi.cf.jsp.websign.model.service.wSignService;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/wSearch.ws")
public class wSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색 카테고리, 검색 키워드도 가져오자(getParameter에서 사용되는 key값은 태그의 name 속성값인데 클릭이벤트를 주면서
		// 						             서블릿을 호출하는 주소를 생성할 때 key값의 속성명을 수정해서 전달해서 태그의 name과 다르니 헷갈리지말자)
		response.setContentType("application/json; charset=UTF-8");
		String category = request.getParameter("con");
		String keyword = request.getParameter("keyword");
		
		System.out.println(category);
		System.out.println(keyword);
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		wSignService ns = new wSignService();
		
		list = ns.searchMember(category,keyword);
		
		
		/*
		 * String page = "";
		 * 
		 * if(list!=null) { page = "views/2_websign/wSigner.jsp";
		 * request.setAttribute("list", list); } else { page =
		 * "views/2_websign/wSigner.jsp"; request.setAttribute("msg","공지사항 검색 실패!"); }
		 * request.getRequestDispatcher(page).forward(request, response);
		 */
		 
		
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
