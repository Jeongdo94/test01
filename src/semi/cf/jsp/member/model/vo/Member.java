package semi.cf.jsp.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1494460870108110195L;
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userNo;
	private String email;
	private String phone;
	private String dept;
	private String posit;
	private Date hire_date;
	private String user_img;
	private String mInfo;
	private String ent_YN;
	private String sign;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public Member(String userId, String userName, String dept, String posit, String user_img) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dept = dept;
		this.posit = posit;
		this.user_img = user_img;
	}

	public Member(String userId, String userPwd, String userName, String userNo, String email, String phone,
			String dept, String posit, Date hire_date, String user_img, String mInfo, String ent_YN, String sign) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNo = userNo;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
		this.posit = posit;
		this.hire_date = hire_date;
		this.user_img = user_img;
		this.mInfo = mInfo;
		this.ent_YN = ent_YN;
		this.sign = sign;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosit() {
		return posit;
	}

	public void setPosit(String posit) {
		this.posit = posit;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getmInfo() {
		return mInfo;
	}

	public void setmInfo(String mInfo) {
		this.mInfo = mInfo;
	}

	public String getEnt_YN() {
		return ent_YN;
	}

	public void setEnt_YN(String ent_YN) {
		this.ent_YN = ent_YN;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNo=" + userNo
				+ ", email=" + email + ", phone=" + phone + ", dept=" + dept + ", posit=" + posit + ", hire_date="
				+ hire_date + ", user_img=" + user_img + ", mInfo=" + mInfo + ", ent_YN=" + ent_YN + ", sign=" + sign
				+ "]";
	}

	
}
