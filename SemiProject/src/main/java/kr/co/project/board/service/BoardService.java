package kr.co.project.board.service;

import java.util.ArrayList;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.common.MyBoardPageInfo;

public interface BoardService {
	
	// 문의사항 생성
	public int boardEnroll(String title, String content, int memberNo);
	// 공지사항 생성 (Notice)
	public int noticeEnroll(String title, String content, int memberNo);
	// 문의사항 List up
	public ArrayList<BoardDTO> boardList();
	// 공지사항 List up
	public ArrayList<BoardDTO> noticeList();
	//조회수 증가
	public int boardView(int boardNo);
	// 문의사항 상세보기
	public void boardSelect(BoardDTO board);

	
	
	// 내 게시글 수 조회
	public int myListCount(int no);
	
	// 내 게시글 목록 조회
	public ArrayList<BoardDTO> myBoardList(MyBoardPageInfo pi, int no);
	
	
}
