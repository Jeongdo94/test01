package semi.cf.jsp.meetingroom.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import semi.cf.jsp.meetingroom.model.vo.MeetingRoom;

import static semi.cf.jsp.common.JDBCTemplate.*;

public class MeetingRoomDao {
   
   private Properties prop;
   
   public MeetingRoomDao() {
      prop = new Properties();
      
      String filePath = MeetingRoom.class.getResource("/config/MeetingRoom-query.properties").getPath();
      
      try{
         prop.load(new FileReader(filePath));
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
   

   /** 
    * 회의실 목록 조회
    * @param con
    * @return
    */
   public ArrayList<MeetingRoom> selectList(String Mtype,Connection con) {
      
        // 전달할 객체 선언
         ArrayList<MeetingRoom> list = null; 
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         String sql = prop.getProperty("selectList");
         
         try {
            pstmt = con.prepareStatement(sql);
            String meetRoomType = "";
            switch(Mtype) {
            case "g":
                  meetRoomType="일반회의실";
                  break;
            case "b":
                  meetRoomType="대회의실";
                  break;
            case "c":
                  meetRoomType="고객접견실";
                  break;
            }
            pstmt.setString(1, meetRoomType);
            rset = pstmt.executeQuery();
            
            
            list = new ArrayList<MeetingRoom>();
            
            // if, while
            while(rset.next()) {
              MeetingRoom m = new MeetingRoom();
               
              //pstmt.setString(1, m.getMselect());
              m.setMno(rset.getInt("MNO"));
              m.setMselect(rset.getString("MSELECT"));
               m.setMdate(rset.getDate("MDATE"));
               m.setStime(rset.getString("MSTIME"));
               m.setFtime(rset.getString("MFTIME"));
               m.setMname(rset.getString("MNAME"));
               m.setUserid(rset.getString("MWRITE"));
               m.setDept(rset.getString("MDEPT"));
               
               list.add(m);
               
               System.out.println(m);
     
            }
         }catch(SQLException e) {
            e.printStackTrace();
         }finally {
            close(rset);
            close(pstmt);
         }
         return list;
   }


   /**
    * 회의실 예약 등록
    * @param con
    * @param m
    * @return
    */
   public int insertMeetingRoom(String Mtype, Connection con, MeetingRoom m) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertMeetingRoom");
      
      try {
         pstmt = con.prepareStatement(sql);
         
         String meetRoomType = "";
            switch(Mtype) {
            case "g":
                  meetRoomType="일반 회의실";
                  break;
            case "b":
                  meetRoomType="대 회의실";
                  break;
            case "c":
                  meetRoomType="고객 접견실";
                  break;
            }
            
         pstmt.setString(1, m.getMselect());
         pstmt.setString(2, m.getStime());
         pstmt.setString(3, m.getFtime());
         pstmt.setString(4, m.getMname());
         pstmt.setString(5, m.getUserid());
         pstmt.setString(6, m.getDept());
         
         System.out.println("이건?" + result);
         
         result = pstmt.executeUpdate();
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result;
   }

   /**
    * 회의실 상세보기
    * @param con
    * @param mno
    * @return
    */
   public MeetingRoom selectOne(Connection con, int mno) {
      
      MeetingRoom m = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectOne");
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setInt(1, mno);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            m = new MeetingRoom();
            
            m.setMno(mno);
            m.setMselect(rset.getString("MSELECT"));
            m.setMdate(rset.getDate("MDATE"));
            
            m.setStime(rset.getString("MSTIME"));
            m.setFtime(rset.getString("MFTIME"));
            
            m.setMname(rset.getString("MNAME"));
            m.setUserid(rset.getString("MWRITE"));
            m.setDept(rset.getString("MDEPT"));
            
            System.out.println("회의실 확인 : " + m);
         }
         
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         close(rset);
         close(pstmt);
      }
      return m;
   }


   /**
    * 회의실 예약 삭제
    * @param con
    * @param mno
    * @return
    */
   public int delectMeetingRoom(Connection con, int mno) {
      
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("deleteMeetingRoom");
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setInt(1, mno);
         
         result = pstmt.executeUpdate();
         
         System.out.println("deleteMeetingRoom Dao : " + result);
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result;
   }


   /**
    * 회의실 예약 시간 중복 체크
    * @param con
    * @param stime
    * @param ftime
    * @return
    */
   public int meetingroomDupcheck(Connection con, String stime, String ftime) {
      int result = -1;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("meetingroomDupCheck");
      
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, stime);
         pstmt.setString(2, ftime);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            // -1 : 에러!
            // 0 : id중복 사용자 없음
            // 1 : id를 누군가 이미 사용 중임
            result = rset.getInt(1);
         }
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         close(rset);
         close(pstmt);
      }
      
      return result;
   }

}