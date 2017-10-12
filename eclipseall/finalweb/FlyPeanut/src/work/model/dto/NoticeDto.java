package work.model.dto;

public class NoticeDto {

	private int nNum;
	private String nTitle;
	private String nContents;
	private String nDate;
	
	public NoticeDto() {
		
	}

	/**
	 * @param nNum
	 * @param nTitle
	 * @param nContents
	 * @param nDate
	 */
	public NoticeDto(int nNum, String nTitle, String nContents, String nDate) {
		super();
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContents = nContents;
		this.nDate = nDate;
	}

	/**
	 * @return the nNum
	 */
	public int getnNum() {
		return nNum;
	}

	/**
	 * @param nNum the nNum to set
	 */
	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	/**
	 * @return the nTitle
	 */
	public String getnTitle() {
		return nTitle;
	}

	/**
	 * @param nTitle the nTitle to set
	 */
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	/**
	 * @return the nContents
	 */
	public String getnContents() {
		return nContents;
	}

	/**
	 * @param nContents the nContents to set
	 */
	public void setnContents(String nContents) {
		this.nContents = nContents;
	}

	/**
	 * @return the nDate
	 */
	public String getnDate() {
		return nDate;
	}

	/**
	 * @param nDate the nDate to set
	 */
	public void setnDate(String nDate) {
		this.nDate = nDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NoticeDto [nNum=" + nNum + ", nTitle=" + nTitle + ", nContents=" + nContents + ", nDate=" + nDate + "]";
	}

	


	
	
}
