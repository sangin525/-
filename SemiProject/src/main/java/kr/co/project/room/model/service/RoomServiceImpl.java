package kr.co.project.room.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;

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


	public boolean checkInfo(String Rname, String startDate, String endDate) {
		
		return roomDAO.checkInfo(con, Rname, startDate, endDate);
	}


	public void disableRoom(String roomGrade, HashSet<String> chkInOut) {
		
		roomDAO.disableRoom(con, roomGrade, chkInOut);
	}


	public void priceGrade(RoomDTO room) {
		roomDAO.priceGrade(con, room);
	}


	public RoomDTO MLGChkform(int memberMLG, int memberNo) {
		return roomDAO.MLGChkform(con, memberMLG, memberNo);
	}


	public ArrayList<RoomDTO> foodInfo() {
		return roomDAO.foodInfo(con);
	}


	public RoomDTO foodDetail(String foodName) {
		return roomDAO.foodDetail(con, foodName);
	}


	public int basketEnroll(int memberNo, String foodName, int foodPrice, String foodTime, int foodCount) {
		return roomDAO.basketEnroll(con, memberNo, foodName, foodPrice, foodTime, foodCount);
	}


	public ArrayList<RoomDTO> basketListView(int memberNo) {
		return roomDAO.basketListView(con, memberNo);
	}


	public int basketDelete(int foodBasketNo, int memberNo) {
		return roomDAO.basketDelete(con, foodBasketNo, memberNo);
	}


	public int changeReservePay(String payItemNo, int memberNo) {
		return roomDAO.changeReservePay(con, payItemNo, memberNo);
	}


	public ArrayList<RoomDTO> itemPayList(int memberNo) {
		return roomDAO.itemPayList(con, memberNo);
	}


	public int oneItemPay(int memberNo, String foodName, int totalPrice, String foodTime, int foodDetailCount) {
		return roomDAO.oneItemPay(con, memberNo, foodName, totalPrice, foodTime, foodDetailCount);
	}


	public ArrayList<RoomDTO> itemView(String optionValue) {
		return roomDAO.itemView(con, optionValue);
	}


	public RoomDTO memberMLGGradePercent(int memberNo) {
		return roomDAO.memberMLGGradePercent(con, memberNo);
	}


	public void basketPayEnrollMLG(int memberNo, int totalPrice, int basketMLG) {
		roomDAO.basketPayEnrollMLG(con, memberNo, totalPrice, basketMLG);
	}


}
