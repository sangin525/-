package kr.co.project.board.service;

public interface BoardService {
	
	// 문의사항 생성
	public int boardEnroll(String title, String content, int memberNo);
	// 공지사항 생성 (Notice)
	public int noticeEnroll(String title, String content, int memberNo);
}
