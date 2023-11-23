package kr.co.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;


@WebServlet("/PasswordUpdate.do")
public class PasswordUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PasswordUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1. 값 가져오기( 현재 비밀번호, 새 비밀번호)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pwd = request.getParameter("password");
		String newPwd = request.getParameter("newPassword");
		String pwdChk = request.getParameter("passwordChk");
		
		
		//DTO 객체 생성
		MemberDTO member = new MemberDTO(id, pwd, newPwd);
		
		
		// 패스워드 유효성 검사
				String pwdPattern = "^(?=.*[a-zA-Z])(?=.*[@$!%*?&\\#])[A-Za-z\\d@$!%*?&\\#]{8,20}$";
				Pattern passwordPattern = Pattern.compile(pwdPattern);
				Matcher passwordMatcher = passwordPattern.matcher(newPwd);

				//비번 유효성 검사 통과하면 비밀번호 수정 가능하게
				// 비번 틀렷을 때 : alert '비밀번호가 정책에 맞지 않습니다.'
				if (newPwd.equals(pwdChk)  && passwordMatcher.matches() && !newPwd.equals(pwd)) {
					// 비밀번호 변경 진행
					// 서비스 객체 생성
					MemberServiceImpl memberService = new MemberServiceImpl();
					int result = memberService.pwdUpdate(member);
					System.out.println(result);
					if (result == 0) {
						System.out.println(result);

						PwdUpdateAlert(response, "비밀번호 수정에 실패했습니다.");
						System.out.println(result);

					} else {
						System.out.println(result);

						RequestDispatcher view = request.getRequestDispatcher("/views/member/mypage/MyPage.jsp");
						view.forward(request, response);
						System.out.println(result);

					}
				} else if (!passwordMatcher.matches()) {
					 PwdUpdateAlert(response, "비밀번호가 정책에 맞지 않습니다.");
				} else if (newPwd.equals(pwdChk)) {
					PwdUpdateAlert(response, "비밀번호가 일치하지 않습니다.");
					}
				}

	private void PwdUpdateAlert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>" + "		location.href='/PwdUpdateForm.do';" + "		alert('" + msg + "');"
				+ "	</script>");
		out.flush();
		out.close();
	}

}

