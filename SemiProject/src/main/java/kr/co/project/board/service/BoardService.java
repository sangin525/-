package kr.co.project.board.service;

import java.util.ArrayList;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.common.MyBoardPageInfo;

public interface BoardService {

	// 내 게시글 수 조회
	public int myListCount(int no);
	
	// 내 게시글 목록 조회
	public ArrayList<BoardDTO> myBoardList(MyBoardPageInfo pi, int no);
	
	
}
