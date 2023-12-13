package kr.co.project.board.page;

public class ReviewPagenation {
	public static ReviewPageInfo getPageInfo(int currentPage, int ReviewListCount,int pageLimit,int boardLimit) {
		int maxPage = (int)Math.ceil((double)ReviewListCount/boardLimit);
		
		int startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		int offset = (currentPage - 1) * boardLimit;
		
		ReviewPageInfo pi = new ReviewPageInfo(ReviewListCount, currentPage, pageLimit, boardLimit, maxPage, startPage,endPage,offset);
		return pi;
		
	}

}