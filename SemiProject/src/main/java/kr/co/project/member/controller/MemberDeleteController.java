package kr.co.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberServiceImpl;


@WebServlet("/MemberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberDeleteController() {
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
		// 값 가져오기
		String pwd = request.getParameter("deletePwd");
		
		
		
		// 서비스 객체 생성
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberDTO member = memberService.selectPwd(pwd);
		
		if(!pwd.equals(member.getPwd())) {
			selectPwdAlert(response, "비밀번호가 틀립니다.");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/MemberDeleteDetailForm.do");         
			view.forward(request, response);
		}
		
	
		
		
	}
	private void selectPwdAlert(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>" + "		location.href='/MemberDeleteForm.do';" + "		alert('" + msg + "');"
				+ "	</script>");
		out.flush();
		out.close();
	}
}
