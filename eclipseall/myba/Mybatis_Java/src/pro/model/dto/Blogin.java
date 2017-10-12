package pro.model.dto;

import java.io.Serializable;

public class Blogin implements Serializable {
	private String lId;
	private String lStart;
	private String lEnd;
	private String lStatus;
	private String lIp;
	
	public Blogin() { }
	
	/**
	 * @param l_id
	 * @param l_start
	 */
	public Blogin(String l_id, String l_start) {
		this.lId = l_id;
		this.lStart = l_start;
	}

	/**
	 * @param l_id
	 * @param l_start
	 * @param l_status
	 */
	public Blogin(String l_id, String l_start, String l_status) {
		this(l_id, l_start);
		this.lStatus = l_status;
	}

	/**
	 * @return the lId
	 */
	public String getlId() {
		return lId;
	}

	/**
	 * @param lId the lId to set
	 */
	public void setlId(String lId) {
		this.lId = lId;
	}

	/**
	 * @return the lStart
	 */
	public String getlStart() {
		return lStart;
	}

	/**
	 * @param lStart the lStart to set
	 */
	public void setlStart(String lStart) {
		this.lStart = lStart;
	}

	/**
	 * @return the lEnd
	 */
	public String getlEnd() {
		return lEnd;
	}

	/**
	 * @param lEnd the lEnd to set
	 */
	public void setlEnd(String lEnd) {
		this.lEnd = lEnd;
	}

	/**
	 * @return the lStatus
	 */
	public String getlStatus() {
		return lStatus;
	}

	/**
	 * @param lStatus the lStatus to set
	 */
	public void setlStatus(String lStatus) {
		this.lStatus = lStatus;
	}

	/**
	 * @return the lIp
	 */
	public String getlIp() {
		return lIp;
	}

	/**
	 * @param lIp the lIp to set
	 */
	public void setlIp(String lIp) {
		this.lIp = lIp;
	}

}
