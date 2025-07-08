package kr.co.soldesk.beans;

public class PageBean {
	// 최소 페이지 번호
	private int min;
	// 최대 페이지 번호
	private int max;
	// 이전 버튼의 페이지 번호
	private int prevPage;
	// 다음 버튼의 페이지 번호
	private int nextPage;
	// 전체 페이지 개수
	private int pageCnt;
	// 현재 페이지 번호
	private int currentPage;

	// contentCnt : 전체글 개수(table), currentPage : 현재 글 번호(param), contentPageCnt :
	// 페이지당 글의 개수(property), paginationCnt : 페이지 버튼의 개수(property)
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {

		// 현재 페이지 번호
		this.currentPage = currentPage;

		pageCnt = contentCnt / contentPageCnt;

		if (contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}

		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		max = min + paginationCnt - 1;
		// 전체글 갯수 63 /max =10 page cnt 7
		// 10개를 다 표시할 필요가 없다.
		if (max > pageCnt) {
			max = pageCnt;
		}
		prevPage = min - 1;
		nextPage = max + 1;
		// 마지막페이지를 넘어가지 않도록
		if (nextPage > pageCnt) {
			nextPage = pageCnt;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
