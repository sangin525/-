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
	private String roomNotice1;
	private String roomNotice2;
	private String roomNotice3;
	
	//예약정보
	private int RNo;
	private int RPersonCount;
	private String RChkIn;
	private String RChkOut;
	private int RCount;
	
	// 고객정보 

	private int MNo;

	private String MName;
	private String MPhone;
	private String MEmail;
	private String MAddr;
	private int MLG;
	private String membership;
	private int accamount;
	  
	// 예약창에서 받아와서 DB 에 넣을 변수
	private String memberName;
	private int totalPrice;
	private String memberPhone;
	private int addMLG;
	private int minMLG;
	
	// e-SHOP 예약관련
	private int foodBasketNo;
	private String foodInfo;
	private String standardMenu;
	private String foodPhoto1;
	private String foodPhoto2;
	private String foodPhoto3;
	
	// 예약관련인데 앞에 food대신 item이랑 동일
	private String foodName;
	private int foodCount;
	private int foodPrice;
	// Time = option 과 동일
	private String foodTime;
	
	// 결제내역페이지 사용
	private int itemPaymentsNo;
	private String itemPayWay;

	
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
	public int getMNo() {
		return MNo;
	}
	public void setMNo(int mNo) {
		MNo = mNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public void setRoomNotice(String roomNotice) {
		this.roomNotice = roomNotice;
	}
	public String getRoomNotice1() {
		return roomNotice1;
	}
	public void setRoomNotice1(String roomNotice1) {
		this.roomNotice1 = roomNotice1;
	}
	public String getRoomNotice2() {
		return roomNotice2;
	}
	public void setRoomNotice2(String roomNotice2) {
		this.roomNotice2 = roomNotice2;
	}
	public String getRoomNotice3() {
		return roomNotice3;
	}
	public void setRoomNotice3(String roomNotice3) {
		this.roomNotice3 = roomNotice3;
	}
	public int getRNo() {
		return RNo;
	}
	public void setRNo(int rNo) {
		RNo = rNo;
	}
	public int getRPersonCount() {
		return RPersonCount;
	}
	public void setRPersonCount(int rPersonCount) {
		RPersonCount = rPersonCount;
	}
	public String getRChkIn() {
		return RChkIn;
	}
	public void setRChkIn(String rChkIn) {
		RChkIn = rChkIn;
	}
	public String getRChkOut() {
		return RChkOut;
	}
	public void setRChkOut(String rChkOut) {
		RChkOut = rChkOut;
	}
	public int getRCount() {
		return RCount;
	}
	public void setRCount(int rCount) {
		RCount = rCount;
	}
	public String getMName() {
		return MName;
	}
	public String getMPhone() {
		return MPhone;
	}
	public String getMEmail() {
		return MEmail;
	}
	public String getMAddr() {
		return MAddr;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public void setMPhone(String mPhone) {
		MPhone = mPhone;
	}
	public void setMEmail(String mEmail) {
		MEmail = mEmail;
	}
	public void setMAddr(String mAddr) {
		MAddr = mAddr;
	}
	public int getMLG() {
		return MLG;
	}
	public void setMLG(int mLG) {
		MLG = mLG;
	}
	
	public int getAddMLG() {
		return addMLG;
	}
	public void setAddMLG(int addMLG) {
		this.addMLG = addMLG;
	}
	public int getMinMLG() {
		return minMLG;
	}
	public void setMinMLG(int minMLG) {
		this.minMLG = minMLG;
	}
	public String getMembership() {
		return membership;
	}
	public int getAccamount() {
		return accamount;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public void setAccamount(int accamount) {
		this.accamount = accamount;
	}
	public int getFoodBasketNo() {
		return foodBasketNo;
	}
	public void setFoodBasketNo(int foodBasketNo) {
		this.foodBasketNo = foodBasketNo;
	}
	public String getFoodName() {
		return foodName;
	}
	public String getFoodInfo() {
		return foodInfo;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public String getStandardMenu() {
		return standardMenu;
	}
	public String getFoodPhoto1() {
		return foodPhoto1;
	}
	public String getFoodPhoto2() {
		return foodPhoto2;
	}
	public String getFoodPhoto3() {
		return foodPhoto3;
	}
	public String getFoodTime() {
		return foodTime;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setFoodInfo(String foodInfo) {
		this.foodInfo = foodInfo;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public void setStandardMenu(String standardMenu) {
		this.standardMenu = standardMenu;
	}
	public void setFoodPhoto1(String foodPhoto1) {
		this.foodPhoto1 = foodPhoto1;
	}
	public void setFoodPhoto2(String foodPhoto2) {
		this.foodPhoto2 = foodPhoto2;
	}
	public void setFoodPhoto3(String foodPhoto3) {
		this.foodPhoto3 = foodPhoto3;
	}
	public void setFoodTime(String foodTime) {
		this.foodTime = foodTime;
	}
	public int getItemPaymentsNo() {
		return itemPaymentsNo;
	}
	public String getItemPayWay() {
		return itemPayWay;
	}
	public void setItemPaymentsNo(int itemPaymentsNo) {
		this.itemPaymentsNo = itemPaymentsNo;
	}
	public void setItemPayWay(String itemPayWay) {
		this.itemPayWay = itemPayWay;
	}
	
	
}
