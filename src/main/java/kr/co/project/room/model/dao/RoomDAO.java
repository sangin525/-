package kr.co.project.room.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				
				System.out.println("asdasd");
				
				room.add(ro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return room;
	}

	
	
	
}
