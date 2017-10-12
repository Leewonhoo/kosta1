package work.model.dto;

import java.io.Serializable;

/**
 * ## Class 설계 규칙
 * 1. DTO Pattern
 * 	-- encapsulation : private 멤버변수, public setter(), public getter()
 *  -- 직렬화객체 : implements Serializable
 * 2. JavaBean Component
 * 	-- encapsulation : private 멤버변수, public setter(), public getter()
 *  -- setter() / getter() 메서드 이름규칙 반드시 준수 : useBean, ${}
 * 	-- default constructor()
 *  -- package
 * 
 * @author kosta
 *
 */
public class EmployeeDto implements Serializable {
	/** 직원 아이디(사번) */
	private String eId;
	/** 직원 패스워드 */
	private String ePw;
	/** 직원 한글 이름 */
	private String eKname;
	/** 직원 영문 성 */
	private String eEfname;
	/** 직원 영문 이름 */
	private String eElname;
	/** 직원 성별 */
	private String eSex;
	/** 직원 생년월일 */
	private String eBirth;
	/** 직원 핸드폰번호 */
	private String eMobile;
	/** 직원 이메일 */
	private String eEmail;
	/** 직원 주소*/
	private String eAddress;
	/**직원 상태*/
	private String eStatus;
	
	public EmployeeDto() {}
	
	public EmployeeDto(String eId, String ePw, String eKname, String eEfname, String eElname, String eSex,
			String eBirth, String eMobile, String eEmail, String eAddress, String eStatus) {
		this.eId = eId;
		this.ePw = ePw;
		this.eKname = eKname;
		this.eEfname = eEfname;
		this.eElname = eElname;
		this.eSex = eSex;
		this.eBirth = eBirth;
		this.eMobile = eMobile;
		this.eEmail = eEmail;
		this.eAddress = eAddress;
		this.eStatus = eStatus;
	}

	public EmployeeDto(String eId, String ePw, String eKname, String eEfname, String eElname, String eSex,
			String eBirth, String eMobile, String eEmail, String eAddress) {
		super();
		this.eId = eId;
		this.ePw = ePw;
		this.eKname = eKname;
		this.eEfname = eEfname;
		this.eElname = eElname;
		this.eSex = eSex;
		this.eBirth = eBirth;
		this.eMobile = eMobile;
		this.eEmail = eEmail;
		this.eAddress = eAddress;
	}

	/**
	 * @return the eId
	 */
	public String geteId() {
		return eId;
	}

	/**
	 * @param eId the eId to set
	 */
	public void seteId(String eId) {
		this.eId = eId;
	}

	/**
	 * @return the ePw
	 */
	public String getePw() {
		return ePw;
	}

	/**
	 * @param ePw the ePw to set
	 */
	public void setePw(String ePw) {
		this.ePw = ePw;
	}

	/**
	 * @return the eKname
	 */
	public String geteKname() {
		return eKname;
	}

	/**
	 * @return the eAddress
	 */
	public String geteAddress() {
		return eAddress;
	}


	/**
	 * @param eAddress the eAddress to set
	 */
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}


	/**
	 * @param eKname the eKname to set
	 */
	public void seteKname(String eKname) {
		this.eKname = eKname;
	}

	/**
	 * @return the eEfname
	 */
	public String geteEfname() {
		return eEfname;
	}

	/**
	 * @param eEfname the eEfname to set
	 */
	public void seteEfname(String eEfname) {
		this.eEfname = eEfname;
	}

	/**
	 * @return the eElname
	 */
	public String geteElname() {
		return eElname;
	}

	/**
	 * @param eElname the eElname to set
	 */
	public void seteElname(String eElname) {
		this.eElname = eElname;
	}

	/**
	 * @return the eSex
	 */
	public String geteSex() {
		return eSex;
	}

	/**
	 * @param eSex the eSex to set
	 */
	public void seteSex(String eSex) {
		this.eSex = eSex;
	}

	/**
	 * @return the eBirth
	 */
	public String geteBirth() {
		return eBirth;
	}

	/**
	 * @param eBirth the eBirth to set
	 */
	public void seteBirth(String eBirth) {
		this.eBirth = eBirth;
	}

	/**
	 * @return the eMobile
	 */
	public String geteMobile() {
		return eMobile;
	}

	/**
	 * @param eMobile the eMobile to set
	 */
	public void seteMobile(String eMobile) {
		this.eMobile = eMobile;
	}

	/**
	 * @return the eEmail
	 */
	public String geteEmail() {
		return eEmail;
	}

	/**
	 * @param eEmail the eEmail to set
	 */
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	
	/**
	 * @return the eState
	 */
	public String geteStatus() {
		return eStatus;
	}

	/**
	 * @param eState the eState to set
	 */
	public void seteState(String eStatus) {
		this.eStatus = eStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eId == null) ? 0 : eId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDto other = (EmployeeDto) obj;
		if (eId == null) {
			if (other.eId != null)
				return false;
		} else if (!eId.equals(other.eId))
			return false;
		return true;
	} 


}
