package kr.co.project.reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.project.common.MyBoardPageInfo;
import kr.co.project.reserve.dto.MyReserveDTO;

public class MyReserveDAO {
	private PreparedStatement pstmt;

	public ArrayList<MyReserveDTO> myReserveList(Connection con, MyBoardPageInfo pi, int no) {
		
		ArrayList<MyReserveDTO> list = new ArrayList<>();
		
		String query = "SELECT r.r_no,"
				+ "				r.r_per_no,"
				+ "				r.r_check_in,"
				+ "				r.r_check_out,"
				+ "				r.r_count,"
				+ "				m.m_name,"
				+ "				r.room_no"
				+ "		FROM ROOM_RESERVE r"
				+ "		JOIN MEMBER m"
				+ "		ON r.m_no = m.m_no"
				+ "		WHERE r.M_NO = ?"
				+ "		ORDER BY r_no ASC"
				+ "		OFFSET ? ROW FETCH FIRST ? ROWS ONLY";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, no);
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int r_no = rs.getInt("R_NO");
				int per_no = rs.getInt("R_PER_NO");
				String checkIn = rs.getString("R_CHECK_IN");
				String checkOut = rs.getString("R_CHECK_OUT");
				int count = rs.getInt("R_COUNT");
				String m_name = rs.getString("M_NAME");
				int room_no = rs.getInt("ROOM_NO");
				
				MyReserveDTO reserve = new MyReserveDTO();
				reserve.setR_no(r_no);
				reserve.setPer_no(per_no);
				reserve.setCheckIn(checkIn);
				reserve.setCheckOut(checkOut);
				reserve.setCount(count);
				reserve.setM_name(m_name);
				reserve.setRoom_no(room_no);
				
				list.add(reserve);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// 내 예약 수 조회
	public int myListCount(Connection con, int no) {
		String query = "SELECT count(*) as cnt"
				+ "		FROM room_reserve"
				+ "		WHERE M_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
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
