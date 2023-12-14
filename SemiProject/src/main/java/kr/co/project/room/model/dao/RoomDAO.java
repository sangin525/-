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
		String query = "SELECT r.ROOM_NO, ri.ROOM_GRADE , ri.ROOM_NAME, ri.ROOM_INFO, r.AMENITY , r.R_NOTICE_1 , r.R_NOTICE_2 ,"
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
				room.setAmenity(rs.getString("AMENITY"));
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
		String query = "SELECT M_NAME, M_PHONE, M_EMAIL, M_ADDR, M_MLG, M_MEMBERSHIP, M_ACCAMOUNT  FROM MEMBER m "
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
				room.setMembership(rs.getString("M_MEMBERSHIP"));
				room.setAccamount(rs.getInt("M_ACCAMOUNT"));
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
				+ "		AND RR.R_CHECK_OUT > ?"
				+ "		OR ri.ROOM_NAME = ?"
				+ "		AND RR.R_CHECK_IN  < ?"
				+ "		AND RR.R_CHECK_OUT > ?"
				+ "		OR ri.ROOM_NAME = ?"
				+ "		AND RR.R_CHECK_IN >= ?"
				+ "		AND RR.R_CHECK_OUT <= ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, Rname);
			pstmt.setString(2, startDate);
			pstmt.setString(3, startDate);
			pstmt.setString(4, Rname);
			pstmt.setString(5, endDate);
			pstmt.setString(6, endDate);
			pstmt.setString(7, Rname);
			pstmt.setString(8, startDate);
			pstmt.setString(9, endDate);
			
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
				+ "		WHERE ri.ROOM_NAME  = ?"
				+ "		ORDER BY rr.R_CHECK_IN ASC ";
		
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
				
				int chkInZero = Integer.parseInt(chkIn[0]);
				int chkInFir = Integer.parseInt(chkIn[1]);
				
				int dateChkIn = Integer.parseInt(chkIn[2]);
				int dateChkOut = Integer.parseInt(chkOut[2]);
				
				for(int i = dateChkIn; i<dateChkOut; i++) {
					String disableDate = chkInZero+"-"+chkInFir+"-"+i;
					chkInOut.add(disableDate);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void priceGrade(Connection con, RoomDTO room) {
		String query = "UPDATE MEMBER SET M_ACCAMOUNT = M_ACCAMOUNT + ? "
				+ "		WHERE M_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, room.getTotalPrice());
			pstmt.setInt(2, room.getMNo());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String priceBring = "SELECT M_ACCAMOUNT FROM MEMBER m "
				+ "			WHERE M_NO = ?";
		
		String gradeUpdate = "UPDATE MEMBER SET M_MEMBERSHIP = ? "
				+ "			WHERE M_NO = ?";
		
		
		try {
			pstmt = con.prepareStatement(priceBring);
			
			pstmt.setInt(1, room.getMNo());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int amount = rs.getInt("M_ACCAMOUNT");
				pstmt = con.prepareStatement(gradeUpdate);
				pstmt.setInt(2, room.getMNo());
				
				if(amount >= 1000000 && amount < 5000000) {
					pstmt.setString(1, "Silver");
					pstmt.executeUpdate();
				}else if(amount >= 5000000 && amount < 10000000) {
					pstmt.setString(1, "Gold");
					pstmt.executeUpdate();
				}else if(amount >= 10000000 && amount < 50000000) {
					pstmt.setString(1, "Platinum");
					pstmt.executeUpdate();
				}else if(amount >= 50000000) {
					pstmt.setString(1, "Black");
					pstmt.executeUpdate();
				}else {
					pstmt.setString(1, "bronze");
					pstmt.executeUpdate();
				}
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	public RoomDTO MLGChkform(Connection con, int memberMLG, int memberNo) {
		String query = "SELECT m.M_MLG  FROM MEMBER m "
				+ "		WHERE m.M_NO = ?";
		RoomDTO room = new RoomDTO();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.setMLG(rs.getInt("M_MLG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return room;
	}

	public ArrayList<RoomDTO> foodInfo(Connection con) {
		String query = "SELECT * FROM FOODGUIDE";
		ArrayList<RoomDTO> room = new ArrayList<RoomDTO>();
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO ro = new RoomDTO();
				ro.setFoodName(rs.getString("FOOD_NAME"));
				ro.setFoodInfo(rs.getString("FOOD_INFO"));
				ro.setFoodPrice(rs.getInt("FOOD_PRICE"));
				ro.setStandardMenu(rs.getString("STANDARDMENU"));
				ro.setFoodPhoto1(rs.getString("FOOD_PHOTO_1"));
				ro.setFoodPhoto2(rs.getString("FOOD_PHOTO_2"));
				ro.setFoodPhoto3(rs.getString("FOOD_PHOTO_3"));
				ro.setFoodTime(rs.getString("FOOD_TIME"));
				
				room.add(ro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	public RoomDTO foodDetail(Connection con, String foodName) {
		String query = "SELECT * FROM FOODGUIDE "
				+ "		WHERE FOOD_NAME = ?";
		
		RoomDTO ro = new RoomDTO();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, foodName);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ro.setFoodName(rs.getString("FOOD_NAME"));
				ro.setFoodInfo(rs.getString("FOOD_INFO"));
				ro.setFoodPrice(rs.getInt("FOOD_PRICE"));
				ro.setStandardMenu(rs.getString("STANDARDMENU"));
				ro.setFoodPhoto1(rs.getString("FOOD_PHOTO_1"));
				ro.setFoodPhoto2(rs.getString("FOOD_PHOTO_2"));
				ro.setFoodPhoto3(rs.getString("FOOD_PHOTO_3"));
				ro.setFoodTime(rs.getString("FOOD_TIME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ro;
	}

	public int basketEnroll(Connection con, int memberNo, String foodName, int foodPrice, String foodTime, int foodCount) {
		String query = "INSERT INTO FOOD_BASKET VALUES(food_basket_no_seq.nextval,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, foodName);
			pstmt.setInt(3, foodCount);
			pstmt.setInt(4, foodPrice);
			pstmt.setString(5, foodTime);
			
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<RoomDTO> basketListView(Connection con, int memberNo) {
		String query = "SELECT * FROM FOOD_BASKET"
				+ "		WHERE M_NO = ?"
				+ "		ORDER BY FOOD_BASKET_NO DESC ";
		ArrayList<RoomDTO> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO room = new RoomDTO();
				
				room.setFoodBasketNo(rs.getInt("FOOD_BASKET_NO"));
				room.setMNo(rs.getInt("M_NO"));
				room.setFoodName(rs.getString("FOOD_NAME"));
				room.setFoodCount(rs.getInt("FOOD_COUNT"));
				room.setFoodPrice(rs.getInt("FOOD_PRICE"));
				room.setFoodTime(rs.getString("FOOD_TIME"));
				list.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int basketDelete(Connection con, int foodBasketNo, int memberNo) {
		String query = "DELETE FROM FOOD_BASKET fb "
				+ "		WHERE M_NO = ?"
				+ "		AND FOOD_BASKET_NO = ? ";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, foodBasketNo);
			
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	
	public int changeReservePay(Connection con, String payItemNo, int memberNo) {
		String memberQuery = "SELECT M_NAME  FROM MEMBER m "
				+ "				WHERE M_NO = ?";
		payItemNo.replaceAll(" ", "");
		String[] arrayPayItemNo = payItemNo.split(",");;
		int result = 0;
		
		RoomDTO room = new RoomDTO();
		try {
			pstmt = con.prepareStatement(memberQuery);
			
			pstmt.setInt(1, memberNo);
			ResultSet memberRs = pstmt.executeQuery();
			
			while(memberRs.next()) {
				room.setMName(memberRs.getString("M_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<arrayPayItemNo.length; i++) {
			
			String basketQuery = "SELECT FOOD_NAME, FOOD_COUNT , FOOD_PRICE , FOOD_TIME  FROM FOOD_BASKET fb "
					+ "				WHERE FOOD_BASKET_NO = ?";
			
			String payBasketQuery = "INSERT INTO ITEM_PAYBASKET ip VALUES("
					+ "		item_payments_no_seq.nextval,?,?,?,?,?,?,default"
					+ ")";
			
			String basketDeleteQuery = "DELETE FROM FOOD_BASKET fb "
					+ "					WHERE FOOD_BASKET_NO  = ?";
			
			
			try {
				pstmt = con.prepareStatement(basketQuery);
				
				pstmt.setInt(1, Integer.parseInt(arrayPayItemNo[i]));
				
				ResultSet basketRs = pstmt.executeQuery();
				
				while(basketRs.next()) {
					String foodName = basketRs.getString("FOOD_NAME");
					int foodCount = basketRs.getInt("FOOD_COUNT");
					int foodPrice = basketRs.getInt("FOOD_PRICE");
					String foodTime = basketRs.getString("FOOD_TIME");
					
					pstmt = con.prepareStatement(payBasketQuery);
					
					pstmt.setInt(1, memberNo);
					pstmt.setString(2, room.getMName());
					pstmt.setString(3, foodName);
					pstmt.setInt(4, foodCount);
					pstmt.setInt(5, foodPrice);
					pstmt.setString(6, foodTime);
					
					pstmt.executeUpdate();
				}
				pstmt = con.prepareStatement(basketDeleteQuery);
				
				pstmt.setInt(1, Integer.parseInt(arrayPayItemNo[i]));
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public ArrayList<RoomDTO> itemPayList(Connection con, int memberNo) {
		String query = "SELECT * FROM ITEM_PAYBASKET ip "
				+ "		WHERE M_NO = ?";
		ArrayList<RoomDTO> array = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO room = new RoomDTO();
				
				room.setItemPaymentsNo(rs.getInt("ITEM_PAYMENTS_NO"));
				room.setMNo(rs.getInt("M_NO"));
				room.setMName(rs.getString("M_NAME"));
				room.setFoodName(rs.getString("ITEM_NAME"));
				room.setFoodCount(rs.getInt("ITEM_COUNT"));
				room.setFoodPrice(rs.getInt("ITEM_PRICE"));
				room.setFoodTime(rs.getString("ITEM_OPTION"));
				room.setItemPayWay(rs.getString("ITEM_PAYWAY"));
				
				array.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	public int oneItemPay(Connection con, int memberNo, String foodName, int totalPrice, String foodTime,
			int foodDetailCount) {
		
		String memberQuery = "SELECT M_NAME  FROM MEMBER m "
				+ "				WHERE M_NO = ?";
		
		String payBasketQuery = "INSERT INTO ITEM_PAYBASKET ip VALUES("
				+ "		item_payments_no_seq.nextval,?,?,?,?,?,?,default"
				+ ")";
		
		int result = 0;
		RoomDTO room = new RoomDTO();
		try {
			pstmt = con.prepareStatement(memberQuery);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				room.setMName(rs.getString("M_NAME"));
			}
			pstmt = con.prepareStatement(payBasketQuery);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, room.getMName());
			pstmt.setString(3, foodName);
			pstmt.setInt(4, foodDetailCount);
			pstmt.setInt(5, totalPrice);
			pstmt.setString(6, foodTime);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<RoomDTO> itemView(Connection con, String optionValue) {
		String query = "SELECT * FROM FOODGUIDE i "
				+ "		WHERE FOOD_TIME  = ?";
		
		ArrayList<RoomDTO> array = new ArrayList<>();
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, optionValue);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDTO room = new RoomDTO();
				
				room.setFoodName(rs.getString("FOOD_NAME"));
				room.setFoodInfo(rs.getString("FOOD_INFO"));
				room.setFoodPrice(rs.getInt("FOOD_PRICE"));
				room.setStandardMenu(rs.getString("STANDARDMENU"));
				room.setFoodPhoto1(rs.getString("FOOD_PHOTO_1"));
				room.setFoodPhoto2(rs.getString("FOOD_PHOTO_2"));
				room.setFoodPhoto3(rs.getString("FOOD_PHOTO_3"));
				room.setFoodTime(rs.getString("FOOD_TIME"));
				
				array.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	public RoomDTO memberMLGGradePercent(Connection con, int memberNo) {
		String query = "SELECT M_MEMBERSHIP  FROM MEMBER m "
				+ "		WHERE M_NO = ?";
		
		RoomDTO room = new RoomDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				room.setMembership(rs.getString("M_MEMBERSHIP"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	public void basketPayEnrollMLG(Connection con, int memberNo, int totalPrice, int basketMLG) {
		String query = "UPDATE MEMBER SET M_MLG = M_MLG + ?,"
				+ "				M_ACCAMOUNT = M_ACCAMOUNT + ?"
				+ "		WHERE M_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, basketMLG);
			pstmt.setInt(2, totalPrice);
			pstmt.setInt(3, memberNo);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
