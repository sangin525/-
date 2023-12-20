package kr.co.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;

@WebServlet("/Signin.do")
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SigninController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		// 1. 유저가 입력한 데이터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");

		// 2. 받은 데이터(아이디, 패스워드)가 일치하는지
		MemberServiceImpl memberService = new MemberServiceImpl();

		// 암호화된 패스워드 조회
		MemberDTO member = memberService.memberSignin(id);

		// 암호화된 패스워드 확인
//				if(BCrypt.checkpw("사용자가 입력한 패스워드", "암호화된 패스워드")) {
		if (BCrypt.checkpw(pwd, member.getPwd())) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

		// 3. 일치하면 세션에 저장 후 홈페이지로 보냄

		// member.getId() == NULL
		// Objects.isNull(member.getId())
		if (Objects.isNull(member.getId()) || !Objects.isNull(member.getDeleteDate())
				|| !BCrypt.checkpw(pwd, member.getPwd())) { // 로그인 실패
			SigninAlert(response, "아이디 또는 비밀번호를 확인해 주세요.");
		} else { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("no", member.getNo());
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			session.setAttribute("phone", member.getPhone());
			session.setAttribute("email", member.getEmail());
			session.setAttribute("addr", member.getAddr());
			session.setAttribute("addr1", member.getAddr1());
			session.setAttribute("addr2", member.getAddr2());
			session.setAttribute("birth", member.getBirth());
			session.setAttribute("mlg", member.getMlg());
			session.setAttribute("admin", member.getAdmin());
			session.setAttribute("membership", member.getMembership());
			session.setAttribute("accamount", member.getAccAmount());

			RequestDispatcher view = request.getRequestDispatcher("/");
			view.forward(request, response);
		}

	}

	private void SigninAlert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>" + "		location.href='/';" + "		alert('" + msg + "');" + "	</script>");
		out.flush();
		out.close();
	}
}
