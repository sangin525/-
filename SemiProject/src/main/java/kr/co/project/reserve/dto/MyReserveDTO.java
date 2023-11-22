package kr.co.project.reserve.dto;

public class MyReserveDTO {
	private int r_no; // 예약번호
	private int per_no;
	private String checkIn;
	private String checkOut;
	private int count;
	private String m_name;
	private int room_no;
	
	
	
	
	public MyReserveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyReserveDTO(int r_no, int per_no, String checkIn, String checkOut, int count, String m_name, int room_no) {
		super();
		this.r_no = r_no;
		this.per_no = per_no;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.count = count;
		this.m_name = m_name;
		this.room_no = room_no;
	}
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getPer_no() {
		return per_no;
	}
	public void setPer_no(int per_no) {
		this.per_no = per_no;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	
	

}
