package kr.co.project.room.model.service;

import java.util.ArrayList;

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
	
}

