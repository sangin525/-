package kr.co.project.reserve.service;

import java.util.ArrayList;

import kr.co.project.common.MyBoardPageInfo;
import kr.co.project.reserve.dto.MyReserveDTO;

public interface MyReserveService {
	
	// 내 예약 수 조회
	public int myListCount(int no);
	
	// 내 게시글 목록 조회
	public ArrayList<MyReserveDTO> myReserveList(MyBoardPageInfo pi, int no);

}
