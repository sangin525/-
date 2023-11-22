package kr.co.project.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.common.MyBoardPageInfo;

public class BoardDAO {
	private PreparedStatement pstmt;
	
	
	// 내 게시글 목록 불러오기
	public ArrayList<BoardDTO> myBoardList(Connection con, MyBoardPageInfo pi, int no) {

		ArrayList<BoardDTO> list = new ArrayList<>();
		
		String query = "SELECT board_no,"
				+ "			   board_title,"
				+ "			   board_on_date,"
				+ "			   board_views,"
				+ "			   board_answer"
				+ "		FROM board"
				+ "		WHERE board_delete IS NULL"
				+ "		AND M_NO = ?"
				+ "		ORDER BY board_on_date DESC"
				+ "		OFFSET ? ROW FETCH FIRST ? ROWS ONLY";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, no);
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int b_no = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String onDate = rs.getString("BOARD_ON_DATE");
				int views = rs.getInt("BOARD_VIEWS");
				String answer = rs.getString("BOARD_ANSWER");
				
				BoardDTO board = new BoardDTO();
				board.setNo(b_no);
				board.setTitle(title);
				board.setOnDate(onDate);
				board.setViews(views);
				board.setAnswer(answer);
				
				list.add(board);
				
			}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	
	// 내 게시글 수 조회
	public int myListCount(Connection con, int no) {

		// 쿼리작성
		String query = "SELECT count(*) as cnt"
				+ "		FROM board"
				+ "		WHERE board_delete IS NULL"
				+ "		AND M_NO = ?";
		// 실행준비
		try {
			pstmt = con.prepareStatement(query);
			// 물음표 채우고
			pstmt.setInt(1, no);
			// 실행
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}


}
