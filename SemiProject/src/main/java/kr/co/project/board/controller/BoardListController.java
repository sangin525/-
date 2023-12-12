package kr.co.project.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.BoardPagination;
import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardServiceImpl boardService = new BoardServiceImpl();

		BoardDTO boardDTO = new BoardDTO();

		int cpage = Integer.parseInt(request.getParameter("cpage"));

		// 전체 게시글 수
		int listCount = boardService.boardListCount();
		// 한 페이지에 보여줄 페이지의 수
		int pageLimit = 5;
		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 5;
		// 페이징 처리
		BoardPagination page = new BoardPagination();
		BoardPageInfo pi = page.getPageInfo(cpage, listCount, pageLimit, boardLimit);
		
		ArrayList<BoardDTO> list = boardService.boardList(pi);
		int row = listCount - (cpage -1) * boardLimit;
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/board/boardList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
