package semi.cf.jsp.login.model.vo;

import java.sql.Date;

public class Join {
	
	private String username;
	private String userno;
	private int userid;
	private int userpwd;
	private String email;
	private String phone;
	private String dept;
	private String posit;
	private Date hire_date;	
	private String ent_yn;
	//private String user_img;
	
	public Join() {}
	
	
	public Join(String username, String userno, int userid, int userpwd, String email, String phone, String dept,
			String posit, Date hire_date, String ent_yn) {
		super();
		this.username = username;
		this.userno = userno;
		this.userid = userid;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
		this.posit = posit;
		this.hire_date = hire_date;
		this.ent_yn = ent_yn;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserno() {
		return userno;
	}


	public void setUserno(String userno) {
		this.userno = userno;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getUserpwd() {
		return userpwd;
	}


	public void setUserpwd(int userpwd) {
		this.userpwd = userpwd;
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


	public String getEnt_yn() {
		return ent_yn;
	}


	public void setEnt_yn(String ent_yn) {
		this.ent_yn = ent_yn;
	}


	@Override
	public String toString() {
		return "Join [username=" + username + ", userno=" + userno + ", userid=" + userid + ", userpwd=" + userpwd
				+ ", email=" + email + ", phone=" + phone + ", dept=" + dept + ", posit=" + posit + ", hire_date="
				+ hire_date + ", ent_yn=" + ent_yn + "]";
	}
	
	
	
	
	

}
