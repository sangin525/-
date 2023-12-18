package kr.co.project.board.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.project.board.dto.BoardDTO;
import kr.co.project.board.page.BoardPageInfo;
import kr.co.project.board.page.ReviewPageInfo;
import kr.co.project.common.MyBoardPageInfo;

public interface BoardService {
	
	// 문의사항 생성
	public int boardEnroll(String title, String content, int memberNo, String fileName, String uploadDirectory, String categoryHidden, String secretBox);
	// 문의사항 List up
	public ArrayList<BoardDTO> boardList(BoardPageInfo pi);
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
	// 문의사항 카테고리 분류
	public ArrayList<BoardDTO> boardCategoryList(BoardPageInfo pi, String category);
	// 문의사항 카테고리 페이징 전체 게시글 수
	public int boardCategoryListCount(String category);
	// 문의사항 검색
	public ArrayList<BoardDTO> boardSearchList(BoardPageInfo pi, String SearchName);
	// 문의사항 검색 페이징 전체 게시글 수
	public int boardSearchCount(String SearchName);
	
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
	// 리뷰 사진리스트 조회
	public List<String> getReviewPhotos(int reviewNo);
	// 리뷰 삭제
	public int reviewDelete(int reviewNo);
	// 리뷰 업데이트
	public int reviewUpdate(BoardDTO board, int reviewNo);

}
