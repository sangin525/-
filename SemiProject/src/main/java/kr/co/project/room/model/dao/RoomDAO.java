package kr.co.project.room.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import kr.co.project.room.model.dto.RoomDTO;

public class RoomDAO {

	private PreparedStatement pstmt;
	
	public ArrayList<RoomDTO> gradeInfo(Connection con) {
		String query = "SELECT DISTINCT  rgi.ROOM_GRADE  , WEEKDAY_PRICE , WEEKEND_PRICE , "
				+ "		ROOM_MIN , ROOM_MAX , ri.ROOM_PHOTO_1, "
				+ "	  	ri.ROOM_PHOTO_2 , ri.ROOM_PHOTO_3  FROM ROOM_GRADE_INFO rgi  "
				+ "		JOIN ROOM_INFO ri  "
				+ "		ON rgi.ROOM_GRADE = ri.ROOM_GRADE "
				+ "		ORDER BY WEEKDAY_PRICE ASC";
		ArrayList<RoomDTO> room = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO ro = new RoomDTO();
				ro.setRoomGrade(rs.getString("ROOM_GRADE"));
				ro.setWeekdayPrice(rs.getString("WEEKDAY_PRICE"));
				ro.setWeekendPrice(rs.getString("WEEKEND_PRICE"));
				ro.setRoomMin(rs.getInt("ROOM_MIN"));
				ro.setRoomMax(rs.getInt("ROOM_MAX"));
				ro.setPhotoPath(rs.getString("ROOM_PHOTO_1"));
				ro.setPhotoPath1(rs.getString("ROOM_PHOTO_2"));
				ro.setPhotoPath2(rs.getString("ROOM_PHOTO_3"));
				
				room.add(ro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return room;
	}

	public ArrayList<RoomDTO> roomDetail(Connection con) {
		String query = "SELECT r.ROOM_NO, ri.ROOM_GRADE , ri.ROOM_NAME, ri.ROOM_INFO, r.R_NOTICE_1 , r.R_NOTICE_2 ,"
				+ "		r.R_NOTICE_3 , r.R_NOTICE_4 FROM ROOMGUIDE r"
				+ "		JOIN ROOM_INFO ri "
				+ "		ON r.ROOM_NO = ri.ROOM_NO ";
		ArrayList<RoomDTO> roomDetail = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO room = new RoomDTO();
				
				room.setRoomNo(rs.getInt("ROOM_NO"));
				room.setRoomGrade(rs.getString("ROOM_GRADE"));
				room.setRoomName(rs.getString("ROOM_NAME"));
				room.setRoomInfo(rs.getString("ROOM_INFO"));
				room.setRoomNotice(rs.getString("R_NOTICE_1"));
				room.setRoomNotice1(rs.getString("R_NOTICE_2"));
				room.setRoomNotice2(rs.getString("R_NOTICE_3"));
				room.setRoomNotice3(rs.getString("R_NOTICE_4"));
				roomDetail.add(room);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomDetail;
	}

	public RoomDTO getPrice(Connection con, String roomGrade) {
		String query = "SELECT WEEKDAY_PRICE , WEEKEND_PRICE "
				+ "		FROM ROOM_GRADE_INFO rgi "
				+ "		WHERE ROOM_GRADE = ?";
		RoomDTO room = new RoomDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, roomGrade);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.setWeekdayPrice(rs.getString("WEEKDAY_PRICE"));
				room.setWeekendPrice(rs.getString("WEEKEND_PRICE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	public RoomDTO searchMLG(Connection con, int memberNo) {
		String query = "SELECT M_NAME, M_PHONE, M_EMAIL, M_ADDR, M_MLG  FROM MEMBER m "
					+ 	"WHERE M_NO = ?";
		
		RoomDTO room = new RoomDTO();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.setMName(rs.getString("M_NAME"));
				room.setMPhone(rs.getString("M_PHONE"));
				room.setMEmail(rs.getString("M_EMAIL"));
				room.setMAddr(rs.getString("M_ADDR"));
				room.setMLG(rs.getInt("M_MLG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}


	public int reserveEnroll(Connection con, RoomDTO room) {
		// 예약DB에 객실 번호가 있어서 객실이름 가지고 조회해서 값 가져오고나서 넣어야함
		String selectRNo = "SELECT ROOM_NO  FROM ROOM_INFO ri "
				+ 			"WHERE ROOM_NAME = ?";
		
		try {
			pstmt = con.prepareStatement(selectRNo);
			
			pstmt.setString(1, room.getRoomName());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.setRoomNo(rs.getInt("ROOM_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 결제시 마일리지적립, 마일리지 사용시  마일리지 증감
		String addMinMLG = "UPDATE MEMBER "
				+ "		 SET M_MLG  = M_MLG + ? - ? "
				+ "		WHERE M_NO = ? ";
		try {
			pstmt = con.prepareStatement(addMinMLG);
			
			pstmt.setInt(1, room.getAddMLG());
			pstmt.setInt(2, room.getMinMLG());
			pstmt.setInt(3, room.getMNo());
			
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		// 예약정보에 값 넣기
		String query = "INSERT INTO ROOM_RESERVE rr values("
				+ "			room_reserve_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
				
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, room.getMNo());
			pstmt.setString(2, room.getRChkIn());
			pstmt.setString(3, room.getRChkOut());
			pstmt.setInt(4, room.getRCount());
			pstmt.setInt(5, room.getMNo());
			pstmt.setInt(6, room.getRoomNo());
			pstmt.setInt(7, room.getTotalPrice());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}

	public ArrayList<String> navRoomName(Connection con, String gradeMenu) {
		String query = "SELECT ROOM_NAME  FROM ROOM_INFO ri "
				+ 		"WHERE ROOM_GRADE = ?";
		ArrayList<String> room = new ArrayList<>();
		String name;
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, gradeMenu);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.add(rs.getString("ROOM_NAME"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	public boolean checkInfo(Connection con, String Rname, String startDate, String endDate) {
		String query = "SELECT ri.ROOM_NAME , R_CHECK_IN, R_CHECK_OUT FROM ROOM_RESERVE rr "
				+ "		JOIN ROOM_INFO ri "
				+ "		ON rr.ROOM_NO = ri.ROOM_NO "
				+ "		WHERE ri.ROOM_NAME = ?"
				+ "		AND RR.R_CHECK_IN <= ?"
				+ "		AND RR.R_CHECK_OUT > ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, Rname);
			pstmt.setString(2, startDate);
			pstmt.setString(3, startDate);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void disableRoom(Connection con, String roomGrade, HashSet<String> chkInOut) {
		
		String query = "SELECT rr.R_CHECK_IN , rr.R_CHECK_OUT  FROM ROOM_RESERVE rr "
				+ "		JOIN ROOM_INFO ri "
				+ "		ON ri.ROOM_NO = rr.ROOM_NO "
				+ "		JOIN ROOM_GRADE_INFO rgi "
				+ "		ON ri.ROOM_GRADE = rgi.ROOM_GRADE "
				+ "		WHERE rgi.ROOM_GRADE = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, roomGrade);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String chkInSt = rs.getString("R_CHECK_IN");
				String chkOutSt = rs.getString("R_CHECK_OUT");
				chkInSt = chkInSt.replaceAll("00:00:00", "");
				chkOutSt = chkOutSt.replaceAll("00:00:00", "");
				
				chkInSt = chkInSt.replaceAll(" ", "");
				chkOutSt = chkOutSt.replaceAll(" ", "");
				
				String[] chkIn = chkInSt.split("-");
				String[] chkOut = chkOutSt.split("-");
				
				int dateChkIn = Integer.parseInt(chkIn[2]);
				int dateChkOut = Integer.parseInt(chkOut[2]);
				
				for(int i = dateChkIn; i<dateChkOut; i++) {
					String disableDate = chkIn[0]+"-"+chkIn[1]+"-"+i;
					chkInOut.add(disableDate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
