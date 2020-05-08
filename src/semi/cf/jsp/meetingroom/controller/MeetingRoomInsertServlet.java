package semi.cf.jsp.meetingroom.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.cf.jsp.meetingroom.model.service.MeetingRoomService;
import semi.cf.jsp.meetingroom.model.vo.MeetingRoom;

/**
 * Servlet implementation class MeetingRoomInsertServlet
 */
@WebServlet("/meetingroomInsert.me")
public class MeetingRoomInsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public MeetingRoomInsertServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      ///-- > 여기서 부터
      // 회의실 예약의 시작시간 종료시간 회의명 작성
      String mselect = request.getParameter("mselect");
      String mstime = request.getParameter("stime");
      String mftime = request.getParameter("ftime");
      String mname = request.getParameter("mname");
      String username = request.getParameter("People");
      String dept = request.getParameter("TeamName");
      // request.getParameter() --> 사용자가 요청하면서 전달한 값들은 문자열 형태로 받아오는 메소드

      System.out.println("시간 전달 확인1 : " + mstime);
      System.out.println("시간 전달 확인2 : " + mftime);
      System.out.println("선택 확인 : " + mselect);
      System.out.println("회의실명 확인 : " + mname);

      //   <--- 여기까지 사용자가 입력한 값을 받아서 변수에 지정한 코드 

      // --> 여기서부터 
      // 공지사항 등록을 위한 VO 객체 만들기
      MeetingRoom m = new MeetingRoom();
      
      m.setMselect(mselect);
      m.setStime(mstime);
      m.setFtime(mftime);
      m.setMname(mname);
      m.setUserid(username);
      m.setDept(dept);
      
      
      //<-- 여기가까지는 받은값을 Service로 전달하기위해서 객체를 만든코드
      // 몰론 객체로 만들지 않아도된다. 객체로 만들지 않으면 ns.insertNotice(ntitle,writer,content,wirteDate) 이렇게
      // 호출하면된다. Service,Dao에서 메소드를 만들어줄때
      // insertNotice(String ntitle,String wirter,String content,Date writeDate)
      MeetingRoomService ms = new MeetingRoomService();
      
      String Mtype = request.getParameter("newtype");
      System.out.println(Mtype);

      int result = ms.insertMeetingRoom(Mtype, m); // View(JSP) --> Controller(Servlet)---> Service

      if(result > 0) {
         // 회의실 예약 추가 성공
    	  System.out.println("미팅룸 서블렛:"+result);
         response.sendRedirect("views/9_meetingroom/meetingroomInsertForm.jsp?type="+Mtype);
      }else {
         // 공지사항 추가 실패
         request.setAttribute("msg", "회의실 예약 실패!");
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