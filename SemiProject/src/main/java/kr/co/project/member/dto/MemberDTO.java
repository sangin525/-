package kr.co.project.member.dto;

public class MemberDTO {
	private int no;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String addr;
	private String birth;
	private String inDate;
	private String deleteDate;
	private int mlg;
	

	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MemberDTO(String phone, String email, String addr, String birth) {
		super();
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.birth = birth;
	}



	public MemberDTO(int no, String id, String pwd, String name, String phone, String email, String addr, String birth,
			String inDate, String deleteDate, int mlg) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.birth = birth;
		this.inDate = inDate;
		this.deleteDate = deleteDate;
		this.mlg = mlg;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getMlg() {
		return mlg;
	}
	public void setMlg(int mlg) {
		this.mlg = mlg;
	}
	
	
	
	
	
	
}
