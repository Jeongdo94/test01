package semi.cf.jsp.boardComment.model.vo;

import java.io.Serializable;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -410102615352107620L;

	private int cno; // 댓글번호
	private int cbno; //게시판번호
	private String cbtype;//게시판종류
	private String cwriter;//작성자
	private String ccon;//내용
	private String cdate;//작성일
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int cno, int cbno, String cbtype, String cwriter, String ccon, String cdate) {
		super();
		this.cno = cno;
		this.cbno = cbno;
		this.cbtype = cbtype;
		this.cwriter = cwriter;
		this.ccon = ccon;
		this.cdate = cdate;
	}
	

	public Comment(int cbno, String cbtype, String cwriter, String ccon) {
		super();
		this.cbno = cbno;
		this.cbtype = cbtype;
		this.cwriter = cwriter;
		this.ccon = ccon;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getCbno() {
		return cbno;
	}

	public void setCbno(int cbno) {
		this.cbno = cbno;
	}

	public String getCbtype() {
		return cbtype;
	}

	public void setCbtype(String cbtype) {
		this.cbtype = cbtype;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public String getCcon() {
		return ccon;
	}

	public void setCcon(String ccon) {
		this.ccon = ccon;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "Comment [cno=" + cno + ", cbno=" + cbno + ", cbtype=" + cbtype + ", cwriter=" + cwriter + ", ccon="
				+ ccon + ", cdate=" + cdate + "]";
	}
	
	
	
	

}
