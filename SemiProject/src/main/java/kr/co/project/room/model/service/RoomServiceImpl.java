package kr.co.project.room.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.project.common.DatabaseConnection;
import kr.co.project.room.model.dao.RoomDAO;
import kr.co.project.room.model.dto.RoomDTO;

public class RoomServiceImpl implements RoomService {
	private DatabaseConnection dc;
	private Connection con;
	private RoomDAO roomDAO;
	
	public RoomServiceImpl() {
		roomDAO = new RoomDAO();
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	
	public ArrayList<RoomDTO> gradeInfo() {
		
		return roomDAO.gradeInfo(con);
	}




	public ArrayList<RoomDTO> roomDetail() {
		return roomDAO.roomDetail(con);
	}


	public RoomDTO getPrice(String roomGrade) {
		return roomDAO.getPrice(con, roomGrade);
	}


	public RoomDTO searchMLG(int memberNo) {
		return roomDAO.searchMLG(con, memberNo);
	}


	public int reserveEnroll(RoomDTO room) {
		
		return roomDAO.reserveEnroll(con, room);
	}


	public ArrayList<String> navRoomName(String gradeMenu) {
		return roomDAO.navRoomName(con, gradeMenu);
	}


}
