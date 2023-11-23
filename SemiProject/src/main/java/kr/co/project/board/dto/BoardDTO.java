package kr.co.project.board.dto;

public class BoardDTO {
	
	private int no; // 게시글 번호
	private int m_No; // 작성자 번호
	private String title; // 제목
	private String content; // 내용
	private String onDate; //작성일
	private String inDate; //수정일
	private String delete; // 삭제일
	private int views; // 조회수
	private String photo; // 사진이름
	private String route; // 사진경로
	private String answer; // 답변여부
	
	
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getM_No() {
		return m_No;
	}
	public void setM_No(int m_No) {
		this.m_No = m_No;
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
	public String getOnDate() {
		return onDate;
	}
	public void setOnDate(String onDate) {
		this.onDate = onDate;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public BoardDTO(int no, int m_No, String title, String content, String onDate, String inDate, String delete,
			int views, String photo, String route, String answer) {
		super();
		this.no = no;
		this.m_No = m_No;
		this.title = title;
		this.content = content;
		this.onDate = onDate;
		this.inDate = inDate;
		this.delete = delete;
		this.views = views;
		this.photo = photo;
		this.route = route;
		this.answer = answer;
	}
	
	
	
	
}
