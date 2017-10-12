// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Blogin.java

package work.model.dto;


public class Blogin
{

    public Blogin()
    {
    }

    public Blogin(String l_id, String l_start)
    {
        lId = l_id;
        lStart = l_start;
    }

    public Blogin(String l_id, String l_start, String l_status)
    {
        this(l_id, l_start);
        lStatus = l_status;
    }

    public String getlId()
    {
        return lId;
    }

    public void setlId(String lId)
    {
        this.lId = lId;
    }

    public String getlStart()
    {
        return lStart;
    }

    public void setlStart(String lStart)
    {
        this.lStart = lStart;
    }

    public String getlEnd()
    {
        return lEnd;
    }

    public void setlEnd(String lEnd)
    {
        this.lEnd = lEnd;
    }

    public String getlStatus()
    {
        return lStatus;
    }

    public void setlStatus(String lStatus)
    {
        this.lStatus = lStatus;
    }

    public String getlIp()
    {
        return lIp;
    }

    public void setlIp(String lIp)
    {
        this.lIp = lIp;
    }

    private String lId;
    private String lStart;
    private String lEnd;
    private String lStatus;
    private String lIp;
}
