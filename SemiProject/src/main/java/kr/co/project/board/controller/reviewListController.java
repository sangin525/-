package kr.co.project.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.ReviewPageInfo;
import kr.co.project.board.page.ReviewPagenation;
import kr.co.project.board.service.BoardServiceImpl;


@WebServlet("/reviewList.do")
public class reviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public reviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cpage = 현재 페이지
		String cpageStr = request.getParameter("cpage");
		int cpage;
		if (cpageStr == null || cpageStr.isEmpty()) {
		    cpage = 1;  // 기본 페이지 번호를 1로 설정
		} else {
		    try {
		        cpage = Integer.parseInt(cpageStr);
		    } catch (NumberFormatException e) {
		        cpage = 1;  // 파라미터가 숫자가 아닌 경우 페이지 번호를 1로 설정
		    }
		}
		// 서비스 객체 생성
		BoardServiceImpl boardService = new BoardServiceImpl();
		// 전체 리뷰 수
		int reviewListCount = boardService.reviewListCount();

		// 보여질 페이지 수
		int pageLimit = 5;

		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 5;
		
		// 페이징 처리
		ReviewPagenation page = new ReviewPagenation();
		ReviewPageInfo pi = page.getPageInfo(cpage, reviewListCount, pageLimit, boardLimit);
		
		// 목록 불러오기
		ArrayList<BoardDTO> list = boardService.reviewList(pi);
		for (BoardDTO item : list) {
		    int reviewNo = item.getReviewNo();
		    List<String> fileNames = boardService.getReviewPhotos(reviewNo);
		    item.setFileNames(fileNames);  // BoardDTO 객체에 사진 리스트를 저장
		    
		}
		int row = reviewListCount - (cpage - 1) * boardLimit;
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list); // 수정된 리스트를 JSP에 전달
		RequestDispatcher view = request.getRequestDispatcher("/views/board/review.jsp");
		view.forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
