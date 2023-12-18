package kr.co.project.board.page;

public class BoardPagination {
	public static BoardPageInfo getPageInfo(int currentPage, int listCount,int pageLimit,int boardLimit) {
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		int startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		if(currentPage > maxPage) {
			maxPage = currentPage;
		}
		
		int offset = (currentPage - 1) * boardLimit;
		
		BoardPageInfo pi = new BoardPageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage,endPage,offset);
		return pi;
		
	}

}
