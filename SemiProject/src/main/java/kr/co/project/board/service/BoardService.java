package kr.co.project.board.service;

import java.util.ArrayList;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.ReviewPageInfo;
import kr.co.project.common.MyBoardPageInfo;

public interface BoardService {
	
	// 문의사항 생성
	public int boardEnroll(String title, String content, int memberNo, String fileName, String uploadDirectory, String categoryHidden);
	// 공지사항 생성 (Notice)
	public int noticeEnroll(String title, String content, int memberNo);
	// 문의사항 List up
	public ArrayList<BoardDTO> boardList(BoardPageInfo pi);
	// 공지사항 List up
	public ArrayList<BoardDTO> noticeList();
	//조회수 증가
	public int boardView(int boardNo);
	// 문의사항 상세보기
	public void boardSelect(BoardDTO board);
	// 문의사항 상세보기 수정
	public int boardUpdate(BoardDTO board);
	// 문의사항 삭제
	public int boardDelete(int BoardNo);
	// 문의사항 전체 게시글 수
	public int boardListCount();
	// 문의사항 답변 추가
	public int answerEnroll(String answer,String name, int boardNo);
	// 문의사항 답변 추가 시 답변 여부 변경
	public int answerUpdate(int boardNo);
	// 문의사항 답변 수정
	public int answerDetailUpdate(String content, int answerNo);
	// 문의사항 답변 삭제
	public int answerDelete(int answerNo);
	// 문의사항 답변 삭제 시 답변 여부 변경
	public int answerDeleteUpdate(int boardNo);
	
	
	// 마이페이지
	// 내 게시글 수 조회
	public int myListCount(int no);
	// 내 게시글 목록 조회
	public ArrayList<BoardDTO> myBoardList(MyBoardPageInfo pi, int no);
	
	// 리뷰 작성
	public int reviewEnroll(BoardDTO board, int no);
	// 리뷰 List up
	public ArrayList<BoardDTO> reviewList(ReviewPageInfo pi);
	// 전체 리뷰 수 조회
	public int reviewListCount();

}
