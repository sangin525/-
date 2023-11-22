package kr.co.project.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.member.service.MemberServiceImpl;

@WebServlet("/MemberDeleteDetail.do")
public class MemberDeleteDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberDeleteDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에서 아이디 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// 서비스 객체 생성 -> 호출
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.memberDelete(id);
		
		if(result > 0) {
			session.removeAttribute("id");
			session.invalidate();
		}
		RequestDispatcher view = request.getRequestDispatcher("/");
		view.forward(request, response);
	}

}
