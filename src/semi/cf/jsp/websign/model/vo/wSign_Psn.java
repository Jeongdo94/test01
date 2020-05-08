package semi.cf.jsp.websign.model.vo;

import java.io.Serializable;

public class wSign_Psn implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2023293156262254058L;
	private int wNo;
	private String userId;
	private int apprOrder;
	private String appr_Yn;
	private String sign;
	
	public wSign_Psn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wSign_Psn(int wNo, String userId, int apprOrder, String appr_Yn, String sign) {
		super();
		this.wNo = wNo;
		this.userId = userId;
		this.apprOrder = apprOrder;
		this.appr_Yn = appr_Yn;
		this.sign = sign;
	}

	public int getwNo() {
		return wNo;
	}

	public void setwNo(int wNo) {
		this.wNo = wNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getApprOrder() {
		return apprOrder;
	}

	public void setApprOrder(int apprOrder) {
		this.apprOrder = apprOrder;
	}

	public String getAppr_Yn() {
		return appr_Yn;
	}

	public void setAppr_Yn(String appr_Yn) {
		this.appr_Yn = appr_Yn;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "wSign_Psn [wNo=" + wNo + ", userId=" + userId + ", apprOrder=" + apprOrder + ", appr_Yn=" + appr_Yn
				+ ", sign=" + sign + "]";
	}

	
}
