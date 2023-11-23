package kr.co.project.member.model.dto;

public class MemberDTO {
	private String name;
	private String id;
	private String pwd;
	private String birth;
	private String email;
	private String phone;
	private String addr;
	private String addr1;
	private String addr2;
	private String indate;

	public MemberDTO(String name, String id, String pwd) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
	}

	public MemberDTO(String name, String id, String pwd, String birth, String email, String phone, String addr,
			String addr1, String addr2) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}
}
