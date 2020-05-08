package semi.cf.jsp.websign.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class wSign implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2931788457154974402L;
	
	private int wNo;
	private String wTitle;
	private String wWriter;
	private String wCls;
	private String wCon;
	private Date wDate;
	private String signer;
	private int sStep;
	
	public wSign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wSign(int wNo, String wTitle, String wCls) {
		super();
		this.wNo = wNo;
		this.wTitle = wTitle;
		this.wCls = wCls;
	}

	public wSign(String wTitle, String wWriter, String wCls, Date wDate, String signer, int sStep) {
		super();
		this.wTitle = wTitle;
		this.wWriter = wWriter;
		this.wCls = wCls;
		this.wDate = wDate;
		this.signer = signer;
		this.sStep = sStep;
	}

	public wSign(String wTitle, String wCls, String wCon, Date wDate, String signer) {
		super();
		this.wTitle = wTitle;
		this.wCls = wCls;
		this.wCon = wCon;
		this.wDate = wDate;
		this.signer = signer;
	}

	public wSign(String signer, int sStep) {
		super();
		this.signer = signer;
		this.sStep = sStep;
	}

	public wSign(int wNo, String wTitle, String wWriter, String wCls, String wCon, Date wDate, String signer,
			int sStep) {
		super();
		this.wNo = wNo;
		this.wTitle = wTitle;
		this.wWriter = wWriter;
		this.wCls = wCls;
		this.wCon = wCon;
		this.wDate = wDate;
		this.signer = signer;
		this.sStep = sStep;
	}

	public int getwNo() {
		return wNo;
	}

	public void setwNo(int wNo) {
		this.wNo = wNo;
	}

	public String getwTitle() {
		return wTitle;
	}

	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}

	public String getwWriter() {
		return wWriter;
	}

	public void setwWriter(String wWriter) {
		this.wWriter = wWriter;
	}

	public String getwCls() {
		return wCls;
	}

	public void setwCls(String wCls) {
		this.wCls = wCls;
	}

	public String getwCon() {
		return wCon;
	}

	public void setwCon(String wCon) {
		this.wCon = wCon;
	}

	public Date getwDate() {
		return wDate;
	}

	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public int getsStep() {
		return sStep;
	}

	public void setsStep(int sStep) {
		this.sStep = sStep;
	}

	@Override
	public String toString() {
		return "wSign [wNo=" + wNo + ", wTitle=" + wTitle + ", wWriter=" + wWriter + ", wCls=" + wCls + ", wCon=" + wCon
				+ ", wDate=" + wDate + ", signer=" + signer + ", sStep=" + sStep + "]";
	}
}
