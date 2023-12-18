package kr.co.project.member.controller;

import java.io.IOException;
import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import kr.co.project.member.dto.MemberDTO;
import kr.co.project.member.service.MemberService;
import kr.co.project.member.service.MemberServiceImpl;
import kr.co.project.member.util.EmailSender;

@WebServlet("/FindPwd.do")
public class FindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			String name = request.getParameter("name");
			String id = request.getParameter("id");

			System.out.println("Name: " + name + ", id: " + id);

			if (isNullOrEmpty(name) || isNullOrEmpty(id)) {
				request.setAttribute("message", "유효하지 않은 이름 또는 이메일입니다.");
			} else {
				MemberService memberService = new MemberServiceImpl();

				MemberDTO member = new MemberDTO();

				member.setName(name);
				member.setId(id);
				System.out.println(member.getName());
				System.out.println(member.getId());
				if (memberService.findPwd(member)) {
					String newPassword = generateRandomPassword();
					String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

					System.out.println("hash : " + hashedPassword);
					memberService.updatePassword(id, hashedPassword);

					try {
						EmailSender.sendNewPassword(member.getEmail(), newPassword);
						request.setAttribute("message", "새로운 임시 비밀번호가 이메일로 전송되었습니다.");
					} catch (MessagingException e) {
						handleEmailException(request, e);
					}

				} else {
					request.setAttribute("message", "유효하지 않은 이름 또는 이메일입니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/forgotPassword.jsp");
		dispatcher.forward(request, response);
	}

	private String generateRandomPassword() {
		String combinedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()_+-=[]|,./?><";
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i < 12; i++) {
			int randomIndex = secureRandom.nextInt(combinedChars.length());
			password.append(combinedChars.charAt(randomIndex));
		}

		return password.toString();
	}

	private boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private void handleEmailException(HttpServletRequest request, MessagingException e) {
		e.printStackTrace();
		request.setAttribute("message", "이메일 전송에 실패했습니다.");
	}
}
