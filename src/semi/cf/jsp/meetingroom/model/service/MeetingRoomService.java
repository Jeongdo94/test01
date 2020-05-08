package semi.cf.jsp.meetingroom.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import semi.cf.jsp.meetingroom.model.dao.MeetingRoomDao;
import semi.cf.jsp.meetingroom.model.vo.MeetingRoom;
import static semi.cf.jsp.common.JDBCTemplate.*;

public class MeetingRoomService {
	
	private MeetingRoomDao mDao = new MeetingRoomDao();
	
	/**
	 * 회의실 목록 불러오기
	 * @return
	 */
	public ArrayList<MeetingRoom> selectList(String Mtype) {
		Connection con = getConnection();
		
		ArrayList<MeetingRoom> list = mDao.selectList(Mtype,con);
		
		close(con);
		
		return list;
	}

	/**
	 * 회의실 예약
	 * @param m
	 * @return
	 */
	public int insertMeetingRoom(String Mtype, MeetingRoom m) {
		
		Connection con = getConnection();
		
		int result = mDao.insertMeetingRoom(Mtype,con,m);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		 System.out.println("미팅룸 서비스:"+result);
		return result;
	}

	/**
	 * 회의실 상세보기
	 * @param mno
	 * @return
	 */
	public MeetingRoom selectOne(int mno) {
		
		Connection con = getConnection();
		
		MeetingRoom m = mDao.selectOne(con, mno);
		
		close(con);
		
		return m;
	}

	/**
	 * 회의실 삭제
	 * @param mno
	 * @return
	 */
	public int deleteMeetingRoom(int mno) {
		
		System.out.println("deleteMeetingRoom 서비스 :" + mno);
		Connection con = getConnection();
		
		int result = mDao.delectMeetingRoom(con, mno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);		
		
		return result;
	}

	/**
	 * 회의실 예약 시간 중복 체크
	 * @param stime
	 * @param ftime
	 * @param mtype
	 * @return
	 */
	public int meetingroomDupcheck(String stime, String ftime, String mtype) {
		Connection con = getConnection();
		
		int result = mDao.meetingroomDupcheck(con, stime, ftime);
		
		close(con);
		
		return result;
	}

}
