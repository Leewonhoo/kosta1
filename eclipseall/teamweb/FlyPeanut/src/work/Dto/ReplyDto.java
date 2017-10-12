package work.Dto;

import java.io.Serializable;

public class ReplyDto implements Serializable{
	private int rNum;
	private String rContent;
	private String rDate;
	
	public ReplyDto() {
		super();
	}

	/**
	 * @param bNum
	 * @param rContent
	 * @param rDate
	 */
	public ReplyDto(int bNum, String rContent, String rDate) {
		super();
		this.rNum = bNum;
		this.rContent = rContent;
		this.rDate = rDate;
	}

	/**
	 * @return the bNum
	 */
	public int getbNum() {
		return rNum;
	}

	/**
	 * @param bNum the bNum to set
	 */
	public void setbNum(int bNum) {
		this.rNum = bNum;
	}

	/**
	 * @return the rContent
	 */
	public String getrContent() {
		return rContent;
	}

	/**
	 * @param rContent the rContent to set
	 */
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	/**
	 * @return the rDate
	 */
	public String getrDate() {
		return rDate;
	}

	/**
	 * @param rDate the rDate to set
	 */
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	
}
