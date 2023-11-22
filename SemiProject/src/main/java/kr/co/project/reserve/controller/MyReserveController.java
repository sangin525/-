package kr.co.project.reserve.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.common.MyBoardPageInfo;
import kr.co.project.common.MyBoardPagenation;
import kr.co.project.reserve.dto.MyReserveDTO;
import kr.co.project.reserve.service.MyReserveServiceImpl;

@WebServlet("/MyReserve.do")
public class MyReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MyReserveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 내 회원번호 조회
				HttpSession session = request.getSession();
				int no = (int) session.getAttribute("no");
				System.out.println(no);
				// cpage = 현재 페이지
				int cpage = Integer.parseInt(request.getParameter("cpage"));
				System.out.println(cpage);

				// 서비스 객체 생성
				MyReserveServiceImpl reserveService = new MyReserveServiceImpl();

				// 내 예약 수
				int myListCount = reserveService.myListCount(no);
				System.out.println(myListCount);

				// 보여질 페이지 수
				int pageLimit = 5;

				// 한 페이지에 들어갈 게시글 수
				int boardLimit = 5;

				// 페이징 처리
				MyBoardPagenation page = new MyBoardPagenation();

				MyBoardPageInfo pi = page.getPageInfo(myListCount, cpage, pageLimit, boardLimit);

				// 목록 불러오기
				ArrayList<MyReserveDTO> list = reserveService.myReserveList(pi, no);
				System.out.println(list);

				int row = myListCount - (cpage - 1) * boardLimit;

				request.setAttribute("row", row);
				request.setAttribute("no", no);
				request.setAttribute("pi", pi);
				request.setAttribute("list", list);
				RequestDispatcher view = request.getRequestDispatcher("/views/member/mypage/MyReserve.jsp");
				view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
