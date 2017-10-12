package work.model.dto;


/*
 CREATE TABLE FLIGHT 
(
  F_DATE DATE 
, F_ANUM NUMBER 
, F_FNAME VARCHAR2(8) 
, F_LEAVE VARCHAR2(20) 
, F_LEVDATE DATE 
, F_ARRIVE VARCHAR2(20) 
, F_ARRIDATE DATE 
, F_GATE NUMBER(5) 
);
 
 */
public class FlightDto {
	
	private String fDate;
	private int fANum;
	private String fFName;
	private String fLeave;
	private String fLeaveDate;
	private String fArrive;
	private String fArriveDate;
	private int fGate;
	
	public FlightDto() {
		
	}

	/**
	 * @param fDate
	 * @param fANum
	 * @param fFName
	 * @param fLeave
	 * @param fLeaveDate
	 * @param fArrive
	 * @param fArriveDate
	 * @param fGate
	 */
	public FlightDto(String fDate, int fANum, String fFName, String fLeave, String fLeaveDate, String fArrive,
			String fArriveDate, int fGate) {
		super();
		this.fDate = fDate;
		this.fANum = fANum;
		this.fFName = fFName;
		this.fLeave = fLeave;
		this.fLeaveDate = fLeaveDate;
		this.fArrive = fArrive;
		this.fArriveDate = fArriveDate;
		this.fGate = fGate;
	}

	/**
	 * @return the fDate
	 */
	public String getfDate() {
		return fDate;
	}

	/**
	 * @param fDate the fDate to set
	 */
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	/**
	 * @return the fANum
	 */
	public int getfANum() {
		return fANum;
	}

	/**
	 * @param fANum the fANum to set
	 */
	public void setfANum(int fANum) {
		this.fANum = fANum;
	}

	/**
	 * @return the fFName
	 */
	public String getfFName() {
		return fFName;
	}

	/**
	 * @param fFName the fFName to set
	 */
	public void setfFName(String fFName) {
		this.fFName = fFName;
	}

	/**
	 * @return the fLeave
	 */
	public String getfLeave() {
		return fLeave;
	}

	/**
	 * @param fLeave the fLeave to set
	 */
	public void setfLeave(String fLeave) {
		this.fLeave = fLeave;
	}

	/**
	 * @return the fLeaveDate
	 */
	public String getfLeaveDate() {
		return fLeaveDate;
	}

	/**
	 * @param fLeaveDate the fLeaveDate to set
	 */
	public void setfLeaveDate(String fLeaveDate) {
		this.fLeaveDate = fLeaveDate;
	}

	/**
	 * @return the fArrive
	 */
	public String getfArrive() {
		return fArrive;
	}

	/**
	 * @param fArrive the fArrive to set
	 */
	public void setfArrive(String fArrive) {
		this.fArrive = fArrive;
	}

	/**
	 * @return the fArriveDate
	 */
	public String getfArriveDate() {
		return fArriveDate;
	}

	/**
	 * @param fArriveDate the fArriveDate to set
	 */
	public void setfArriveDate(String fArriveDate) {
		this.fArriveDate = fArriveDate;
	}

	/**
	 * @return the fGate
	 */
	public int getfGate() {
		return fGate;
	}

	/**
	 * @param fGate the fGate to set
	 */
	public void setfGate(int fGate) {
		this.fGate = fGate;
	}
	

}
