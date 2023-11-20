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
}
