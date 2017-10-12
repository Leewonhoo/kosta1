package pro.model.dto;

import java.io.Serializable;

public class Bboard implements Serializable {
	private String bId;
	private String bNick;
	private String bPw;
	private int bNum;
	private String bTitle;
	private String bMemo;
	private String bTime;
	private int bVisit;
	private String bTag;
	
	public Bboard() { }
	
	/**
	 * @param bNick
	 * @param bNum
	 * @param bTitle
	 * @param bTime
	 * @param bVisit
	 */
	public Bboard(String bNick, int bNum, String bTitle, String bTime, int bVisit) {
		super();
		this.bNick = bNick;
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bTime = bTime;
		this.bVisit = bVisit;
	}

	/**
	 * @param bId
	 * @param bNick
	 * @param bPw
	 * @param bTitle
	 * @param bMemo
	 * @param bTag
	 */
	public Bboard(String bId, String bNick, String bPw, String bTitle, String bMemo, String bTag) {
		this.bId = bId;
		this.bNick = bNick;
		this.bPw = bPw;
		this.bTitle = bTitle;
		this.bMemo = bMemo;
		this.bTag = bTag;
	}

	/**
	 * @return the bId
	 */
	public String getbId() {
		return bId;
	}
	/**
	 * @param bId the bId to set
	 */
	public void setbId(String bId) {
		this.bId = bId;
	}
	/**
	 * @return the bNick
	 */
	public String getbNick() {
		return bNick;
	}
	/**
	 * @param bNick the bNick to set
	 */
	public void setbNick(String bNick) {
		this.bNick = bNick;
	}
	/**
	 * @return the bPw
	 */
	public String getbPw() {
		return bPw;
	}
	/**
	 * @param bPw the bPw to set
	 */
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	/**
	 * @return the bNum
	 */
	public int getbNum() {
		return bNum;
	}
	/**
	 * @param bNum the bNum to set
	 */
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	/**
	 * @return the bTitle
	 */
	public String getbTitle() {
		return bTitle;
	}
	/**
	 * @param bTitle the bTitle to set
	 */
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	/**
	 * @return the bMemo
	 */
	public String getbMemo() {
		return bMemo;
	}
	/**
	 * @param bMemo the bMemo to set
	 */
	public void setbMemo(String bMemo) {
		this.bMemo = bMemo;
	}
	/**
	 * @return the bTime
	 */
	public String getbTime() {
		return bTime;
	}
	/**
	 * @param bTime the bTime to set
	 */
	public void setbTime(String bTime) {
		this.bTime = bTime;
	}
	/**
	 * @return the bVisit
	 */
	public int getbVisit() {
		return bVisit;
	}
	/**
	 * @param bVisit the bVisit to set
	 */
	public void setbVisit(int bVisit) {
		this.bVisit = bVisit;
	}
	/**
	 * @return the bTag
	 */
	public String getbTag() {
		return bTag;
	}
	/**
	 * @param bTag the bTag to set
	 */
	public void setbTag(String bTag) {
		this.bTag = bTag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (bId != null) {
			builder.append(bId);
			builder.append(", ");
		}
		if (bNick != null) {
			builder.append(bNick);
			builder.append(", ");
		}
		if (bPw != null) {
			builder.append(bPw);
			builder.append(", ");
		}
		if (bNum > -1) {
			builder.append(bNum);
			builder.append(", ");
		}
		if (bTitle != null) {
			builder.append(bTitle);
			builder.append(", ");
		}
		if (bMemo != null) {
			builder.append(bMemo);
			builder.append(", ");
		}
		if (bTime != null) {
			builder.append(bTime);
			builder.append(", ");
		}
		if (bVisit > -1) {
			builder.append(bVisit);
			builder.append(", ");
		}
		if (bTag != null) {
			builder.append(bTag);
		}
		return builder.toString();
	}

	
	
}
