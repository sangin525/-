package kr.co.project.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.BoardPagination;
import kr.co.project.board.service.BoardServiceImpl;


@WebServlet("/reviewListController")
public class reviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public reviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cpage = 현재 페이지
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		// 서비스 객체 생성
		BoardServiceImpl boardService = new BoardServiceImpl();
		// 전체 게시글 수
		int reviewListCount = boardService.boardListCount();

		// 보여질 페이지 수
		int pageLimit = 5;

		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 5;
		
		// 페이징 처리
		BoardPagination page = new BoardPagination();
		BoardPageInfo pi = page.getPageInfo(cpage, reviewListCount, pageLimit, boardLimit);
		
		// 목록 불러오기
		ArrayList<BoardDTO> list = boardService.reviewList(pi);
		System.out.println(list);

		int row = reviewListCount - (cpage - 1) * boardLimit;
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("/views/board/review.jsp");
		view.forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
