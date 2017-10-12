package work.model.dto;

public class Bboard {
	private String bId;
	private String bNick;
	private String bPw;
	private int bNum;
	private String bTitle;
	private String bMemo;
	private String bTime;
	private int bVisit;
	private String bTag;
	
	private int bSelect;
	private int bTotal;
	private int bPage;
	
	public Bboard() { }
	
	public Bboard(int bSelect, int bPage, int bTotal) {
		this.bSelect = bSelect;
		this.bPage = bPage;
		this.bTotal = bTotal;
	}

	/**
	 * @param bNick
	 * @param bNum
	 * @param bTitle
	 * @param bTime
	 * @param bVisit
	 */
	public Bboard(String bNick, int bNum, String bTitle, String bTime, int bVisit) {
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
	
	
	/**
	 * @return bSelect
	 */
	public int getbSelect() {
		return bSelect;
	}
	/**
	 * @param bSelect
	 */
	public void setbSelect(int bSelect) {
		this.bSelect = bSelect;
	}
	/**
	 * @return bPage
	 */
	public int getbPage() {
		return bPage;
	}
	/**
	 * @param bPage
	 */
	public void setbPage(int bPage) {
		this.bPage = bPage;
	}
	/**
	 * @return bTotal
	 */
	public int getbTotal() {
		return bTotal;
	}
	/**
	 * @param bTotal
	 */
	public void setbTotal(int bTotal) {
		this.bTotal = bTotal;
	}
	
}
