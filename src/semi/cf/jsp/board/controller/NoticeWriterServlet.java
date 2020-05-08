package semi.cf.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.cf.jsp.board.model.service.NoticeService;
import semi.cf.jsp.board.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriterServlet
 */
@WebServlet("/noticeWriter3.nw")
public class NoticeWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://servlets.com/cos/MultipartRequest를 사용하기위한 라이브러리 다운로드
		//cos.jar 파일을 WEB-INF/lib 폴더에 추가
		
		//파일 처리용 서블릿
		//1.전송할 최대 크기 설정
		//10MB --> (Byte크기로 변환하기)
		//1MB -> 1024KB ,  1KB -> 1024Byte
		//1024 * 1024 * 10
		int maxSize = 1024*1024*10;
	
		//2.multipart/form-data 형식으로 전송되었는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			//만약 올바른 multipart/form-data로 전송되지 않았을경우
			//에럽페이지로 즉시 이동시킨다.
			request.setAttribute("msg", "multipath를 통한 전송이 아닙니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
		}
		
		//3.웹 상의 루트(최상위 경로) 경로를 활용하여 저장할 폴더의 위치 지정하기
		//getRealPath("/") : 프로젝트의 루트(root)경로가 반환
		//절대경로 , D드라이브위치까지!!
		String root = request.getServletContext().getRealPath("/");
		System.out.println("root : "+root);
		
		//게시판의 첨부파일을 저장할 폴더 이름 지정하기 
		String savePath = root + "resources/boardUploadFiles";
		
		//4.실제 담아온 파일 기타 정보들을 활용하여
		//multipartRequest. 생성하기
		//request->MultipartRequest
		MultipartRequest mrequest = new MultipartRequest(
										request, //변경하기 위한 원본 객체 
										savePath, //파일 저장 경로
										maxSize, //저장할 파일의 최대크기
										"UTF-8", //저장할 문자셋 설정
										new DefaultFileRenamePolicy()
										//동일한 이름의 파일을 저장했을 겨우
										//기존의 파일과 구분하기 위해
										//새로운 파일명 뒤에 숫자를 붙이는 규칙
										);
		// ---파일 업로드 로직 실시 --//
		//5-1. 기본 전송값 처리
		String title = mrequest.getParameter("title");
		String content = mrequest.getParameter("content");
		String write = mrequest.getParameter("write");
		String cls = mrequest.getParameter("cls");
		String ntype = mrequest.getParameter("ntype");
	
		
		//5-2전송된 파일 처리하기
		String file = mrequest.getFilesystemName("file");
		
		//6. 전송된 파일 VO에 담아서 서비스로 보내기
		Notice n = new Notice();
		n.setBtitle(title);
		n.setBcon(content);
		n.setBwriter(write);
		n.setBcls(cls);
		n.setBoardfile(file);
		n.setBtype(ntype);
	
		System.out.println("글작성 서블렛 : "+n);
		
		//7.서비스 결과 처리
		int result = new NoticeService().writerNotice(n);
		
		String rtype =null;
		switch(ntype) {
		case "공지사항" : rtype ="a" ; break;
		case "인사게시판" : rtype ="b" ; break;
		case "일반게시판" : rtype ="c" ; break;
		case "경조사게시판" : rtype ="d" ; break;
		}
		
		if(result>0) {
			response.sendRedirect("noticeList.nl?type="+rtype);
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
