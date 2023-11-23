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
import kr.co.project.board.service.BoardServiceImpl;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		ArrayList<BoardDTO> list = boardService.boardList();
		BoardDTO boardDTO = new BoardDTO();
		
//		테스트 용도 세션, 이후 merge 이후 삭제 필요
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("M_NAME");
		boardDTO.setName(name);
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("views/board/boardList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

}
