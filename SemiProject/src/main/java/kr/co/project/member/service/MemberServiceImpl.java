package kr.co.project.member.service;

import java.sql.Connection;

import kr.co.project.common.DatabaseConnection;
import kr.co.project.member.dao.MemberDAO;
import kr.co.project.member.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private Connection con;
	private DatabaseConnection dc;
	private MemberDAO memberDAO;

	public MemberServiceImpl() {
		memberDAO = new MemberDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	// 회원가입
	@Override
	public int memberEnroll(MemberDTO memberDTO) {
		return memberDAO.memberEnroll(con, memberDTO);
	}

	// 아이디 중복검사
	@Override
	public boolean duplicateId(String id) {
		return memberDAO.duplicateId(con, id);
	}

	// 이메일 중복검사
	@Override
	public boolean duplicateEmail(String email) {
		return memberDAO.duplicateEmail(con, email);
	}

	// 로그인
	@Override
	public MemberDTO memberSignin(String id) {
		return memberDAO.memberSignin(con, id);
	}

	// 회원 정보 수정
	@Override
	public int memberUpdate(MemberDTO member, String beforeEmail) {
		return memberDAO.memberUpdate(con, member, beforeEmail);
	}

	// 비밀번호 수정
	@Override
	public int pwdUpdate(MemberDTO member) {
		return memberDAO.pwdUpdate(con, member);
	}

	// 회원탈퇴 비밀번호 일치 확인
	@Override
	public MemberDTO selectPwd(String pwd) {
		return memberDAO.selectPwd(con, pwd);
	}

	// 회원 탈퇴
	@Override
	public int memberDelete(String id) {
		return memberDAO.memberDelete(con, id);
	}

	// 마일리지 조회
	public MemberDTO selectMlg(int no) {
		return memberDAO.selectMlg(con, no);
	}

	// 아이디 찾기
	@Override
	public void findId(MemberDTO member) {
		memberDAO.findId(con, member);
	}

	// 비밀번호 찾기
	@Override
	public boolean findPwd(MemberDTO member) {
		return memberDAO.findPwd(con, member);
	}

	@Override
	public void updatePassword(String email, String hashedPassword) {
		memberDAO.updatePassword(con, email, hashedPassword);

	}
}
