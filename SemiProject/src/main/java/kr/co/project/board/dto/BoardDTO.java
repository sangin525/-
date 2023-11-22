package kr.co.project.board.dto;

public class BoardDTO {

	private String memberNo;
	private String title;
	private String content;

	
	
	
	
//	get,set 사용
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
