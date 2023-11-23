package kr.co.project.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.project.member.model.dto.MemberDTO;

public class MemberDAO {
	private PreparedStatement pstmt;

	// 회원가입
	public int memberEnroll(Connection con, MemberDTO memberDTO) {
		String query = "INSERT INTO member VALUES(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?,?,?,sysdate,NULL,500,?)";

		try {
			// 2. 쿼리 사용할 준비
			pstmt = con.prepareStatement(query);

			// 3. 물음표 있으면 쿼리 완성
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getBirth());
			pstmt.setString(5, memberDTO.getEmail());
			pstmt.setString(6, memberDTO.getPhone());
			pstmt.setString(7, memberDTO.getAddr());
			pstmt.setString(8, memberDTO.getAddr1());
			pstmt.setString(9, memberDTO.getAddr2());
			pstmt.setString(10, "N");

			System.out.println(memberDTO.getName());

			// 4. 쿼리 실행
			int result = pstmt.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 아이디 중복 검사
	public boolean duplicateId(Connection con, String id) {
		String query = "SELECT M_ID FROM member" + "		WHERE M_ID = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			// 쿼리가 조회된 결과(ResultSet)가 있다면 true
			// 없다면 false
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// 이메일 중복 검사
	public boolean duplicateEmail(Connection con, String email) {
		String query = "SELECT M_EMAIL FROM member" + "		WHERE M_EMAIL = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			// 쿼리가 조회된 결과(ResultSet)가 있다면 true
			// 없다면 false
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
