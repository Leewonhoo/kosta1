package work.model.dto;

public class Bmember {
	private String mId;
	private String mPw;
	private String mName;
	private String mNick;
	private String mBirth;
	private String mPhone;
	private String mMail;
	private String mGender;
	private String mAddress;
	private int mQuest;
	private String mAnswer;

	public Bmember() { }

	/**
	 * @param m_id
	 * @param m_pw
	 */
	public Bmember(String m_id, String m_pw, String m_nick) {
		super();
		this.mId = m_id;
		this.mPw = m_pw;
		this.mNick = m_nick;
	}

	/**
	 * @param m_id
	 * @param m_name
	 * @param m_birth
	 * @param m_answer
	 */
	public Bmember(String m_id, String m_name, String m_birth, String m_answer) {
		super();
		this.mId = m_id;
		this.mName = m_name;
		this.mBirth = m_birth;
		this.mAnswer = m_answer;
	}

	/**
	 * @param m_id
	 * @param m_pw
	 * @param m_name
	 * @param m_birth
	 * @param m_answer
	 */
	public Bmember(String m_id, String m_pw, String m_name, String m_birth, String m_answer) {
		super();
		this.mId = m_id;
		this.mPw = m_pw;
		this.mName = m_name;
		this.mBirth = m_birth;
		this.mAnswer = m_answer;
	}

	/**
	 * @param mId
	 * @param mPw
	 * @param mName
	 * @param mNick
	 * @param mBirth
	 * @param mPhone
	 * @param mMail
	 * @param mGender
	 * @param mAddress
	 * @param mAnswer
	 */
	public Bmember(String mId, String mPw, String mName, String mNick, String mBirth, String mPhone, String mMail,
			String mGender, String mAddress, String mAnswer) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mNick = mNick;
		this.mBirth = mBirth;
		this.mPhone = mPhone;
		this.mMail = mMail;
		this.mGender = mGender;
		this.mAddress = mAddress;
		this.mAnswer = mAnswer;
	}

	/**
	 * @param m_id
	 * @param m_pw
	 * @param m_name
	 * @param m_nick
	 * @param m_birth
	 * @param m_phone
	 * @param m_mail
	 * @param m_gender
	 * @param m_address
	 * @param m_quest
	 * @param m_answer
	 */
	public Bmember(String m_id, String m_pw, String m_name, String m_nick, String m_birth, String m_phone,
			String m_mail, String m_gender, String m_address, int m_quest, String m_answer) {
		super();
		this.mId = m_id;
		this.mPw = m_pw;
		this.mName = m_name;
		this.mNick = m_nick;
		this.mBirth = m_birth;
		this.mPhone = m_phone;
		this.mMail = m_mail;
		this.mGender = m_gender;
		this.mAddress = m_address;
		this.mQuest = m_quest;
		this.mAnswer = m_answer;
	}

	/**
	 * @return the mId
	 */
	public String getmId() {
		return mId;
	}

	/**
	 * @param mId the mId to set
	 */
	public void setmId(String mId) {
		this.mId = mId;
	}

	/**
	 * @return the mPw
	 */
	public String getmPw() {
		return mPw;
	}

	/**
	 * @param mPw the mPw to set
	 */
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the mNick
	 */
	public String getmNick() {
		return mNick;
	}

	/**
	 * @param mNick the mNick to set
	 */
	public void setmNick(String mNick) {
		this.mNick = mNick;
	}

	/**
	 * @return the mBirth
	 */
	public String getmBirth() {
		return mBirth;
	}

	/**
	 * @param mBirth the mBirth to set
	 */
	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}

	/**
	 * @return the mPhone
	 */
	public String getmPhone() {
		return mPhone;
	}

	/**
	 * @param mPhone the mPhone to set
	 */
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	/**
	 * @return the mMail
	 */
	public String getmMail() {
		return mMail;
	}

	/**
	 * @param mMail the mMail to set
	 */
	public void setmMail(String mMail) {
		this.mMail = mMail;
	}

	/**
	 * @return the mGender
	 */
	public String getmGender() {
		return mGender;
	}

	/**
	 * @param mGender the mGender to set
	 */
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}

	/**
	 * @return the mAddress
	 */
	public String getmAddress() {
		return mAddress;
	}

	/**
	 * @param mAddress the mAddress to set
	 */
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	/**
	 * @return the mQuest
	 */
	public int getmQuest() {
		return mQuest;
	}

	/**
	 * @param mQuest the mQuest to set
	 */
	public void setmQuest(int mQuest) {
		this.mQuest = mQuest;
	}

	/**
	 * @return the mAnswer
	 */
	public String getmAnswer() {
		return mAnswer;
	}

	/**
	 * @param mAnswer the mAnswer to set
	 */
	public void setmAnswer(String mAnswer) {
		this.mAnswer = mAnswer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (mId != null) {
			builder.append(mId);
			builder.append(", ");
		}
		if (mPw != null) {
			builder.append(mPw);
			builder.append(", ");
		}
		if (mName != null) {
			builder.append(mName);
			builder.append(", ");
		}
		if (mNick != null) {
			builder.append(mNick);
			builder.append(", ");
		}
		if (mBirth != null) {
			builder.append(mBirth);
			builder.append(", ");
		}
		if (mPhone != null) {
			builder.append(mPhone);
			builder.append(", ");
		}
		if (mMail != null) {
			builder.append(mMail);
			builder.append(", ");
		}
		if (mGender != null) {
			builder.append(mGender);
			builder.append(", ");
		}
		if (mAddress != null) {
			builder.append(mAddress);
			builder.append(", ");
		}
		if (mAnswer != null) {
			builder.append(mAnswer);
		}

		return builder.toString();
	}

}
