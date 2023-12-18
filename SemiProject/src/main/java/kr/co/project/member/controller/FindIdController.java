package kr.co.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;

@WebServlet("/FindId.do")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindIdController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		MemberDTO member = new MemberDTO();

		member.setName(name);
		member.setEmail(email);
		System.out.println(member.getName());
		System.out.println(member.getEmail());
		MemberServiceImpl memberService = new MemberServiceImpl();
		memberService.findId(member);

		if (member.getId() != null) {
			request.setAttribute("foundId", member.getId());
			request.getRequestDispatcher("/views/member/showId.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "존재하지 않는 회원입니다.");
			request.getRequestDispatcher("/views/member/findIdFailure.jsp").forward(request, response);
		}
	}
}
