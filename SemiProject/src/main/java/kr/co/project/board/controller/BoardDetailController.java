package kr.co.project.board.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/BoardDetail.do")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardServiceImpl boardService = new BoardServiceImpl();
		int result = boardService.boardView(boardNo);

		// 조회수 증가가 성공하면 아래 내용 진행
		if (result > 0) {
			BoardDTO board = new BoardDTO();
			board.setBoardNo(boardNo);
			
			// 댓글 관련도 같이 가져옴
			boardService.boardSelect(board);
			if(!Objects.isNull(board.getBoardNo())) {
				request.setAttribute("board", board);
				RequestDispatcher view = request.getRequestDispatcher("/views/board/boardDetail.jsp");
				view.forward(request, response);
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
