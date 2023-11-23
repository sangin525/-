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
	
	// 로그인
	@Override
	public MemberDTO memberSignin(String id, String pwd) {
		return memberDAO.memberSignin(con, id, pwd);
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
	
}
