// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bmember.java

package work.model.dto;


public class Bmember
{

    public Bmember()
    {
    }

    public Bmember(String m_id, String m_pw, String m_nick)
    {
        mId = m_id;
        mPw = m_pw;
        mNick = m_nick;
    }

    public Bmember(String m_id, String m_name, String m_birth, String m_answer)
    {
        mId = m_id;
        mName = m_name;
        mBirth = m_birth;
        mAnswer = m_answer;
    }

    public Bmember(String m_id, String m_pw, String m_name, String m_birth, String m_answer)
    {
        mId = m_id;
        mPw = m_pw;
        mName = m_name;
        mBirth = m_birth;
        mAnswer = m_answer;
    }

    public Bmember(String mId, String mPw, String mName, String mNick, String mBirth, String mPhone, String mMail, 
            String mGender, String mAddress, String mAnswer)
    {
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

    public Bmember(String m_id, String m_pw, String m_name, String m_nick, String m_birth, String m_phone, String m_mail, 
            String m_gender, String m_address, int m_quest, String m_answer)
    {
        mId = m_id;
        mPw = m_pw;
        mName = m_name;
        mNick = m_nick;
        mBirth = m_birth;
        mPhone = m_phone;
        mMail = m_mail;
        mGender = m_gender;
        mAddress = m_address;
        mQuest = m_quest;
        mAnswer = m_answer;
    }

    public String getmId()
    {
        return mId;
    }

    public void setmId(String mId)
    {
        this.mId = mId;
    }

    public String getmPw()
    {
        return mPw;
    }

    public void setmPw(String mPw)
    {
        this.mPw = mPw;
    }

    public String getmName()
    {
        return mName;
    }

    public void setmName(String mName)
    {
        this.mName = mName;
    }

    public String getmNick()
    {
        return mNick;
    }

    public void setmNick(String mNick)
    {
        this.mNick = mNick;
    }

    public String getmBirth()
    {
        return mBirth;
    }

    public void setmBirth(String mBirth)
    {
        this.mBirth = mBirth;
    }

    public String getmPhone()
    {
        return mPhone;
    }

    public void setmPhone(String mPhone)
    {
        this.mPhone = mPhone;
    }

    public String getmMail()
    {
        return mMail;
    }

    public void setmMail(String mMail)
    {
        this.mMail = mMail;
    }

    public String getmGender()
    {
        return mGender;
    }

    public void setmGender(String mGender)
    {
        this.mGender = mGender;
    }

    public String getmAddress()
    {
        return mAddress;
    }

    public void setmAddress(String mAddress)
    {
        this.mAddress = mAddress;
    }

    public int getmQuest()
    {
        return mQuest;
    }

    public void setmQuest(int mQuest)
    {
        this.mQuest = mQuest;
    }

    public String getmAnswer()
    {
        return mAnswer;
    }

    public void setmAnswer(String mAnswer)
    {
        this.mAnswer = mAnswer;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        if(mId != null)
        {
            builder.append(mId);
            builder.append(", ");
        }
        if(mPw != null)
        {
            builder.append(mPw);
            builder.append(", ");
        }
        if(mName != null)
        {
            builder.append(mName);
            builder.append(", ");
        }
        if(mNick != null)
        {
            builder.append(mNick);
            builder.append(", ");
        }
        if(mBirth != null)
        {
            builder.append(mBirth);
            builder.append(", ");
        }
        if(mPhone != null)
        {
            builder.append(mPhone);
            builder.append(", ");
        }
        if(mMail != null)
        {
            builder.append(mMail);
            builder.append(", ");
        }
        if(mGender != null)
        {
            builder.append(mGender);
            builder.append(", ");
        }
        if(mAddress != null)
        {
            builder.append(mAddress);
            builder.append(", ");
        }
        if(mAnswer != null)
            builder.append(mAnswer);
        return builder.toString();
    }

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
}
