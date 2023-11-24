package kr.co.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;

@WebServlet("/MemberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberUpdateController() {
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
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		// 값 받아오기(이메일, 전화번호, 생년월일, 주소)
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String beforeEmail = (String)session.getAttribute("email");

		// DTO 객체 생성
		MemberDTO member = new MemberDTO(phone, email, addr, addr1, addr2);

		// 서비스 객체 생성
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.memberUpdate(member, beforeEmail);

		if (result == 0) {
			updateAlert(response, "정보 수정에 실패했습니다.");
		} else {
			session.removeAttribute("phone"); // 세션 삭제
			session.removeAttribute("email"); // 세션 삭제
			session.removeAttribute("addr"); // 세션 삭제
			session.removeAttribute("addr1"); // 세션 삭제
			session.removeAttribute("addr2"); // 세션 삭제

			// 세션 생성
			session.setAttribute("phone", member.getPhone());
			session.setAttribute("email", member.getEmail());
			session.setAttribute("addr", member.getAddr());
			session.setAttribute("addr1", member.getAddr1());
			session.setAttribute("addr2", member.getAddr2());
			updateAlert(response, "회원 정보가 수정되었습니다.");

		}

	}

	private void updateAlert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>" + "		location.href='/MyPageForm.do';" + "		alert('" + msg + "');"
				+ "	</script>");
		out.flush();
		out.close();
	}

}
