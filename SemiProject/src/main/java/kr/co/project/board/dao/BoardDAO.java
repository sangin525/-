package kr.co.project.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDAO {
	
	private PreparedStatement pstmt;
	
	// 문의사항 작성
	public int boardEnroll(Connection con, String title, String content, int memberNo) {
		String query = "INSERT INTO BOARD"
			    + " VALUES(board_seq.nextval," // BOARD_NO
			    + " ?," // M_NO
			    + " ?," // BOARD_TITLE
			    + " ?," // BOARD_CONTENT
			    + " SYSDATE," // BOARD_ON_DATE
			    + " NULL," // BOARD_IN_DATE
			    + " NULL," // BOARD_DELETE
			    + " 0," // BOARD_VIEWS
			    + " 'N'," // BOARD_ANSWER
			    + " NULL," // BOARD_PHOTO
			    + " NULL)"; // BOARD_ROUTE
				
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
				
		return 0;
	}
	//공지사항 작성
	public int noticeEnroll(Connection con, String title, String content, int memberNo) {
		String query = "INSERT INTO NOTICE"
			    + " VALUES(notice_seq.nextval," // BOARD_N_NO
			    + " ?," // M_NO
			    + " ?," // BOARD_N_TITLE
			    + " ?," // BOARD_N_CONTENT
			    + " SYSDATE," // BOARD_N_ON_DATE
			    + " NULL," // BOARD_N_IN_DATE
			    + " NULL," // BOARD_N_DELETE
			    + " 0," // BOARD_N_VIEWS
			    + " NULL," // BOARD_N_PHOTO
			    + " NULL)"; // BOARD_N_ROUTE
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public
	
	
	
	
}
