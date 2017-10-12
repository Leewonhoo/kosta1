package work.Dto;

import java.io.Serializable;

public class FlightDto implements Serializable{
	private String fDate;
	private int fAnum;
	private String fFname;
	private String fLeave;
	private String fLevdate;
	private String fArrive;
	private String fArridate;
	private String fGate;
	
	/**
	 * 
	 */
	public FlightDto() {
		super();
	}

	/**
	 * @param fDate
	 * @param fAnum
	 * @param fFname
	 * @param fLeave
	 * @param fLevdate
	 * @param fArrive
	 * @param fArridate
	 * @param fGate
	 */
	public FlightDto(String fDate, int fAnum, String fFname, String fLeave, String fLevdate, String fArrive,
			String fArridate, String fGate) {
		super();
		this.fDate = fDate;
		this.fAnum = fAnum;
		this.fFname = fFname;
		this.fLeave = fLeave;
		this.fLevdate = fLevdate;
		this.fArrive = fArrive;
		this.fArridate = fArridate;
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
	 * @return the fAnum
	 */
	public int getfAnum() {
		return fAnum;
	}

	/**
	 * @param fAnum the fAnum to set
	 */
	public void setfAnum(int fAnum) {
		this.fAnum = fAnum;
	}

	/**
	 * @return the fFname
	 */
	public String getfFname() {
		return fFname;
	}

	/**
	 * @param fFname the fFname to set
	 */
	public void setfFname(String fFname) {
		this.fFname = fFname;
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
	 * @return the fLevdate
	 */
	public String getfLevdate() {
		return fLevdate;
	}

	/**
	 * @param fLevdate the fLevdate to set
	 */
	public void setfLevdate(String fLevdate) {
		this.fLevdate = fLevdate;
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
	 * @return the fArridate
	 */
	public String getfArridate() {
		return fArridate;
	}

	/**
	 * @param fArridate the fArridate to set
	 */
	public void setfArridate(String fArridate) {
		this.fArridate = fArridate;
	}

	/**
	 * @return the fGate
	 */
	public String getfGate() {
		return fGate;
	}

	/**
	 * @param fGate the fGate to set
	 */
	public void setfGate(String fGate) {
		this.fGate = fGate;
	}
	
}
