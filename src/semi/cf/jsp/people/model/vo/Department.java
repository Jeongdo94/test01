package semi.cf.jsp.people.model.vo;

import java.sql.Date;

public class Department {
	
	private String userid;
	private String username;
	private String email;
	private String phone;
	private String dept;
	private String posit;
	private Date hire_date;
	//private String user_img;
	
	public Department() {}
	
	
	
	
	public Department(String dept) {
		super();
		this.dept = dept;
	}



    public Department(String username, String userid, String email, String phone, String dept, String posit,
			Date hire_date) {
		super();
		this.username = username;
		this.userid = userid;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
		this.posit = posit;
		this.hire_date = hire_date;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUserid() {
		return userid;
	}
	
	
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
	@Override
	public String toString() {
		return "Department [username=" + username + ", userid=" + userid + ", email=" + email + ", phone=" + phone
				+ ", dept=" + dept + ", posit=" + posit + ", hire_date=" + hire_date + "]";
	}
	
	
	

}
