package work.model.dto;


/*
  A_NUM NUMBER     고유번호 6자리, KEY 직접입력
, A_KIND VARCHAR2(10) 
, A_TYPE VARCHAR2(7) 
, A_PAX NUMBER 
, A_MDATE DATE 
, A_MAKE VARCHAR2(20) 
, A_STATE VARCHAR2(2) 
, A_FIRROW NUMBER  10
, A_FIRCOL VARCHAR2(2)  A
, A_BINROW NUMBER 
, A_BINCOL VARCHAR2(2) 
, A_ECOROW NUMBER 
, A_ECOCOL VARCHAR2(2) 
 * 
 */
public class AirplaneDto {
	
	private int aNum;
	private String aKind;
	private String aType;
	private int aPax;
	private String aMdate;
	private String aMake;
	private String aState;
	private int aFirstRow;
	private String aFirstCol;
	private int aBusinessRow;
	private String aBusinessCol;
	private int aEconomyRow;
	private String aEconomyCol;
	
	public AirplaneDto() {
		
	}

	/**
	 * @param aNum
	 * @param aKind
	 * @param aType
	 * @param aPax
	 * @param aMdate
	 * @param aMake
	 * @param aState
	 * @param aFirstRow
	 * @param aFirstCol
	 * @param aBusinessRow
	 * @param aBusinessCol
	 * @param aEconomyRow
	 * @param aEconomyCol
	 */
	public AirplaneDto(int aNum, String aKind, String aType, int aPax, String aMdate, String aMake, String aState,
			int aFirstRow, String aFirstCol, int aBusinessRow, String aBusinessCol, int aEconomyRow,
			String aEconomyCol) {
		super();
		this.aNum = aNum;
		this.aKind = aKind;
		this.aType = aType;
		this.aPax = aPax;
		this.aMdate = aMdate;
		this.aMake = aMake;
		this.aState = aState;
		this.aFirstRow = aFirstRow;
		this.aFirstCol = aFirstCol;
		this.aBusinessRow = aBusinessRow;
		this.aBusinessCol = aBusinessCol;
		this.aEconomyRow = aEconomyRow;
		this.aEconomyCol = aEconomyCol;
	}

	/**
	 * @return the aNum
	 */
	public int getaNum() {
		return aNum;
	}

	/**
	 * @param aNum the aNum to set
	 */
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}

	/**
	 * @return the aKind
	 */
	public String getaKind() {
		return aKind;
	}

	/**
	 * @param aKind the aKind to set
	 */
	public void setaKind(String aKind) {
		this.aKind = aKind;
	}

	/**
	 * @return the aType
	 */
	public String getaType() {
		return aType;
	}

	/**
	 * @param aType the aType to set
	 */
	public void setaType(String aType) {
		this.aType = aType;
	}

	/**
	 * @return the aPax
	 */
	public int getaPax() {
		return aPax;
	}

	/**
	 * @param aPax the aPax to set
	 */
	public void setaPax(int aPax) {
		this.aPax = aPax;
	}

	/**
	 * @return the aMdate
	 */
	public String getaMdate() {
		return aMdate;
	}

	/**
	 * @param aMdate the aMdate to set
	 */
	public void setaMdate(String aMdate) {
		this.aMdate = aMdate;
	}

	/**
	 * @return the aMake
	 */
	public String getaMake() {
		return aMake;
	}

	/**
	 * @param aMake the aMake to set
	 */
	public void setaMake(String aMake) {
		this.aMake = aMake;
	}

	/**
	 * @return the aState
	 */
	public String getaState() {
		return aState;
	}

	/**
	 * @param aState the aState to set
	 */
	public void setaState(String aState) {
		this.aState = aState;
	}

	/**
	 * @return the aFirstRow
	 */
	public int getaFirstRow() {
		return aFirstRow;
	}

	/**
	 * @param aFirstRow the aFirstRow to set
	 */
	public void setaFirstRow(int aFirstRow) {
		this.aFirstRow = aFirstRow;
	}

	/**
	 * @return the aFirstCol
	 */
	public String getaFirstCol() {
		return aFirstCol;
	}

	/**
	 * @param aFirstCol the aFirstCol to set
	 */
	public void setaFirstCol(String aFirstCol) {
		this.aFirstCol = aFirstCol;
	}

	/**
	 * @return the aBusinessRow
	 */
	public int getaBusinessRow() {
		return aBusinessRow;
	}

	/**
	 * @param aBusinessRow the aBusinessRow to set
	 */
	public void setaBusinessRow(int aBusinessRow) {
		this.aBusinessRow = aBusinessRow;
	}

	/**
	 * @return the aBusinessCol
	 */
	public String getaBusinessCol() {
		return aBusinessCol;
	}

	/**
	 * @param aBusinessCol the aBusinessCol to set
	 */
	public void setaBusinessCol(String aBusinessCol) {
		this.aBusinessCol = aBusinessCol;
	}

	/**
	 * @return the aEconomyRow
	 */
	public int getaEconomyRow() {
		return aEconomyRow;
	}

	/**
	 * @param aEconomyRow the aEconomyRow to set
	 */
	public void setaEconomyRow(int aEconomyRow) {
		this.aEconomyRow = aEconomyRow;
	}

	/**
	 * @return the aEconomyCol
	 */
	public String getaEconomyCol() {
		return aEconomyCol;
	}

	/**
	 * @param aEconomyCol the aEconomyCol to set
	 */
	public void setaEconomyCol(String aEconomyCol) {
		this.aEconomyCol = aEconomyCol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirplaneDto [aNum=");
		builder.append(aNum);
		builder.append(", aKind=");
		builder.append(aKind);
		builder.append(", aType=");
		builder.append(aType);
		builder.append(", aPax=");
		builder.append(aPax);
		builder.append(", aMdate=");
		builder.append(aMdate);
		builder.append(", aMake=");
		builder.append(aMake);
		builder.append(", aState=");
		builder.append(aState);
		builder.append(", aFirstRow=");
		builder.append(aFirstRow);
		builder.append(", aFirstCol=");
		builder.append(aFirstCol);
		builder.append(", aBusinessRow=");
		builder.append(aBusinessRow);
		builder.append(", aBusinessCol=");
		builder.append(aBusinessCol);
		builder.append(", aEconomyRow=");
		builder.append(aEconomyRow);
		builder.append(", aEconomyCol=");
		builder.append(aEconomyCol);
		builder.append("]");
		return builder.toString();
	}

	
}
