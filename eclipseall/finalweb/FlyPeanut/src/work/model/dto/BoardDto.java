package work.model.dto;

public class BoardDto {
	private int bNum;
	private String bTitle;
	private String bContext;
	private String bWriter;
	private String bDate;
	private String bCheck;
	
	public BoardDto() { }
	
	/**
	 * @param bNum
	 * @param bTitle
	 * @param bContext
	 * @param bWriter
	 * @param bDate
	 * @param bCheck
	 */
	public BoardDto(int bNum, String bTitle, String bContext, String bWriter, String bDate, String bCheck) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bContext = bContext;
		this.bWriter = bWriter;
		this.bDate = bDate;
		this.bCheck = bCheck;
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
	 * @return the bContext
	 */
	public String getbContext() {
		return bContext;
	}

	/**
	 * @param bContext the bContext to set
	 */
	public void setbContext(String bContext) {
		this.bContext = bContext;
	}

	/**
	 * @return the bWriter
	 */
	public String getbWriter() {
		return bWriter;
	}

	/**
	 * @param bWriter the bWriter to set
	 */
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	/**
	 * @return the bDate
	 */
	public String getbDate() {
		return bDate;
	}

	/**
	 * @param bDate the bDate to set
	 */
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	/**
	 * @return the bCheck
	 */
	public String getbCheck() {
		return bCheck;
	}

	/**
	 * @param bCheck the bCheck to set
	 */
	public void setbCheck(String bCheck) {
		this.bCheck = bCheck;
	}
	
}
