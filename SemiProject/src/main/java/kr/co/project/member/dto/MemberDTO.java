package kr.co.project.member.dto;

public class MemberDTO {
	private int no;
	private String name;
	private String id;
	private String pwd;
	private String birth;
	private String email;
	private String phone;
	private String addr;
	private String addr1;
	private String addr2;
	private String inDate;
	private String deleteDate;
	private int mlg;
	private String newPwd;
	private String admin;
	private String snsCheckbox;
	private String membership;
	private int accAmount;
	

	public int getAccAmount() {
		return accAmount;
	}

	public void setAccAmount(int accAmount) {
		this.accAmount = accAmount;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public MemberDTO(String phone, String email, String addr, String addr1, String addr2) {
		super();
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.addr1 = addr1;
		this.addr2 = addr2;
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

	public String getSnsCheckbox() {
		return snsCheckbox;
	}

	public void setSnsCheckbox(String snsCheckbox) {
		this.snsCheckbox = snsCheckbox;
	}

	public MemberDTO(String name, String id, String pwd, String birth, String email, String phone, String addr,
			String addr1, String addr2, String snsCheckbox) {
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
		this.snsCheckbox = snsCheckbox;
	}

	public MemberDTO(String id, String pwd, String newPwd) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.newPwd = newPwd;
	}

	public MemberDTO(String pwd) {
		super();
		this.pwd = pwd;
	}

	public MemberDTO(String pwd, String newPwd) {
		super();
		this.pwd = pwd;
		this.newPwd = newPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
