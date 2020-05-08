package semi.cf.jsp.meetingroom.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MeetingRoom implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4698196661325374002L;
	
	private int mno;
	private String mselect;
	private Date mdate;
	private String stime;
	private String ftime;
	private String mname;
	private String userid;
	private String dept;
	
	public MeetingRoom() {
		
	}

	/**
	 * 목록 불러올때
	 * @param mdate
	 * @param stime
	 * @param ftime
	 * @param mname
	 * @param userid
	 * @param dept
	 */
	public MeetingRoom(Date mdate, String stime, String ftime, String mname, String userid, String dept) {
		super();
		
		this.mdate = mdate;
		this.stime = stime;
		this.ftime = ftime;
		this.mname = mname;
		this.userid = userid;
		this.dept = dept;
	}

	/**
	 * 예약할때
	 * @param mselect
	 * @param stime
	 * @param ftime
	 * @param mname
	 * @param userid
	 * @param dept
	 */
	public MeetingRoom(String mselect, String stime, String ftime, String mname, String userid, String dept) {
		super();
		this.mselect = mselect;
		this.stime = stime;
		this.ftime = ftime;
		this.mname = mname;
		this.userid = userid;
		this.dept = dept;
	}
	
	/**
	 * 상세보기용
	 * @param mno
	 * @param mselect
	 * @param mdate
	 * @param stime
	 * @param ftime
	 * @param mname
	 * @param userid
	 * @param dept
	 */
	public MeetingRoom(int mno, String mselect, Date mdate, String stime, String ftime, String mname, String userid,
			String dept) {
		super();
		this.mno = mno;
		this.mselect = mselect;
		this.mdate = mdate;
		this.stime = stime;
		this.ftime = ftime;
		this.mname = mname;
		this.userid = userid;
		this.dept = dept;
	}

	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	public String getMselect() {
		return mselect;
	}
	
	public void setMselect(String mselect) {
		this.mselect = mselect;
	}	

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MeetingRoom [mdate=" + mdate + ", stime=" + stime + ", ftime=" + ftime + ", mname=" + mname
				+ ", userid=" + userid + ", dept=" + dept + "]";
	}	
}
