package semi.cf.jsp.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {
	
	private int bno; // 번호
	private String bcls; // 분류(일반,긴급)
	private String btitle; // 제목
	private Date bdate; // 날짜 
	private int bcount; //조회수
	private String bcon; // 내용
	private String btype; // 공지사항, 일반게시판 ,사내경조사 ,인사발령
	private String boardfile; // 게시글 첨부파일
	private String bwriter; //작성자
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6958958872043885932L;

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int bno, String bcls, String btitle, Date bdate, int bcount) {
		super();
		this.bno = bno;
		this.bcls = bcls;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bcount = bcount;
	}
	
	
	
	public Notice(int bno, String bcls, String btitle, Date bdate, int bcount, String bwriter) {
		super();
		this.bno = bno;
		this.bcls = bcls;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bcount = bcount;
		this.bwriter = bwriter;
	}

	public Notice(String bcls, String btitle, String bcon, String boardfile, String bwriter) {
		super();
		this.bcls = bcls;
		this.btitle = btitle;
		this.bcon = bcon;
		this.boardfile = boardfile;
		this.bwriter = bwriter;
	}

	public Notice(int bno, String bcls, String btitle, Date bdate, int bcount, String bcon, String btype, String boardfile,
			String bwriter) {
		super();
		this.bno = bno;
		this.bcls = bcls;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bcount = bcount;
		this.bcon = bcon;
		this.btype = btype;
		this.boardfile = boardfile;
		this.bwriter = bwriter;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBcls() {
		return bcls;
	}

	public void setBcls(String bcls) {
		this.bcls = bcls;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getBcon() {
		return bcon;
	}

	public void setBcon(String bcon) {
		this.bcon = bcon;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}
	
	

	public String getBoardfile() {
		return boardfile;
	}

	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}

	public String getBwriter() {
		return bwriter;
	}
	
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	@Override
	public String toString() {
		return "Notice [bno=" + bno + ", bcls=" + bcls + ", btitle=" + btitle + ", bdate=" + bdate + ", bcount="
				+ bcount + ", bcon=" + bcon + ", btype=" + btype + ", boardfile=" + boardfile + ", bwriter=" + bwriter
				+ "]";
	}

	

	
	
	
}
