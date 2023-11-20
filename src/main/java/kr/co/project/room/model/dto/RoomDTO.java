package kr.co.project.room.model.dto;

public class RoomDTO {

	// 객실정보
	private int roomNo;
	private String roomName;
	private String roomInfo;
	private String photoPath; // 하나로하고 불러올때 배열로하기 가능?
	private String photoPath1;
	private String photoPath2;
	
	private String roomGrade;
	// 객실등급 가격
	private String weekdayPrice;
	private String weekendPrice;
	private	int roomMin;
	private int roomMax;
	private String roomArea;
	
	// 상세페이지
	private String amenity;
	private String roomNotice; // 안내사항 배열로만들어서 가져오기
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getPhotoPath1() {
		return photoPath1;
	}
	public void setPhotoPath1(String photoPath1) {
		this.photoPath1 = photoPath1;
	}
	public String getPhotoPath2() {
		return photoPath2;
	}
	public void setPhotoPath2(String photoPath2) {
		this.photoPath2 = photoPath2;
	}
	public String getRoomGrade() {
		return roomGrade;
	}
	public void setRoomGrade(String roomGrade) {
		this.roomGrade = roomGrade;
	}
	public String getWeekdayPrice() {
		return weekdayPrice;
	}
	public void setWeekdayPrice(String weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	public String getWeekendPrice() {
		return weekendPrice;
	}
	public void setWeekendPrice(String weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	public int getRoomMin() {
		return roomMin;
	}
	public void setRoomMin(int roomMin) {
		this.roomMin = roomMin;
	}
	public int getRoomMax() {
		return roomMax;
	}
	public void setRoomMax(int roomMax) {
		this.roomMax = roomMax;
	}
	public String getRoomArea() {
		return roomArea;
	}
	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}
	public String getAmenity() {
		return amenity;
	}
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
	public String getRoomNotice() {
		return roomNotice;
	}
	public void setRoomNotice(String roomNotice) {
		this.roomNotice = roomNotice;
	}
	
	
}
