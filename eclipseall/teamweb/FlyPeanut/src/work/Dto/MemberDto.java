package work.Dto;

import java.io.Serializable;

public class MemberDto implements Serializable{
	private String id;
	private String pw;
	private String kName;
	private String eLastName;
	private String eFristName;
	private String birth;
	private String sex;
	private String nation;
	private String mobile;
	private String email;
	private String sms;
	private String eCheck;
	private String address;
	private String grade;
	private int mile;
	private int totalMile;
	
	public MemberDto() { }
	
	public MemberDto(String id, String pw, String kName, String eLastName, String eFristName, String birth, String sex,
			String nation, String mobile, String email, String sms, String eCheck) {
		super();
		this.id = id;
		this.pw = pw;
		this.kName = kName;
		this.eLastName = eLastName;
		this.eFristName = eFristName;
		this.birth = birth;
		this.sex = sex;
		this.nation = nation;
		this.mobile = mobile;
		this.email = email;
		this.sms = sms;
		this.eCheck = eCheck;
	}
	
	/**
	 * @param id
	 * @param pw
	 * @param kName
	 * @param eLastName
	 * @param eFristName
	 * @param birth
	 * @param sex
	 * @param nation
	 * @param mobile
	 * @param email
	 * @param sms
	 * @param eCheck
	 * @param address
	 * @param grade
	 * @param mile
	 * @param totalMile
	 */
	public MemberDto(String id, String pw, String kName, String eLastName, String eFristName, String birth, String sex,
			String nation, String mobile, String email, String sms, String eCheck, String address, String grade,
			int mile, int totalMile) {
		super();
		this.id = id;
		this.pw = pw;
		this.kName = kName;
		this.eLastName = eLastName;
		this.eFristName = eFristName;
		this.birth = birth;
		this.sex = sex;
		this.nation = nation;
		this.mobile = mobile;
		this.email = email;
		this.sms = sms;
		this.eCheck = eCheck;
		this.address = address;
		this.grade = grade;
		this.mile = mile;
		this.totalMile = totalMile;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getkName() {
		return kName;
	}
	public void setkName(String kName) {
		this.kName = kName;
	}
	public String geteLastName() {
		return eLastName;
	}
	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}
	public String geteFristName() {
		return eFristName;
	}
	public void seteFristName(String eFristName) {
		this.eFristName = eFristName;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String geteCheck() {
		return eCheck;
	}
	public void seteCheck(String eCheck) {
		this.eCheck = eCheck;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMile() {
		return mile;
	}
	public void setMile(int mile) {
		this.mile = mile;
	}
	public int getTotalMile() {
		return totalMile;
	}
	public void setTotalMile(int totalMile) {
		this.totalMile = totalMile;
	}
	
}