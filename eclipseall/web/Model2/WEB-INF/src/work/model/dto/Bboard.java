// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bboard.java

package work.model.dto;


public class Bboard
{

    public Bboard()
    {
    }

    public Bboard(String bNick, int bNum, String bTitle, String bTime, int bVisit)
    {
        this.bNick = bNick;
        this.bNum = bNum;
        this.bTitle = bTitle;
        this.bTime = bTime;
        this.bVisit = bVisit;
    }

    public Bboard(String bId, String bNick, String bPw, String bTitle, String bMemo, String bTag)
    {
        this.bId = bId;
        this.bNick = bNick;
        this.bPw = bPw;
        this.bTitle = bTitle;
        this.bMemo = bMemo;
        this.bTag = bTag;
    }

    public String getbId()
    {
        return bId;
    }

    public void setbId(String bId)
    {
        this.bId = bId;
    }

    public String getbNick()
    {
        return bNick;
    }

    public void setbNick(String bNick)
    {
        this.bNick = bNick;
    }

    public String getbPw()
    {
        return bPw;
    }

    public void setbPw(String bPw)
    {
        this.bPw = bPw;
    }

    public int getbNum()
    {
        return bNum;
    }

    public void setbNum(int bNum)
    {
        this.bNum = bNum;
    }

    public String getbTitle()
    {
        return bTitle;
    }

    public void setbTitle(String bTitle)
    {
        this.bTitle = bTitle;
    }

    public String getbMemo()
    {
        return bMemo;
    }

    public void setbMemo(String bMemo)
    {
        this.bMemo = bMemo;
    }

    public String getbTime()
    {
        return bTime;
    }

    public void setbTime(String bTime)
    {
        this.bTime = bTime;
    }

    public int getbVisit()
    {
        return bVisit;
    }

    public void setbVisit(int bVisit)
    {
        this.bVisit = bVisit;
    }

    public String getbTag()
    {
        return bTag;
    }

    public void setbTag(String bTag)
    {
        this.bTag = bTag;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        if(bId != null)
        {
            builder.append(bId);
            builder.append(", ");
        }
        if(bNick != null)
        {
            builder.append(bNick);
            builder.append(", ");
        }
        if(bPw != null)
        {
            builder.append(bPw);
            builder.append(", ");
        }
        if(bNum > -1)
        {
            builder.append(bNum);
            builder.append(", ");
        }
        if(bTitle != null)
        {
            builder.append(bTitle);
            builder.append(", ");
        }
        if(bMemo != null)
        {
            builder.append(bMemo);
            builder.append(", ");
        }
        if(bTime != null)
        {
            builder.append(bTime);
            builder.append(", ");
        }
        if(bVisit > -1)
        {
            builder.append(bVisit);
            builder.append(", ");
        }
        if(bTag != null)
            builder.append(bTag);
        return builder.toString();
    }

    private String bId;
    private String bNick;
    private String bPw;
    private int bNum;
    private String bTitle;
    private String bMemo;
    private String bTime;
    private int bVisit;
    private String bTag;
}
