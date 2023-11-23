package kr.co.project.member.service;

import java.sql.Connection;

import kr.co.project.common.DatabaseConnection;
import kr.co.project.member.dao.MemberDAO;
import kr.co.project.member.model.dto.MemberDTO;

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
		return memberDAO.duplicateId(con, email);
	}

}
