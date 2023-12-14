package kr.co.project.room.model.service;

import java.util.ArrayList;
import java.util.HashSet;

import kr.co.project.room.model.dto.RoomDTO;

public interface RoomService {

	// 등급에따른 정보조회
	ArrayList<RoomDTO> gradeInfo();
	
	// 세부정보 출력
	public ArrayList<RoomDTO> roomDetail();
	
	// 객실등급활용 가격가져오기
	public RoomDTO getPrice(String roomGrade);
	
	// no 로 마일리지조회
	public RoomDTO searchMLG(int memberNo);

	
	// 예약DB 에 넣기
	public int reserveEnroll(RoomDTO room);

	// nav 에 등급선택에따른 객실정보 가져오기
	public ArrayList<String> navRoomName(String gradeMenu);
	
	// 예약되어있는값이랑 선택한 방,날짜와 같은값이 있는지 확인
	public boolean checkInfo(String Rname, String startDate, String endDate);
	
	// datepicker disabled 주기
	public void disableRoom(String roomGrade, HashSet<String> chkInOut);
	
	// 누적금액, 등급업그레이드
	public void priceGrade(RoomDTO room);
	
	// 결제시 마일리지가 동일한지 검증
	public RoomDTO MLGChkform(int memberMLG, int memberNo);
	
	// **************************상품 시작
	
	// 최초 식사권 정보
	public ArrayList<RoomDTO> foodInfo();
	
	// 상품 클릭시 디테일 사항 가져오기
	public RoomDTO foodDetail(String foodName);
	
	// 장바구니에 담기 
	public int basketEnroll(int memberNo, String foodName, int foodPrice, String foodTime, int foodCount);
	
	// 장바구니에 출력
	public ArrayList<RoomDTO> basketListView(int memberNo);
	
	// 장바구니에서 삭제
	public int basketDelete(int foodBasketNo, int memberNo);
	
	// 결제시 장바구니에서 결제내역 으로 옮기고 삭제
	public int changeReservePay(String payItemNo, int memberNo);
	
	// 결제내용 장바구니
	public ArrayList<RoomDTO> itemPayList(int memberNo);
	
	// 단일결제시 결제장바구니로 등록
	public int oneItemPay(int memberNo, String foodName, int totalPrice, String foodTime, int foodDetailCount);
	
	// value값에따른 item List 가져오기
	public ArrayList<RoomDTO> itemView(String optionValue);
	
	// 장바구니에서 클라이언트 마일리지 등급,퍼센트 가져오기
	public RoomDTO memberMLGGradePercent(int memberNo);
	
	// 장바구니에서 결제시 마일리지, 총 결제금액 증가
	public void basketPayEnrollMLG(int memberNo, int totalPrice, int basketMLG);
	
	
}

