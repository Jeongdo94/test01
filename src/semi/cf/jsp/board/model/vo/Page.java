package semi.cf.jsp.board.model.vo;

import java.io.Serializable;

public class Page implements Serializable{

	private int currentPage; // 현재페이지
	private int listCount; // 
	private int limit; // 총 페이지 수 (한 페이지 당 보여줄 게시글 수)
	private int maxPage; // 전체 페이지의 가장 마지막 페이지
	private int startPage; //시작 페이지
	private int endPage; // 한 번에 표시할 페이지들 중 가장 뒤의 페이지
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit + ", maxPage="
				+ maxPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
}
