package kr.co.project.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.BoardPagination;
import kr.co.project.notice.dto.NoticeDTO;
import kr.co.project.notice.service.NoticeServiceImpl;

@WebServlet("/NoticeSearchList.do")
public class NoticeSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeSearchListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String SearchName = request.getParameter("search");
		
		NoticeServiceImpl noticeService = new NoticeServiceImpl();

		int cpage = Integer.parseInt(request.getParameter("cpage"));

		// 전체 게시글 수
		int listCount = noticeService.noticeSearchCount(SearchName);
		// 한 페이지에 보여줄 페이지의 수
		int pageLimit = 5;
		// 한 페이지에 들어갈 게시글 수
		int boardLimit = 5;
		// 페이징 처리
		BoardPagination page = new BoardPagination();
		BoardPageInfo pi = page.getPageInfo(cpage, listCount, pageLimit, boardLimit);
		
		ArrayList<NoticeDTO> list = noticeService.noticeSearchList(pi, SearchName);
		int row = listCount - (cpage -1) * boardLimit;
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("searchName", SearchName);
		
		RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
