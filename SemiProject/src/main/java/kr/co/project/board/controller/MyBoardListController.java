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
import kr.co.project.common.MyBoardPageInfo;
import kr.co.project.common.MyBoardPagenation;

@WebServlet("/MyBoardList.do")
public class MyBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyBoardListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션에서 내 회원번호 조회
		HttpSession session = request.getSession();
		int no = (int) session.getAttribute("no");

		// cpage = 현재 페이지
		int cpage = Integer.parseInt(request.getParameter("cpage"));


		// 서비스 객체 생성
		BoardServiceImpl boardService = new BoardServiceImpl();

		// 내 게시글 수
		int myListCount = boardService.myListCount(no);


		// 보여질 페이지 수
		int pageLimit = 5;

		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 5;

		// 페이징 처리
		MyBoardPagenation page = new MyBoardPagenation();

		MyBoardPageInfo pi = page.getPageInfo(myListCount, cpage, pageLimit, boardLimit);

		// 목록 불러오기
		ArrayList<BoardDTO> list = boardService.myBoardList(pi, no);
		System.out.println(list);

		int row = myListCount - (cpage - 1) * boardLimit;

		request.setAttribute("row", row);
		request.setAttribute("no", no);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("/views/member/mypage/MyBoardList.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	}


